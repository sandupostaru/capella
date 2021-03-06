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

package org.polarsys.capella.core.transition.common.launcher;

/**
 *
 */
public class IDefaultWorkflow {
  public static final String WORKFLOW__DEFAULT_ID = "transition.workflow";

  public static final String WORKFLOW_STEP__INITIALIZATION = "transition.workflow.init";

  public static final String WORKFLOW_STEP__TRANSPOSITION = "transition.workflow.transposer";

  public static final String WORKFLOW_STEP__DIFF_MERGE = "transition.workflow.diffmerge";

  public static final String WORKFLOW_STEP__FINALIZATION = "transition.workflow.finalization";

}
