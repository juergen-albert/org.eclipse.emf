/**
 * <copyright>
 *
 * Copyright (c) 2003-2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EMOFSaveImpl.java,v 1.8 2007/06/04 15:23:54 emerks Exp $
 */
package org.eclipse.emf.ecore.xmi.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;


public class EMOFSaveImpl extends XMISaveImpl 
{
  public EMOFSaveImpl(XMLHelper helper)
  {
    super(helper);
    idAttributeName = XMI_ID_NS;
  }

  @Override
  protected boolean shouldSaveFeature(EObject o, EStructuralFeature f)
  {
    if (f == EcorePackage.Literals.ETYPED_ELEMENT__ETYPE)
    {
      return o.eGet(f) != null;
    }
    else if (f == EcorePackage.Literals.EOPERATION__EEXCEPTIONS || 
             f == EcorePackage.Literals.ECLASS__ESUPER_TYPES)
    {
      return !((EList<?>)o.eGet(f)).isEmpty();
    }
    else
    {
      return super.shouldSaveFeature(o, f);
    }
  }

  @Override
  protected void saveTypeAttribute(EClass eClass)
  {
    if (eClass != EcorePackage.Literals.EATTRIBUTE && eClass != EcorePackage.Literals.EREFERENCE)
    {
      super.saveTypeAttribute(eClass);
    }
  }

  @Override
  protected void saveDataTypeElementSingle(EObject o, EStructuralFeature f)
  {
    if (f == EcorePackage.Literals.EPACKAGE__NS_PREFIX ||
        f == EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE ||
        f == EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT ||
        f == EcorePackage.Literals.ESTRUCTURAL_FEATURE__VOLATILE ||
        f == EcorePackage.Literals.EENUM_LITERAL__VALUE ||
        f == EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES ||
        f == EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME ||
        f == EcorePackage.Literals.ECLASSIFIER__INSTANCE_TYPE_NAME ||
        f == EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE ||
        f == EcorePackage.Literals.ECLASS__INTERFACE)
    {
      if (f == EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE && 
          o.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__VOLATILE)) return;
      if (f == EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT && 
          (o.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE) ||
           o.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__VOLATILE))) return;
      if (f == EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES && 
          (o.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT) || 
           o.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE) ||
           o.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__VOLATILE))) return;
      if (f == EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE && 
          o.eIsSet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME)) return;
      if (f == EcorePackage.Literals.ECLASS__INTERFACE && 
          o.eIsSet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME)) return;

      doc.startElement(EMOFExtendedMetaData.XMI_EXTENSION_ELEMENT);
      doc.addAttribute(EMOFExtendedMetaData.XMI_EXTENDER_ATTRIBUTE, EcorePackage.eNS_URI);
      saveExtensionFeature(o, f);
      if (f == EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME)
      {
        if (o instanceof EDataType)
        {
          if (o.eIsSet(EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE))
          {
            saveExtensionFeature(o, EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE);
          }
        }
        else if (o instanceof EClass)
        {
          if (o.eIsSet(EcorePackage.Literals.ECLASS__INTERFACE))
          {
            saveExtensionFeature(o, EcorePackage.Literals.ECLASS__INTERFACE);
          }
        }
      }
      else if (f == EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT)
      {
        if (o instanceof EReference && o.eIsSet(EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES))
        {
          saveExtensionFeature(o, EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES);
        }
      }
      else if (f == EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE)
      { 
        if (o.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT))
        {
          saveExtensionFeature(o, EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT);
        }
        if (o instanceof EReference && o.eIsSet(EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES))
        {
          saveExtensionFeature(o, EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES);
        }
      }
      else if (f == EcorePackage.Literals.ESTRUCTURAL_FEATURE__VOLATILE)
      { 
        if (f == EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE)
        {
          saveExtensionFeature(o, EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE);
        }
        if (o.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT))
        {
          saveExtensionFeature(o, EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT);
        }
        if (o instanceof EReference && o.eIsSet(EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES))
        {
          saveExtensionFeature(o, EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES);
        }
      }
      doc.endElement();
    }
    else
    {
      super.saveDataTypeElementSingle(o, f);
    }
  }

  @Override
  protected String getDatatypeValue(Object value, EStructuralFeature f, boolean isAttribute)
  {
    String result = super.getDatatypeValue(value, f, isAttribute);
    if (f == EcorePackage.Literals.ETYPED_ELEMENT__UPPER_BOUND && "-1".equals(result))
    {
      result = "*";
    } 
    return result;
  }

  protected void saveExtensionFeature(EObject o, EStructuralFeature f)
  {
    doc.startElement(f.getName());
    EDataType eDataType = (EDataType)f.getEType();
    doc.endContentElement(EcoreFactory.eINSTANCE.convertToString(eDataType, o.eGet(f)));
  }

  @Override
  protected void saveContainedSingle(EObject o, EStructuralFeature f)
  {
    if (f == EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE)
    {
      doc.startElement(EMOFExtendedMetaData.XMI_EXTENSION_ELEMENT);
      doc.addAttribute(EMOFExtendedMetaData.XMI_EXTENDER_ATTRIBUTE, EcorePackage.eNS_URI);
      super.saveContainedSingle(o, f);
      doc.endElement();
    }
    super.saveContainedSingle(o, f);
  }
  
  @Override
  protected void saveContainedMany(EObject o, EStructuralFeature f)
  {
    if (f == EcorePackage.Literals.ECLASS__EGENERIC_SUPER_TYPES ||
          f == EcorePackage.Literals.EOPERATION__EGENERIC_EXCEPTIONS ||
          f == EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS)
    {
      doc.startElement(EMOFExtendedMetaData.XMI_EXTENSION_ELEMENT);
      doc.addAttribute(EMOFExtendedMetaData.XMI_EXTENDER_ATTRIBUTE, EcorePackage.eNS_URI);
      super.saveContainedMany(o, f);
      doc.endElement();
    }
    else
    {
      super.saveContainedMany(o, f);
    }
  }

  @Override
  public Object writeTopObjects(List<? extends EObject> contents)
  {
    doc.startElement(XMI_TAG_NS);
    Object mark = doc.mark();

    for (int i = 0, size = contents.size(); i < size; i++)
    {
      EObject top = contents.get(i);
      EClass eClass = top.eClass();
      if (eClass == EcorePackage.Literals.EANNOTATION)
      {
        EAnnotation annotation = (EAnnotation)top;
        if (!annotation.getSource().equals(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI)) continue;

        doc.startElement(EMOFExtendedMetaData.EMOF_TAG);
        doc.addAttribute(idAttributeName, helper.getID(annotation));
        doc.addAttribute(EMOFExtendedMetaData.EMOF_TAG_NAME, annotation.getDetails().get(EMOFExtendedMetaData.EMOF_TAG_NAME));
        doc.addAttribute(EMOFExtendedMetaData.EMOF_TAG_VALUE, annotation.getDetails().get(EMOFExtendedMetaData.EMOF_TAG_VALUE));

        InternalEList<? extends EObject> values = (InternalEList<? extends EObject>)annotation.getReferences();
        if (!values.isEmpty())
        {
          if (sameDocMany(annotation, EcorePackage.Literals.EANNOTATION__REFERENCES) == CROSS_DOC)
          {
            for (Iterator<? extends EObject> iter = values.basicIterator(); iter.hasNext(); )
            {
              EObject value = iter.next();
              String href = helper.getHREF(value);
              if (href != null)
              {
                doc.startElement(EMOFExtendedMetaData.EMOF_TAG_ELEMENT);
                doc.addAttribute(XMLResource.HREF, href);
                doc.endEmptyElement();
              }
            }
          }
          else
          {
            StringBuffer ids = new StringBuffer();
            boolean failed = true;
            for (Iterator<? extends EObject> iter = values.basicIterator();; )
            {
              EObject value = iter.next();
              String idref =  helper.getIDREF(value);
              if (idref == null)
              {
                failed = true;
                if (!iter.hasNext()) break;
              }
              else
              {
                ids.append(idref);
                if (!iter.hasNext()) break;
                ids.append(' ');
              }
            }
            String idsString = ids.toString();
            if (!failed || (idsString = idsString.trim()).length() != 0)
            {
              doc.addAttribute(EMOFExtendedMetaData.EMOF_TAG_ELEMENT, ids.toString());
            }
          }
        }
        doc.endElement();
      }
      else
      {
        String name = helper.getQName(eClass);
        doc.startElement(name);
        saveElementID(top);
      }
    }

    doc.endElement();
    return mark;
  }
}
