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
package org.polarsys.capella.test.benchmarks.ju;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class CapellaPerformanceTestsActivator extends Plugin {

  public static final String PLUGIN_ID = "org.polarsys.capella.test.benchmarks.ju"; //$NON-NLS-1$

  public static CapellaPerformanceTestsActivator getDefault() {
    return plugin;
  }

  private static CapellaPerformanceTestsActivator plugin;

  /**
   * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext bundleContext) throws Exception {
    super.start(bundleContext);
    plugin = this;
  }

  /**
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext bundleContext) throws Exception {
    plugin = null;
    super.stop(bundleContext);
  }

}
