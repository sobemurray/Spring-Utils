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

/**
 * Enum for a boolean sent as "Yes" or "No" to/from carriers
 *
 * @author John.Murray
 *
 * @since Feb 16, 2023
 *
 */
public enum YesNoString implements StringEnum
{
	/**
	 * NO
	 */
	NO("No"), 
	
	/**
	 * YES
	 */
	YES("Yes");

	private String value;

	YesNoString(String value)
	{
		this.value = value;
	}

	@Override
	public String getDescription()
	{
		return value;
	}
}
