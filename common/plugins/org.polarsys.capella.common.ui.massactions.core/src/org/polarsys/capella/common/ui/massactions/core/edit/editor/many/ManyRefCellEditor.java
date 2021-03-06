/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.common.ui.massactions.core.edit.editor.many;

import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.polarsys.capella.common.ui.massactions.core.edit.control.many.ManyRefCellControl;
import org.polarsys.kitalpha.massactions.core.control.AbstractMACellControl;
import org.polarsys.kitalpha.massactions.core.editor.AbstractMAPrimitiveCellEditor;
import org.polarsys.kitalpha.massactions.core.table.layer.body.IMABodyLayer;

/**
 * A cell editor handling many (multiple) references.
 * 
 * @author Sandu Postaru
 *
 */
public class ManyRefCellEditor extends AbstractMAPrimitiveCellEditor {

  public ManyRefCellEditor(IMABodyLayer bodyLayer, Map<String, EStructuralFeature> featureMap) {
    super(bodyLayer, featureMap);
    this.openInDialog = true;
  }

  @Override
  public AbstractMACellControl createEditorControl(Composite parent) {
    return new ManyRefCellControl(parent, SWT.NONE, displayConverter, featureMap);
  }

}
