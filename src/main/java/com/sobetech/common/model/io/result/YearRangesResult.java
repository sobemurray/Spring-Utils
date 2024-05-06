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

import com.sobetech.common.model.date.YearRanges;

/**
 * An ImportResult that holds a YearRanges object as it's Additional Information
 *
 * @author John Murray
 *
 * @since May 5, 2024
 *
 */
public class YearRangesResult extends ImportResult<YearRanges>
{
	/**
	 * Default constructor
	 */
	public YearRangesResult()
	{
		super();
	}
	
	/**
	 * Create a result with a description
	 * 
	 * @param importDescription The description to set for this result
	 */
	public YearRangesResult(String importDescription)
	{
		super(importDescription);
	}

	/**
	 * A result with the start and end year configured in the additional results
	 * 
	 * @param startYear The start year of the import process
	 * @param endYear The end year of the import process
	 */
	public YearRangesResult(int startYear, int endYear)
	{
		this();
		
		this.setAdditionalInformation(new YearRanges(startYear, endYear));
	}

	/**
	 * A result with the start and end year configured in the additional results
	 * 
	 * @param importDescription The description to set for this result
	 * @param startYear The start year of the import process
	 * @param endYear The end year of the import process
	 */
	public YearRangesResult(int startYear, int endYear, String importDescription)
	{
		this(importDescription);
		
		this.setAdditionalInformation(new YearRanges(startYear, endYear));
	}
	
	@Override
	public YearRanges getAdditionalInformation()
	{
		if(super.getAdditionalInformation() == null)
		{
			setAdditionalInformation(new YearRanges());
		}
		
		return super.getAdditionalInformation();
	}
}
