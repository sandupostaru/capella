/*******************************************************************************
 * Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.explorer.activity.ui.actions.sa;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.explorer.activity.ui.actions.AbstractCapellaAction;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.sa.PerformOpCapabilityToSystemMissionTransitionAdapter;

public class PerformOpCapabilityToSystemMissionAction extends AbstractCapellaAction {

	public PerformOpCapabilityToSystemMissionAction(Project capellaProject, Session session) {
		super(Messages.PerformOpCapabilityToSystemMissionAction_Title, AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.capella.core.data.gen.edit", //$NON-NLS-1$
				"icons/full/obj16/Mission.gif"), capellaProject, session); //$NON-NLS-1$
	}

	@Override
	public void doRun(ModelElement modelElement, Session session) {
		new PerformOpCapabilityToSystemMissionTransitionAdapter().linkActivated(null);
	}
}
