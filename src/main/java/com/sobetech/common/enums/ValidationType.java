/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2023 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.enums;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The type of validation that is being done
 *
 * @author John.Murray
 *
 * @since Jul 21, 2023
 *
 */
@Schema(description = "The type of validation that failed")
public enum ValidationType implements StringEnum
{
	/**
	 * Unexpected null
	 */
	NULL("Null"), 
	
	/**
	 * Unexpected null
	 */
	EMPTY("Empty"), 
	
	/**
	 * Soemthing is invalid
	 */
	INVALID("Invalid"),
	
	/**
	 * Invalid duplicate
	 */
	DUPLICATE("Duplicate"),
	
	/**
	 * Something is unexpectedly missing
	 */
	MISSING("Missing"),
	
	/**
	 * An external validation failure occurred
	 */
	EXTERNAL("External Failure");

	private String value;

	ValidationType(String value)
	{
		this.value = value;
	}

	@Override
	public String getValue()
	{
		return value;
	}
}