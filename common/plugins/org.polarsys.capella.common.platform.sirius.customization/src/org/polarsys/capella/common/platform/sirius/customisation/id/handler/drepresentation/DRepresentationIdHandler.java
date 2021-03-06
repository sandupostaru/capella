/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.common.platform.sirius.customisation.id.handler.drepresentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.IdentifiedElement;
import org.polarsys.capella.shared.id.handler.AbstractIdHandler;

public class DRepresentationIdHandler extends AbstractIdHandler {

  public DRepresentationIdHandler() {
    // Do nothing
  }

  @Override
  public String getId(EObject object) {
    if (object instanceof IdentifiedElement) {
      return ((IdentifiedElement) object).getUid(); 
    }
    return null;
  }
  
}
