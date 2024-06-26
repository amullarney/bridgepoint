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
package org.xtuml.bp.io.mdl;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import org.eclipse.jface.operation.IRunnableWithProgress;
import org.xtuml.bp.core.Ooaofooa;
import org.xtuml.bp.core.SystemModel_c;
import org.xtuml.bp.core.common.NonRootModelElement;
import org.xtuml.bp.core.ui.AbstractModelExportFactory;
import org.xtuml.bp.io.core.CoreExport;

public class ExportModelFactory extends AbstractModelExportFactory {

	public IRunnableWithProgress create(NonRootModelElement me, String fileName, boolean exportGraphics)
			throws FileNotFoundException {
		if (CoreExport.persistAsText(me)) {
			return new ExportModelText((Ooaofooa) me.getModelRoot(), fileName, exportGraphics, me);
		} else {
			return new ExportModelComponent((Ooaofooa) me.getModelRoot(), fileName, exportGraphics, me);
		}
	}

	public IRunnableWithProgress create(Ooaofooa aModelRoot, String fileName, boolean exportGraphics)
			throws FileNotFoundException {
		return new ExportModel(aModelRoot, fileName, exportGraphics);
	}

	public IRunnableWithProgress create(String file, NonRootModelElement element) throws FileNotFoundException {
		ExportModelComponent emc;
		if (CoreExport.persistAsText(element)) {
			emc = new ExportModelText(file, element);
		} else {
			emc = new ExportModelComponent(file, element);
		}
		emc.outputCachedIDs = true;
		return emc;
	}

	public IRunnableWithProgress create(Ooaofooa modelRoot, ByteArrayOutputStream baos, NonRootModelElement element) {
		ExportModelComponent emc;
		if (CoreExport.persistAsText(element)) {
			emc = new ExportModelText(modelRoot, baos, element);
		} else {
			emc = new ExportModelComponent(modelRoot, baos, element);
		}
		emc.outputCachedIDs = true;
		return emc;
	}

	@Override
	public IRunnableWithProgress create(Ooaofooa aModelRoot, SystemModel_c sys, boolean exportGraphics)
			throws FileNotFoundException {
		return null;
	}

}
