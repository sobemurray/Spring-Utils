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
package com.sobetech.common.model.validation;

/**
 * An enum to signify what operation is being attempted to an object. This allows a validator
 * to customize what is to be validated. Some operations allow of a much looser validation, while
 * others are much more strict.
 * 
 * Using this allows for a validator to know what is being done to an object so it can customize
 * the logic
 *
 * @author John Murray
 *
 * @since Jun 3, 2024
 *
 */
public enum ValidationOperation
{
	/**
	 * An object is being imported from another source. Examples are from files, or other objects
	 */
	IMPORT,
	
	/**
	 * An object is being created directly by a user
	 */
	CREATION,
	
	/**
	 * An object is being updated. This will include any updates including incremental updates
	 */
	UPDATE,
	
	/**
	 * This object is looking to be flagged as Reviewed. This means this object should be ready for finalization
	 */
	REVIEW,
	
	/**
	 * This object is looking to be deleted. Content isn't validated, but it's status and relationships,
	 * may preclude deletion
	 */
	DELETION,
	
	/**
	 * This object is looking to be finalized. Finalized objects can no longer be updated, so this should be the
	 * highest level of validation
	 */
	FINALIZATION;
	
	/**
	 * Check to see if a ValidationOperation is equal to higher than a specified level. The order of scrutiny is as
	 * follows
	 * 
	 * * IMPORT
	 * * CREATION
	 * * UPDATE
	 * * REVIEW
	 * * FINALIZATION
	 * 
	 * DELETION is a special case a will only return <code>true</code> if they are equal
	 * 
	 * @param operationToCheck
	 * @param minimumOperation
	 * @return
	 */
	public static boolean isEqualOrHigherScrutiny(ValidationOperation operationToCheck, ValidationOperation minimumOperation)
	{
		switch(minimumOperation)
		{
			case IMPORT:
				return true;
			case CREATION:
				if(ValidationOperation.IMPORT != operationToCheck)
				{
					return true;
				}
				break;
			case UPDATE:
				if(ValidationOperation.IMPORT == operationToCheck || 
						ValidationOperation.CREATION == operationToCheck)
				{
					return false;
				}
				break;
			case REVIEW:
				if(ValidationOperation.IMPORT == operationToCheck || 
						ValidationOperation.CREATION == operationToCheck || 
						ValidationOperation.UPDATE == operationToCheck)
				{
					return false;
				}
				break;
			case DELETION:
				return ValidationOperation.DELETION == operationToCheck;
			case FINALIZATION:
				return ValidationOperation.FINALIZATION == operationToCheck;
			default:
				return true;
		
		}
		
		return true;
	}
}