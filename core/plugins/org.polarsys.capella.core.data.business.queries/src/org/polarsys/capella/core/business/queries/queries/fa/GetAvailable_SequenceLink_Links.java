/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.business.queries.queries.fa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.polarsys.capella.common.queries.AbstractQuery;
import org.polarsys.capella.common.queries.queryContext.IQueryContext;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.fa.FunctionalChainInvolvementLink;
import org.polarsys.capella.core.data.fa.SequenceLink;
import org.polarsys.capella.core.model.helpers.SequenceLinkExt;

public class GetAvailable_SequenceLink_Links extends AbstractQuery {

  @Override
  public List<Object> execute(Object input, IQueryContext context) {

    CapellaElement capellaElement = (CapellaElement) input;
    List<Object> currentElements = getCurrentElements(capellaElement);

    return currentElements;
  }

  private List<Object> getCurrentElements(CapellaElement element) {

    Set<FunctionalChainInvolvementLink> currentElements = Collections.emptySet();
    if (element instanceof SequenceLink) {
      currentElements = SequenceLinkExt.getAllFCILBetweenClosestFunctionGroups((SequenceLink) element);
    }

    List<Object> result = new ArrayList<>();
    result.addAll(currentElements);

    return result;
  }

}
