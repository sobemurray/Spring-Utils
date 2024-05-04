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
package com.sobetech.common.model.io;

import com.sobetech.common.model.string.CSVLine;

/**
 * An AbstractFile implementation for files containing CSVLines
 *
 * @author John Murray
 *
 * @since 0.3.1
 *
 */
public class CSVFile extends AbstractFile<CSVLine>
{
	/**
	 * Default constructor
	 */
	public CSVFile()
	{
		super();
	}
	
	/**
	 * Merges two lines into a single line
	 * 
	 * @param firstLineIndex The index of the content of the first line
	 * @param secondLineIndex The index of the content of the second line
	 * @param omitDelimiter If <code>false</code> the delimiter will be placed between the two lines before
	 * the update
	 * @return The new CSVLine after the merge
	 */
	public CSVLine mergeLines(int firstLineIndex, int secondLineIndex, boolean omitDelimiter)
	{
		CSVLine firstLine = getLine(firstLineIndex);
		CSVLine secondLine = getLine(secondLineIndex);
		
		String joiner = String.valueOf(firstLine.getDelimiter());
		
		if(omitDelimiter)
		{
			joiner = "";
		}
		
		CSVLine newLine = new CSVLine(firstLine.toString() + joiner + secondLine.toString());
		
		replaceLine(firstLineIndex, newLine);
		
		removeLine(secondLineIndex);
		
		return newLine;
	}
}