/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: AllSuites.java,v 1.6 2004/05/12 22:05:58 marcelop Exp $
 */
package org.eclipse.emf.test.core;


import junit.framework.Test;
import junit.framework.TestSuite;


public class AllSuites extends TestSuite
{
  public static String pkgName = "EMF Core JUnit Test Suite";

  private static Test[] suites = new Test []{ 
    org.eclipse.emf.test.core.common.util.URITest.suite(), 
    org.eclipse.emf.test.core.dynamic.SimpleModelTest.suite(),
    //org.eclipse.emf.test.core.xmi.NamespaceTest.suite(),
    org.eclipse.emf.test.core.build.BuildTests.suite(),
    org.eclipse.emf.test.core.sdo.types.SDOUtilGetTest.suite(),
    org.eclipse.emf.test.core.sdo.types.SDOUtilSetTest.suite(),
    org.eclipse.emf.test.core.sdo.types.SDOUtilProtectedGetTest.suite()
  };

  public static Test suite()
  {
    return new AllSuites(pkgName);
  }

  public AllSuites()
  {
    super();
    populateSuite();
  }

  public AllSuites(Class theClass)
  {
    super(theClass);
    populateSuite();
  }

  public AllSuites(String name)
  {
    super(name);
    populateSuite();
  }

  private void populateSuite()
  {
    for (int i = 0; i < suites.length; i++)
    {
      addTest(suites[i]);
    }
  }
}