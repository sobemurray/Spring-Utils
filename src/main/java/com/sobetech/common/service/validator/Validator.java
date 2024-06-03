/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Team Focus / Peak6, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.service.validator;

import com.sobetech.common.model.validation.Validatable;
import com.sobetech.common.model.validation.ValidationOperation;
import com.sobetech.common.model.validation.ValidationResult;

/**
 * An interface used to validate objects that should be validated before
 * they are used by an application
 *
 * @author John Murray
 *
 * @since May 29, 2024
 *
 */
public interface Validator <V extends Validatable>
{
	/**
	 * Validate an object before it is used by an application. Validation logic will be 
	 * based on the ValidationOperation requested. This will always return a 
	 * ValidationResult and never an exception. This will assemble all of the issues
	 * with the validatableObject and not stop with the first issue
	 * 
	 * @param validatableObject The Object to validate
	 * @param validationOperation The type of operation is being attempted on an object
	 * @return The result of the validation
	 */
	ValidationResult validate(V validatableObject, ValidationOperation validationOperation);
}