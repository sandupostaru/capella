/*******************************************************************************
 * Copyright (c) 2006, 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.projection.scenario.es2es.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.polarsys.capella.core.data.information.AbstractInstance;
import org.polarsys.capella.core.data.information.InformationPackage;
import org.polarsys.capella.core.data.interaction.InstanceRole;
import org.polarsys.capella.core.data.interaction.InteractionPackage;
import org.polarsys.capella.core.projection.common.CommonRule;
import org.polarsys.capella.core.tiger.ITransfo;
import org.polarsys.capella.core.tiger.TransfoException;
import org.polarsys.capella.core.tiger.helpers.Query;
import org.polarsys.capella.core.tiger.helpers.TigerRelationshipHelper;

/**
 */
public class Rule_InstanceRole extends CommonRule {

  /**
   * @param sourceType
   * @param targetType
   */
  public Rule_InstanceRole() {
    super(InteractionPackage.Literals.INSTANCE_ROLE, InteractionPackage.Literals.INSTANCE_ROLE);
  }

  @Override
  @SuppressWarnings("unchecked")
  protected Object transformElement(EObject element, ITransfo transfo) {
    List<InstanceRole> tgtTransformed = new ArrayList<InstanceRole>();

    InstanceRole src = (InstanceRole) element;

    List<InstanceRole> tgt = (List<InstanceRole>) Query.retrieveUnattachedTransformedElements(src, transfo, getTargetType());
    if (tgt.size() > 0) {
      tgtTransformed.addAll(tgt);

    } else {
      List<AbstractInstance> parts = ScenarioHelper.getRelatedInstances(src, transfo);

      for (AbstractInstance part : parts) {
        if (part != null) {
          InstanceRole ir2 = ScenarioFinalizer.getInstanceRole(part);

          if (ir2 == null) {
            ir2 = (InstanceRole) super.transformElement(element, transfo);
            ir2.setRepresentedInstance(part);
            ScenarioFinalizer.registerInstanceRole(part, ir2);

            if (part.getName() != null) {
              ir2.setName(part.getName());
            }
          }

          tgtTransformed.add(ir2);
        }
      }
    }

    return tgtTransformed;
  }

  /**
   * @see org.polarsys.capella.core.tiger.impl.TransfoRule#attach_(org.eclipse.emf.ecore.EObject, org.polarsys.capella.core.tiger.ITransfo)
   */
  @Override
  public void firstAttach(EObject element, ITransfo transfo) throws TransfoException {
    // The instance role represents the same instance than the source.
    InstanceRole src = (InstanceRole) element;

    for (EObject eTgt : Query.retrieveUnattachedTransformedElements(src, transfo, getTargetType())) {
      InstanceRole role = (InstanceRole) eTgt;

      if (role.getRepresentedInstance() == null) {
        AbstractInstance tgtInstance =
            (AbstractInstance) Query.retrieveFirstTransformedElement(src.getRepresentedInstance(), transfo, InformationPackage.Literals.ABSTRACT_INSTANCE);
        if (tgtInstance == null) {
          tgtInstance = src.getRepresentedInstance();
        }
        role.setRepresentedInstance(tgtInstance);
      }

    }

    TigerRelationshipHelper.attachUnattachedIntoTransformedContainer(element, getTargetType(), InteractionPackage.Literals.SCENARIO__OWNED_INSTANCE_ROLES,
        transfo);

  }

}
