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

import com.sobetech.common.exception.string.InvalidColumnsException;
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
	private int expectedColumnCount = 1;
	
	private boolean validateLineColumnLength = false;

	/**
	 * Default constructor
	 */
	public CSVFile()
	{
		super();
	}
	
	/**
	 * Create a new file with the flag to allow empty lines or not
	 * 
	 * @param allowsEmptyLines If <code>true</code> this file will allow empty lines. This is false by default
	 */
	public CSVFile(boolean allowsEmptyLines)
	{
		super(allowsEmptyLines);
	}
	
	/**
	 * Creates a new CSVFile with the expected number of columns for each line set
	 * 
	 * @param expectedColumnCount The expected number of columns each line must contain
	 */
	public CSVFile(int expectedColumnCount)
	{
		this();
		
		if(expectedColumnCount < 1)
		{
			throw new IllegalArgumentException("The expected columns for a file must be a minimum of one");
		}
		
		this.expectedColumnCount = expectedColumnCount;
	}
	
	/**
	 * Creates a new CSVFile with the expected number of columns for each line set
	 * 
	 * @param expectedColumns The expected number of columns each line must contain
	 * @param validateLineColumnLength If <code>true</code> each line will be validated for the number of columns before it
	 * is added to the file. By default, this is set to false
	 */
	public CSVFile(int expectedColumns, boolean validateLineColumnLength)
	{
		this(expectedColumns);

		this.validateLineColumnLength = validateLineColumnLength;
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
	
	@Override
	public boolean addLine(CSVLine newLine)
	{
		validateLine(newLine);
		
		return super.addLine(newLine);
	}

	@Override
	public boolean addLine(CSVLine newLine, int index)
	{
		validateLine(newLine);
		
		return super.addLine(newLine, index);
	}

	@Override
	public CSVLine replaceLine(int lineIndex, CSVLine replacementLine)
	{
		validateLine(replacementLine);
		
		return super.replaceLine(lineIndex, replacementLine);
	}

	@Override
	protected boolean validateLine(CSVLine lineToValidate)
	{
		super.validateLine(lineToValidate);
		
		if(this.validateLineColumnLength && lineToValidate.invalidNumberOfColumns(getExpectedColumnCount()))
		{
			throw new InvalidColumnsException(getExpectedColumnCount(), lineToValidate.getColumnCount());
		}
		
		return true;
	}

	/**
	 * Getter for attribute expectedColumnCount
	 *
	 * @return the expectedColumnCount
	 */
	public int getExpectedColumnCount()
	{
		return this.expectedColumnCount;
	}

	/**
	 * Setter for attribute expectedColumnCount
	 *
	 * @param expectedColumnCount the expectedColumnCount to set
	 */
	public void setExpectedColumnCount(int expectedColumnCount)
	{
		this.expectedColumnCount = expectedColumnCount;
	}

	/**
	 * Getter for attribute validateLineColumnLength
	 *
	 * @return the validateLineColumnLength
	 */
	public boolean isValidateLineColumnLength()
	{
		return this.validateLineColumnLength;
	}

	/**
	 * Setter for attribute validateLineColumnLength
	 *
	 * @param validateLineColumnLength the validateLineColumnLength to set
	 */
	public void setValidateLineColumnLength(boolean validateLineColumnLength)
	{
		this.validateLineColumnLength = validateLineColumnLength;
	}
}