/**
 * generated by Xtext 2.9.2
 */
package org.xtuml.bp.xtext.masl.masl.structure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtuml.bp.xtext.masl.masl.structure.ObjectDeclaration;
import org.xtuml.bp.xtext.masl.masl.structure.StateDefinition;
import org.xtuml.bp.xtext.masl.masl.structure.StateType;
import org.xtuml.bp.xtext.masl.masl.structure.StructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtuml.bp.xtext.masl.masl.structure.impl.StateDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.xtuml.bp.xtext.masl.masl.structure.impl.StateDefinitionImpl#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateDefinitionImpl extends AbstractActionDefinitionImpl implements StateDefinition {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final StateType TYPE_EDEFAULT = StateType.ASSIGNER;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected StateType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected ObjectDeclaration object;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.STATE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(StateType newType) {
		StateType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.STATE_DEFINITION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectDeclaration getObject() {
		if (object != null && object.eIsProxy()) {
			InternalEObject oldObject = (InternalEObject)object;
			object = (ObjectDeclaration)eResolveProxy(oldObject);
			if (object != oldObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructurePackage.STATE_DEFINITION__OBJECT, oldObject, object));
			}
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectDeclaration basicGetObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(ObjectDeclaration newObject) {
		ObjectDeclaration oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.STATE_DEFINITION__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructurePackage.STATE_DEFINITION__TYPE:
				return getType();
			case StructurePackage.STATE_DEFINITION__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StructurePackage.STATE_DEFINITION__TYPE:
				setType((StateType)newValue);
				return;
			case StructurePackage.STATE_DEFINITION__OBJECT:
				setObject((ObjectDeclaration)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StructurePackage.STATE_DEFINITION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case StructurePackage.STATE_DEFINITION__OBJECT:
				setObject((ObjectDeclaration)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StructurePackage.STATE_DEFINITION__TYPE:
				return type != TYPE_EDEFAULT;
			case StructurePackage.STATE_DEFINITION__OBJECT:
				return object != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //StateDefinitionImpl