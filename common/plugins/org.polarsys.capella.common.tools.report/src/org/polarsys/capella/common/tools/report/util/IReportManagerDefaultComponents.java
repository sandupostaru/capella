/*******************************************************************************
 * Copyright (c) 2006, 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.common.tools.report.util;

/**
 * The default components for the Report Manager.
 * 
 * All fields in this interface are by definition report manager components. Fields must all be accessible to be able to
 * find all default components via reflection.
 * 
 * @version 1.0.1
 */
@SuppressWarnings("nls")
public interface IReportManagerDefaultComponents {
  public static final String DIAGRAM = "Diagrams Management";
  public static final String VALIDATION = "Model Validation";
  public static final String IMPACT = "Impact Analysis";
  public static final String REFINEMENT = "Refinement";
  public static final String UI = "User Interface";
  public static final String MODEL = "Model Management";
  public static final String DEFAULT = "Default";
  public static final String BRIDGE = "Bridge";
}
