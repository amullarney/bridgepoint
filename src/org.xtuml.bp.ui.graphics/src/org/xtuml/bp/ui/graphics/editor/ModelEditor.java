//========================================================================
// Licensed under the Apache License, Version 2.0 (the "License"); you may not 
// use this file except in compliance with the License.  You may obtain a copy 
// of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the 
// License for the specific language governing permissions and limitations under
// the License.
//======================================================================== 
//

package org.xtuml.bp.ui.graphics.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.InfoForm;
import org.osgi.service.prefs.Preferences;
import org.xtuml.bp.core.CorePlugin;
import org.xtuml.bp.core.common.NonRootModelElement;
import org.xtuml.bp.core.common.PersistableModelComponent;
import org.xtuml.bp.core.common.PersistenceManager;
import org.xtuml.bp.core.ui.preferences.BridgePointPersistencePreferences;
import org.xtuml.bp.core.ui.preferences.BridgePointProjectPreferences;
import org.xtuml.bp.ui.canvas.CanvasPlugin;
import org.xtuml.bp.ui.canvas.Model_c;
import org.xtuml.bp.ui.canvas.util.GraphicsUtil;
import org.xtuml.bp.ui.explorer.ILinkWithEditorListener;
import org.xtuml.bp.ui.graphics.Activator;
import org.xtuml.bp.ui.graphics.parts.ShapeEditPart;
import org.xtuml.bp.ui.text.xtuml.XtumlTextEditor;

public class ModelEditor extends MultiPageEditorPart implements ILinkWithEditorListener, IPropertyChangeListener {

	private GraphicalEditor fGraphicalEditor;
	private XtumlTextEditor fXtumlTextEditor;
	private List<IEditorTabFactory> preferenceControlledTabFactories = new ArrayList<IEditorTabFactory>();
	private int textPageIndex = -1;

	@Override
	protected void createPages() {
		fGraphicalEditor = createGraphicalEditor(getContainer());
		if(fGraphicalEditor != null) {
			createPagesFromExtensionPoint(getContainer(), fGraphicalEditor.getModel());
		}
		refreshTextPage();
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		CorePlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}
	
	public IFile getModelFile() {
		return fGraphicalEditor != null ? fGraphicalEditor.getModel().getPersistableComponent().getFile() : null;
	}
	
	public void refreshTextPage() {
		if (getModelFile() != null) {
			// remove the text page if it exists
			if (textPageIndex != -1 && getPageCount() > textPageIndex) {
				removePage(textPageIndex);
				textPageIndex = -1;
				fXtumlTextEditor = null;
			}
			// add a page for textual xtUML for textual projects
			final Preferences projectPrefs = new ProjectScope(getModelFile().getProject())
					.getNode(BridgePointProjectPreferences.BP_PROJECT_PREFERENCES_ID);
			if (projectPrefs.get(BridgePointPersistencePreferences.BP_PERSISTENCE_MODE_ID, "null").equals("text")) {
				try {
					fXtumlTextEditor = new XtumlTextEditor();
					textPageIndex = addPage(fXtumlTextEditor, new FileEditorInput(getModelFile()));
					setPageText(textPageIndex, "Textual xtUML");
				} catch (PartInitException e) {
					Activator.logError("Unable to create text editor.", e);
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	private GraphicalEditor createGraphicalEditor(Composite container) {
		GraphicalEditor editor = new GraphicalEditor(this);
		try {
			String result = checkEditorInput(editor);
			if(!result.equals("")) {
				InfoForm form = new InfoForm(container);
				form.setInfo(result);
				int index = addPage(form.getControl());
				setPageText(index, "Information");
				return null;
			}
			int addPage = addPage(editor, getEditorInput());
			setPageText(addPage, "Graphical Editor");
		} catch (PartInitException e) {
			Activator.logError("Unable to create graphical editor.", e);
		}
		return editor;
	}

	private String checkEditorInput(GraphicalEditor editor) {
		IEditorInput input = getEditorInput();
		String result = "";
		if(input instanceof FileEditorInput) {
			IPath path = ((FileEditorInput) input).getFile().getFullPath();
			if (path != null) {
				PersistableModelComponent pmc = PersistenceManager
						.findOrCreateComponent(path);
				if(pmc != null && pmc.getComponentType().equals("ModelClass")) { //$NON-NLS-1$
					setPartName(GraphicsUtil.getCanvasEditorTitle(pmc.getRootModelElement()));
					result = "Use Model Explorer to edit Model Class descriptions.";
				}
				if(pmc == null) {
					result = "Could not locate underlying model element.";
			}
		}
		}
		return result;
	}

	private void createPagesFromExtensionPoint(Composite container, Model_c model) {
	    IExtensionRegistry reg = Platform.getExtensionRegistry();
	    IExtensionPoint extPt = reg.getExtensionPoint("org.xtuml.bp.ui.graphics.editorTab"); //$NON-NLS-1$
	    IExtension[] extensions = extPt.getExtensions();
	    for(int i = 0; i < extensions.length; i++) {
	    	IConfigurationElement[] configurationElements = extensions[i].getConfigurationElements();
	    	for (int j = 0; j < configurationElements.length; j++) {
	    		if (configurationElements[j].getName().equals("EditorTab")) { //$NON-NLS-1$
	    			Object selection = configurationElements[j].getAttribute("Input"); //$NON-NLS-1$
	    			if(selection.equals(model.getRepresents().getClass().getName())) {
						try {
							Object tabFactory = configurationElements[j].createExecutableExtension("EditorTabFactory"); //$NON-NLS-1$
		    				String editorTitle = configurationElements[j].getAttribute("EditorTitle"); //$NON-NLS-1$
		    				if(tabFactory instanceof IEditorTabFactory) {
		    					IEditorTabFactory factory = (IEditorTabFactory) tabFactory;
		    					boolean enabled = factory.isEnabled();
		    					factory.setTabText(editorTitle);
		    					if(enabled) {
		    						createTabFromFactory(container, editorTitle, model.getRepresents(), factory);
		    						factory.setCreated(true);
		    					}
		    					if(factory.isPreferenceControlled()) {
		    						preferenceControlledTabFactories.add(factory);
		    					}
		    				}
						} catch (CoreException e) {
							CanvasPlugin.logError("Unable to create executable extension from point.", e); //$NON-NLS-1$
						} 
	    			}
	    		}
	    	}
	    }
	}
	
	private void createTabFromFactory(Composite container, String title, Object represents, IEditorTabFactory factory) {
		Composite composite = factory.createEditorTab(container, represents, title);
		int newPage = addPage((Composite) composite);
		setPageText(newPage, title);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		getActiveEditor().doSave(monitor);
	}

	@Override
	public void doSaveAs() {
		getActiveEditor().doSaveAs();
	}

	@Override
	public boolean isSaveAsAllowed() {
		if (getActiveEditor() != null) {
			return getActiveEditor().isSaveAsAllowed();
		} else {
			return false;
		}
	}

	public IEditorPart getActivePart() {
		return getActiveEditor();
	}

	@Override
	public String getTitleToolTip() {
		return getActiveEditor().getTitleToolTip();
	}
	
	@Override
	public Image getTitleImage() {
		if (this.fGraphicalEditor != null) {
			Object element = this.fGraphicalEditor.getModel().getRepresents();
			return CorePlugin.getImageFor(element);
		} else {
			return null;
		}
	}
	
	
	@Override
	public String getTitle() {
		return getPartName();
	}
	
	@Override
	public String getPartName() {
		if(fGraphicalEditor == null)
			return super.getPartName();
		return fGraphicalEditor.getPartName();
	}
	
	public GraphicalEditor getGraphicalEditor() {
		return fGraphicalEditor;
	}

	public void refresh() {
		if(fGraphicalEditor != null && !fGraphicalEditor.getCanvas().isDisposed()) {
			fGraphicalEditor.refresh();
		}
	}
	
	@Override
	public void notifySelectionLink() {
		if(getGraphicalEditor() == null) { return; }
		// this notification is sent immediately after
		// a selection has been transferred from the explorer
		// tree
		// we only want to zoom selected if the selection is not
		// already visible
		IStructuredSelection selection = (IStructuredSelection) getGraphicalEditor()
				.getEditorSite().getSelectionProvider().getSelection();
		boolean zoomSelected = false;
		for(Object selected : selection.toList()) {
			if(selected instanceof AbstractGraphicalEditPart) {
				IFigure figure = ((AbstractGraphicalEditPart) selected)
						.getFigure();
				Viewport viewport = ((FigureCanvas) getGraphicalEditor()
						.getCanvas()).getViewport();
				Rectangle viewportBounds = viewport.getBounds().getCopy();
				Rectangle figureBounds = figure.getBounds().getCopy();
				figure.translateToAbsolute(figureBounds);
				if(!viewportBounds.intersects(figureBounds)) {
					zoomSelected = true;
					break;
				}
			}
		}
		if(zoomSelected) {
			getGraphicalEditor().zoomSelected();
		}
	}

	@Override
	public NonRootModelElement getFirstSelectedElement() {
		if(getGraphicalEditor() == null) { return null; }
		IStructuredSelection selection = (IStructuredSelection) getGraphicalEditor()
				.getEditorSite().getSelectionProvider().getSelection();
		for(Object selected : selection.toList()) {
			if (selected instanceof ShapeEditPart) {
				NonRootModelElement nrme = (NonRootModelElement) ((ShapeEditPart)selected).getGraphicalElement().getRepresents();
				return nrme;
			}
		}
		return null;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// ask all preference controlled tab factories if this preference
		// change enables/disables them, add the tab if so
		for(IEditorTabFactory factory : preferenceControlledTabFactories) {
			if(factory.isEnabled() && !factory.created()) {
				createTabFromFactory(getContainer(), factory.getTabText(), getGraphicalEditor().getModel().getRepresents(), factory);
			} else {
				factory.setCreated(false);
				// remove tab
				for(int i = 0; i < getPageCount(); i++) {
					if(getPageText(i).equals(factory.getTabText())) {
						removePage(i);
					}
				}
			}
		}
	}
}
