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
 * $Id: JavaSwitch.java,v 1.1 2004/04/13 02:50:33 marcelop Exp $
 */
package org.eclipse.emf.java.util;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.java.JClass;
import org.eclipse.emf.java.JCompilationUnit;
import org.eclipse.emf.java.JField;
import org.eclipse.emf.java.JInitializer;
import org.eclipse.emf.java.JMember;
import org.eclipse.emf.java.JMethod;
import org.eclipse.emf.java.JModelElement;
import org.eclipse.emf.java.JPackage;
import org.eclipse.emf.java.JParameter;
import org.eclipse.emf.java.JavaPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch doSwitch(object)} 
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object 
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned, 
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.java.JavaPackage
 * @generated
 */
public class JavaSwitch {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static JavaPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = JavaPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public Object doSwitch(EObject theEObject)
  {
    EClass theEClass = theEObject.eClass();
    if (theEClass.eContainer() == modelPackage)
    {
      switch (theEClass.getClassifierID())
      {
        case JavaPackage.JCLASS:
        {
          JClass jClass = (JClass)theEObject;
          Object result = caseJClass(jClass);
          if (result == null) result = caseJMember(jClass);
          if (result == null) result = caseJModelElement(jClass);
          if (result == null) result = defaultCase(theEObject);
          return result;
        }
        case JavaPackage.JCOMPILATION_UNIT:
        {
          JCompilationUnit jCompilationUnit = (JCompilationUnit)theEObject;
          Object result = caseJCompilationUnit(jCompilationUnit);
          if (result == null) result = caseJModelElement(jCompilationUnit);
          if (result == null) result = defaultCase(theEObject);
          return result;
        }
        case JavaPackage.JFIELD:
        {
          JField jField = (JField)theEObject;
          Object result = caseJField(jField);
          if (result == null) result = caseJMember(jField);
          if (result == null) result = caseJModelElement(jField);
          if (result == null) result = defaultCase(theEObject);
          return result;
        }
        case JavaPackage.JINITIALIZER:
        {
          JInitializer jInitializer = (JInitializer)theEObject;
          Object result = caseJInitializer(jInitializer);
          if (result == null) result = caseJMember(jInitializer);
          if (result == null) result = caseJModelElement(jInitializer);
          if (result == null) result = defaultCase(theEObject);
          return result;
        }
        case JavaPackage.JMETHOD:
        {
          JMethod jMethod = (JMethod)theEObject;
          Object result = caseJMethod(jMethod);
          if (result == null) result = caseJMember(jMethod);
          if (result == null) result = caseJModelElement(jMethod);
          if (result == null) result = defaultCase(theEObject);
          return result;
        }
        case JavaPackage.JPACKAGE:
        {
          JPackage jPackage = (JPackage)theEObject;
          Object result = caseJPackage(jPackage);
          if (result == null) result = caseJModelElement(jPackage);
          if (result == null) result = defaultCase(theEObject);
          return result;
        }
        case JavaPackage.JPARAMETER:
        {
          JParameter jParameter = (JParameter)theEObject;
          Object result = caseJParameter(jParameter);
          if (result == null) result = caseJModelElement(jParameter);
          if (result == null) result = defaultCase(theEObject);
          return result;
        }
        default: return defaultCase(theEObject);
      }
    }
    return defaultCase(theEObject);
  }

  /**
   * Returns the result of interpretting the object as an instance of '<em>JClass</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpretting the object as an instance of '<em>JClass</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseJClass(JClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpretting the object as an instance of '<em>JModel Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpretting the object as an instance of '<em>JModel Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseJModelElement(JModelElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpretting the object as an instance of '<em>JMember</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpretting the object as an instance of '<em>JMember</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseJMember(JMember object)
  {
    return null;
  }

  /**
   * Returns the result of interpretting the object as an instance of '<em>JCompilation Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpretting the object as an instance of '<em>JCompilation Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseJCompilationUnit(JCompilationUnit object)
  {
    return null;
  }

  /**
   * Returns the result of interpretting the object as an instance of '<em>JField</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpretting the object as an instance of '<em>JField</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseJField(JField object)
  {
    return null;
  }

  /**
   * Returns the result of interpretting the object as an instance of '<em>JInitializer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpretting the object as an instance of '<em>JInitializer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseJInitializer(JInitializer object)
  {
    return null;
  }

  /**
   * Returns the result of interpretting the object as an instance of '<em>JMethod</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpretting the object as an instance of '<em>JMethod</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseJMethod(JMethod object)
  {
    return null;
  }

  /**
   * Returns the result of interpretting the object as an instance of '<em>JParameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpretting the object as an instance of '<em>JParameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseJParameter(JParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpretting the object as an instance of '<em>JPackage</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpretting the object as an instance of '<em>JPackage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseJPackage(JPackage object)
  {
    return null;
  }

  /**
   * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public Object defaultCase(EObject object)
  {
    return null;
  }

} //JavaSwitch
