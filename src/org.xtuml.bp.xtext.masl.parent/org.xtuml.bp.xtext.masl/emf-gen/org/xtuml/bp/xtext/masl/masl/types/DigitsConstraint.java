/**
 * generated by Xtext 2.9.2
 */
package org.xtuml.bp.xtext.masl.masl.types;

import org.xtuml.bp.xtext.masl.masl.behavior.ConstExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Digits Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtuml.bp.xtext.masl.masl.types.DigitsConstraint#getDigits <em>Digits</em>}</li>
 *   <li>{@link org.xtuml.bp.xtext.masl.masl.types.DigitsConstraint#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @see org.xtuml.bp.xtext.masl.masl.types.TypesPackage#getDigitsConstraint()
 * @model
 * @generated
 */
public interface DigitsConstraint extends AbstractTypeConstraint {
	/**
	 * Returns the value of the '<em><b>Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Digits</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Digits</em>' containment reference.
	 * @see #setDigits(ConstExpression)
	 * @see org.xtuml.bp.xtext.masl.masl.types.TypesPackage#getDigitsConstraint_Digits()
	 * @model containment="true"
	 * @generated
	 */
	ConstExpression getDigits();

	/**
	 * Sets the value of the '{@link org.xtuml.bp.xtext.masl.masl.types.DigitsConstraint#getDigits <em>Digits</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Digits</em>' containment reference.
	 * @see #getDigits()
	 * @generated
	 */
	void setDigits(ConstExpression value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference.
	 * @see #setConstraint(RangeConstraint)
	 * @see org.xtuml.bp.xtext.masl.masl.types.TypesPackage#getDigitsConstraint_Constraint()
	 * @model containment="true"
	 * @generated
	 */
	RangeConstraint getConstraint();

	/**
	 * Sets the value of the '{@link org.xtuml.bp.xtext.masl.masl.types.DigitsConstraint#getConstraint <em>Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' containment reference.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(RangeConstraint value);

} // DigitsConstraint