/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.model.io.result;

/**
 * An ImportResult where the additional information of the results is a simple String
 *
 * @author John Murray
 *
 * @since May 5, 2024
 *
 */
public class StringImportResult extends ImportResult<String>
{
	/**
	 * Default constructor
	 */
	public StringImportResult()
	{
		super();
	}

	/**
	 * Create a result with a description
	 * 
	 * @param importDescription The description to set for this result
	 */
	public StringImportResult(String importDescription)
	{
		super(importDescription);
	}

	@Override
	public String getAdditionalInformation()
	{
		if(super.getAdditionalInformation() == null)
		{
			setAdditionalInformation("");
		}
		
		return super.getAdditionalInformation();
	}
}