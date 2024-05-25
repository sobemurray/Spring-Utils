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
package com.sobetech.common.enums;

/**
 * For enums with descriptions that need to be sent to a UI
 *
 * @author John Murray
 *
 * @since May 21, 2024
 *
 */
public class UiEnum
{
	private final String value;
	
	private final String description;
	
	/**
	 * Construct a new UiEnum instance to be sent via API to a UI
	 * 
	 * @param value The value of the enum to be sent to/from the UI
	 * @param description The description for the enum to display in a UI
	 */
	public UiEnum(String value, String description)
	{
		this.value = value;
		this.description = description;
	}

	/**
	 * Getter for attribute value
	 *
	 * @return the value
	 */
	public String getValue()
	{
		return this.value;
	}

	/**
	 * Getter for attribute description
	 *
	 * @return the description
	 */
	public String getDescription()
	{
		return this.description;
	}
}
