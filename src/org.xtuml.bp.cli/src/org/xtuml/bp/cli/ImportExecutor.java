package org.xtuml.bp.cli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;
import org.xtuml.bp.core.SystemModel_c;
import org.xtuml.bp.core.ui.preferences.BridgePointProjectPreferences;
import org.xtuml.bp.core.ui.preferences.BridgePointProjectReferencesPreferences;
import org.xtuml.bp.utilities.ui.ProjectUtilities;

public class ImportExecutor implements Executor {
    
    private BPCLIPreferences cmdLine;

    private String projectPath;
    private IProject project;
    private String filePath;
    private String targetProjectName;
    private String targetWorkingPath;

    protected ImportExecutor(BPCLIPreferences prefs) {
        cmdLine = prefs;
        projectPath = cmdLine.getStringValue("-project");
        filePath = cmdLine.getStringValue("-file");
        targetProjectName = cmdLine.getStringValue("-targetProject");
        targetWorkingPath = cmdLine.getStringValue("-workingPath");
    }

    public void execute() {
        try {
            if (!projectPath.isEmpty()) {
                importProject();
            } else if (!filePath.isEmpty()) {
                importFile();
            } else {
                throw new BPCLIException("You must specify either a project or file to import.");
            }
            
            if ( project != null) {
            	SystemModel_c sys = ProjectUtilities.getSystemModel(project);
            	sys.getPersistableComponent().persistSelfAndChildren();
            }
        } catch (CoreException e) {
            System.err.println(e.getMessage());
        } catch (BPCLIException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void importProject() throws CoreException, BPCLIException, IOException {
        // Verify the source exists and is a Folder
        File source = new File(projectPath);
        if(!source.exists() || !source.isDirectory()) {
            throw new BPCLIException("The source project does not exist.");
        }
        // Verify the destination exists and is a Folder
        if (!targetWorkingPath.isEmpty()) {
            File destination = new File(targetWorkingPath);
            if(destination.exists()) {
                if (!destination.isDirectory()) {
                    throw new BPCLIException("The destination does not exist.");
                }
            }
        }
        // Get the source project
        String projectName = targetProjectName;
        if (projectName.isEmpty()) {
        	projectName = getProjectNameFromPath();
        }
        project = ResourcesPlugin.getWorkspace().getRoot()
                .getProject(projectName);

        // delete an existing project
        if (project.exists()) {
            if (cmdLine.getBooleanValue("-deleteExisting")) {
                System.out.println("Deleting existing project...");
                project.delete(true, true, new NullProgressMonitor());
            } else {
                throw new BPCLIException("The project to be imported already exists in the workspace. Use the -deleteExisting flag to overwrite it.");
            }
        } 

        final IProjectDescription description = ResourcesPlugin.getWorkspace().newProjectDescription(project.getName());
        if (!targetWorkingPath.isEmpty()) {
            IPath workingPath = new Path(targetWorkingPath);
            description.setLocation(workingPath);
        }
        // create the project
        project.create(description, new NullProgressMonitor());
        System.out.println("Importing project: " + projectName);
        // Copy source project contents
        copyFolder(new File(projectPath), project.getLocation().toFile());
        project.open(new NullProgressMonitor());
        // force refresh of the description
        description.setLocation(project.getLocation().append("/.project"));
        project.setDescription(description, new NullProgressMonitor());

        prepareProject( project );
    }

    private void copyFolder(File src, File dest) throws IOException {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }
            String files[] = src.list();
            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                copyFolder(srcFile, destFile);
            }
        } else {
            if (!dest.exists()) {
                dest.createNewFile();
            }
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
        }        
    }

    private String getProjectNameFromPath() {
        Path path = new Path(projectPath);
        return path.lastSegment();
    }

    private void importFile() throws CoreException, BPCLIException, IOException {
        // verifier the specified file exists
        File sourceFile = new File(filePath);
        if(!sourceFile.exists() || !sourceFile.isFile()) {
            throw new BPCLIException("The source file does not exist.");
        }
        // Verify the destination exists and is a Folder
        if (!targetWorkingPath.isEmpty()) {
            File destination = new File(targetWorkingPath);
            if(destination.exists()) {
                if (!destination.isDirectory()) {
                    throw new BPCLIException("The destination does not exist.");
                }
            }
        }
        String projectName = targetProjectName;
        if (projectName.isEmpty()) {
            // No target project given, use the name of the file as the project name
            projectName = sourceFile.getName();
            projectName = FilenameUtils.removeExtension(projectName); 
        }
        
        project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

        // Check for delete existing project
        if (project.exists()) {
            if (cmdLine.getBooleanValue("-deleteExisting")) {
                System.out.println("Deleting existing project...");
                project.delete(true, true, new NullProgressMonitor());
            }
        } 
        // Check to see if a new project needs to be created.
        if (!project.exists()) {
            System.out.println("Creating project...");
            project = ProjectUtilities.createProjectNoUI(projectName, targetWorkingPath);
        }
        
        System.out.println("Importing file into project: " + projectName);
        prepareProject( project );
    
        // Import the file into the project
        SystemModel_c systemModel = ProjectUtilities.getSystemModel(project);
        System.out.println("The system model is " + systemModel.getName());
        try {
            project.open(new NullProgressMonitor());
            project.refreshLocal(IResource.DEPTH_INFINITE, null);
            
            boolean reconcileGraphics = false;
            Boolean reconcileGraphicsOption = cmdLine.getBooleanValue("-reconcileGraphics");
            if(reconcileGraphicsOption != null) {
            	reconcileGraphics = reconcileGraphicsOption.booleanValue();
            }

            System.out.println("Proceeding with import of " + filePath);
            boolean setupSucceeded = ProjectUtilities.importModelWithoutWizard(systemModel, filePath, reconcileGraphics);
            if(!setupSucceeded) {
                throw new BPCLIException("The import process failed.");
            }

            project.refreshLocal(IResource.DEPTH_INFINITE, null);
            
        } catch (CoreException e) {
            System.out.println(e.toString());
        } catch (BPCLIException e) {
            System.out.println(e.toString());
        }
    }
    
    private void prepareProject( IProject project ) {
        // set IPR preference
        if (cmdLine.getBooleanValue("-allowIPRs")) {
            System.out.println("Enabling IPRs...");
	        IScopeContext projectScope = new ProjectScope(project);
			Preferences projectNode = projectScope.getNode(
			    BridgePointProjectPreferences.BP_PROJECT_PREFERENCES_ID);
		    projectNode.putBoolean(BridgePointProjectReferencesPreferences.BP_PROJECT_REFERENCES_ID, true);
            try {
                projectNode.flush();
            } catch (BackingStoreException e) {
                System.out.println("Error updating project preferences");
            }
        }
    }
    
}
