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
package com.sobetech.common.model;

import com.sobetech.common.enums.StringEnum;

/**
 * A StringEnum for entities that have to designate the editing status
 *
 * @author John Murray
 *
 * @since May 24, 2024
 *
 */
public enum EditStatus implements StringEnum
{
	DELETED("Deleted"),
	EDITED("Edited"),
	FINALIZED("Finalized"),
	IMPORTED("Imported"),
	NEEDS_REVIEW("Needs Review");	

	private String description;
	
	private EditStatus(String description)
	{
		this.description = description;
	}
	
	/**
	 * Convert a String into the correct EditStatus. This is an extension of the valueOf method
	 * 
	 * @param statusString The String to convert
	 * @return The matching EditStatus if one is found. Otherwise an IllegalArgumentException is thrown
	 */
	public static EditStatus fromString(String statusString)
	{
		return EditStatus.valueOf(statusString.toUpperCase());
	}

	@Override
	public String getDescription()
	{
		return this.description;
	}
}
