/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2021 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.model.string;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A DelimitedLine implementation for comma delimited lines
 *
 * @author John Murray
 *
 * @since 0.3.1
 *
 */
@JsonInclude(Include.NON_NULL)
public class CSVLine extends DelimitedLine
{
	/**
	 * An empty constructor that will set the delimiter without line data 
	 */
	public CSVLine()
	{
		super(',');
	}

	/**
	 * Construct an empty line with an expected number of columns
	 * 
	 * @param expectedColumnCount The number of columns that this line should contain
	 */
	public CSVLine(int expectedColumnCount)
	{
		super(',', expectedColumnCount);
	}

	/**
	 * A constructor that will set the delimiter with line data 
	 * 
	 * @param line The line data including the delimiters
	 */
	public CSVLine(String line)
	{
		super(',', line);
	}

	/**
	 * A constructor that will set the delimiter with line data with an expected number of columns
	 * 
	 * @param line The line data including the delimiters
	 * @param expectedColumnCount The number of columns that this line should contain
	 */
	public CSVLine(String line, int expectedColumnCount)
	{
		super(',', line, expectedColumnCount);
	}
}