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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A abstract TextLine class that is delimited
 *
 * @author John Murray
 *
 * @since 0.3.1
 *
 * @see CSVLine
 */
public abstract class DelimitedLine extends TextLine
{
	/**
	 * The character used as a delimiter
	 */
	protected char delimiter;
	
	/**
	 * The delimited line as a list of strings
	 */
	protected List<String> stringList;
	
	/**
	 * The number of columns expected in this line
	 */
	protected int expectedColumnCount;
	
	/**
	 * Create a line with a specified delimiter
	 * 
	 * @param delimiter The delimiter to use
	 */
	protected DelimitedLine(char delimiter)
	{
		super();
		this.delimiter = delimiter;
	}

	/**
	 * Create a line with a specified delimiter
	 * 
	 * @param delimiter The delimiter to use
	 * @param expectedColumnCount The number of columns that this line should contain
	 */
	protected DelimitedLine(char delimiter, int expectedColumnCount)
	{
		this(delimiter);
		this.expectedColumnCount = expectedColumnCount;
	}
	
	/**
	 * Create a populated line with a specified delimiter
	 * 
	 * @param delimiter The delimiter to use
	 * @param line The line to populate
	 */
	protected DelimitedLine(char delimiter, String line)
	{
		super(line);
		this.delimiter = delimiter;
	}
	
	/**
	 * Create a populated line with a specified delimiter
	 * 
	 * @param delimiter The delimiter to use
	 * @param line The line to populate
	 * @param expectedColumnCount The number of columns that this line should contain
	 */
	protected DelimitedLine(char delimiter, String line, int expectedColumnCount)
	{
		this(delimiter, line);
		this.expectedColumnCount = expectedColumnCount;
	}
	
	/**
	 * The character used to delimit the line
	 * 
	 * @return The character used to delimit the line
	 */
	public char getDelimiter()
	{
		return this.delimiter;
	}
	
	/**
	 * Get the number of expected columns for this line
	 * 
	 * @return The number of expected columns for this line
	 */
	public int getExpectedColumnCount()
	{
		return this.expectedColumnCount;
	}
	
	@Override
	public void setLine(String line)
	{
		super.setLine(line);
		this.stringList = Arrays.asList(this.line.split(String.valueOf(this.delimiter)));
	}

	/**
	 * Converts this text line into a String array based on the delimiter
	 * 
	 * @return A String array based on the delimiter
	 */
	public String[] asArray()
	{
		return this.asList().toArray(new String[0]);
	}
	
	/**
	 * Converts this text line into a List based on the delimiter
	 * 
	 * @return A List based on the delimiter
	 */
	public List<String> asList()
	{
		if(this.stringList == null)
		{
			if(this.line == null)
			{
				this.stringList = new ArrayList<>();
			}
			else
			{
				String[] lineArray = this.line.split(String.valueOf(this.delimiter));
				this.stringList = new ArrayList<>(Arrays.asList(lineArray));
			}
		}
		
		return this.stringList;
	}
	
	/**
	 * The number of columns this line has
	 * 
	 * @return The number of columns this line has
	 */
	public int getColumnCount()
	{
		return asList().size();
	}
	
	/**
	 * Get the first column from this line
	 * 
	 * @return The first column from this line
	 */
	public String getFirstColumn()
	{
		return asList().getFirst();
	}

	public boolean isFirstColumnNumeric()
	{
		String firstColumn = getFirstColumn();
		
		// This regex might work "-?\\d+(\\.\\d+)?"
		return firstColumn.matches("-?\\d+(\\.\\d+)?");
	}
	
	/**
	 * Checks this line to ensure that it has the correct number of columns. If the expected columns
	 * attribute is not set <code>true</code> will be returned
	 * 
	 * @return <code>true</code> if the line has the expected number of columns or the expected columns attribute has
	 * not been set
	 */
	public boolean validNumberOfColumns()
	{
		if(this.expectedColumnCount > 0)
		{
			return this.expectedColumnCount == getColumnCount();
		}
		
		return true;
	}
	
	/**
	 * Checks this line to ensure that it has an invalid number of columns. If the expected columns
	 * attribute is not set <code>false</code> will be returned
	 * 
	 * @return <code>true</code> if the line does not have the expected number of columns
	 */
	public boolean invalidNumberOfColumns()
	{
		return !validNumberOfColumns();
	}
	
	/**
	 * Checks this line to see if it has the number of columns the file expects
	 * 
	 * @param fileExpectedColumns The number of columns the file expects
	 * @return <code>true</code> if this line has the same number of columns that the file expects
	 */
	public boolean validNumberOfColumns(int fileExpectedColumns)
	{
		this.expectedColumnCount = fileExpectedColumns;
		
		return validNumberOfColumns();
	}
	
	/**
	 * Checks this line to see if it does not have the number of columns the file expects
	 * 
	 * @param fileExpectedColumns The number of columns the file expects
	 * @return <code>true</code> if this line does not have the same number of columns that the file expects
	 */
	
	public boolean invalidNumberOfColumns(int fileExpectedColumns)
	{
		return !validNumberOfColumns(fileExpectedColumns);
	}
	
	/**
	 * Determine if this a valid column index
	 * 
	 * @param columnIndex The column index to check
	 * @return <code>true</code> if this a valid column index
	 */
	public boolean validColumnIndex(int columnIndex)
	{
		return columnIndex < asList().size();
	}
	
	/**
	 * The column string based in the index requested. This method is null and index safe. If the index is out of bounds it will 
	 * return an empty String
	 * 
	 * @param columnIndex The zero based index of the column to search for
	 * @return The String data at the column. Or an empty String if the column index is out of bounds
	 */
	public String getColumn(int columnIndex)
	{
		if(columnIndex < 0 || columnIndex >= getColumnCount())
		{
			return new String();
		}
		
		return asList().get(columnIndex);
	}
	
	/**
	 * The column data based in the index as an Integer object. This method is index and value safe. If the index is out of bounds 
	 * or of the data cannot be formatted into an Integer, then it will return a null Integer object
	 * 
	 * @param columnIndex The zero based index of the column to search for
	 * @return The data in the column as an Integer. Or a null Integer object if the index is out of bounds or of the data cannot 
	 * be formatted into an Integer
	 */
	public Integer getColumnAsInteger(int columnIndex)
	{
		String columnAsString = getColumn(columnIndex);
		if(columnAsString.isBlank())
		{
			return null;
		}
		
		try
		{
			return Integer.valueOf(columnAsString);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/**
	 * The column data based in the index as an BigDecimal object. This method is index and value safe. If the index is out of bounds 
	 * or of the data cannot be formatted into an BigDecimal, then it will return a null BigDecimal object
	 * 
	 * @param columnIndex The zero based index of the column to search for
	 * @return The data in the column as an Integer. Or a null BigDecimal object if the index is out of bounds or of the data cannot 
	 * be formatted into an BigDecimal
	 */
	public BigDecimal getColumnAsBigDecimal(int columnIndex)
	{
		String columnAsString = getColumn(columnIndex);
		if(columnAsString.isBlank())
		{
			return null;
		}
		
		try
		{
			return new BigDecimal(columnAsString);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	/**
     * Set the value of a column. If <code>null</code> is sent, it will be replaced with an empty String
     * 
     * @param data The value to set
     * @param columnIndex The zero based index of the column to set
	 * @return The new value of the column
	 */
    public String setColumn(String data, int columnIndex)
    {
    	if(data == null)
    	{
    		data = new String();
    	}
    	
        return asList().set(columnIndex, data);
    }
    
    /**
     * Set the value of a column
     * 
     * @param data The value to set
     * @param columnIndex The zero based index of the column to set
	 * @return The new value of the column
     */
    public String setColumn(boolean data, int columnIndex)
    {
    	return setColumn(String.valueOf(data), columnIndex);
    }
    
    /**
     * Set the value of a column
     * 
     * @param data The value to set
     * @param columnIndex The zero based index of the column to set
	 * @return The new value of the column
     */
    public String setColumn(char data, int columnIndex)
    {
    	return setColumn(String.valueOf(data), columnIndex);
    }
    
    /**
     * Set the value of a column
     * 
     * @param data The value to set
     * @param columnIndex The zero based index of the column to set
	 * @return The new value of the column
     */
    public String setColumn(double data, int columnIndex)
    {
    	return setColumn(String.valueOf(data), columnIndex);
    }
    
    /**
     * Set the value of a column
     * 
     * @param data The value to set
     * @param columnIndex The zero based index of the column to set
	 * @return The new value of the column
     */
    public String setColumn(float data, int columnIndex)
    {
    	return setColumn(String.valueOf(data), columnIndex);
    }
    
    /**
     * Set the value of a column
     * 
     * @param data The value to set
     * @param columnIndex The zero based index of the column to set
	 * @return The new value of the column
     */
    public String setColumn(int data, int columnIndex)
    {
    	return setColumn(String.valueOf(data), columnIndex);
    }
    
    /**
     * Set the value of a column
     * 
     * @param data The value to set
     * @param columnIndex The zero based index of the column to set
	 * @return The new value of the column
     */
    public String setColumn(long data, int columnIndex)
    {
    	return setColumn(String.valueOf(data), columnIndex);
    }
    
    /**
     * Set the value of a column. If <code>null</code> is sent, it will be replaced with an empty String
     * 
     * @param data The value to set
     * @param columnIndex The zero based index of the column to set
	 * @return The new value of the column
     */
    public String setColumn(Object data, int columnIndex)
    {
    	if(data == null)
    	{
    		data = new String();
    	}
    	
        return setColumn(String.valueOf(data), columnIndex);
    }
    

	@Override
	public String toString()
	{
        return String.join(String.valueOf(this.delimiter), asList());
	}

    /**
     * Convert this line to a single String. Null columns will be skipped
     * 
     * @param columnsIndicesToSkip The zero based indices to skip in building the String
     * @return This line as a single String with the specified columns skipped
     */
    public String toString(int... columnsIndicesToSkip)
    {
    	ArrayList<String> columnsToPrint = new ArrayList<>();
    	
    	int columnIndex = 0;
    	
    	for(String column : asList())
    	{
    		boolean printColumn = true;
            for(int columnIndexToSkip : columnsIndicesToSkip)
            {
                if(columnIndexToSkip == columnIndex)
                {
                    printColumn = false;
                    break;
                }
            }
            
            if(printColumn)
            {
                if(column != null)
                {
                	columnsToPrint.add(column);
                }
            }
            
            columnIndex++;
    	}

        return String.join(String.valueOf(this.delimiter), columnsToPrint);
    }
    
    /**
     * Remove a column from the line
     * 
     * @param columnIndex The zero based index of the column to remove
     * @return The value of the column that was removed
     */
    public String removeColumn(int columnIndex)
    {
    	return asList().remove(columnIndex);
    }
    
    /**
     * Merge the data in adjacent columns into one column. The first column must start with the escapeIndicator and
     * the final column new end with the escapeIndicator.
     * 
     * Example:
     * A raw CSV file wants to have a comma in one of the columns and doesn't use the normal \, pattern but uses quotes.
     * Such as "This, That, and The Other"
     * 
     * @param startIndex The index of the first column to merge
     * @param escapeIndicator The indicator at the beginning of the first column and the end of the second column
     * @return The resulting column
     */
    public String mergeColumns(int startIndex, String escapeIndicator)
    {
    	String firstColumn = asList().get(startIndex);
    	
    	if(!firstColumn.startsWith(escapeIndicator))
    	{
    		throw new IllegalArgumentException(String.format("%s did not start with a %s", firstColumn, 
        			escapeIndicator));
    	}
    	
    	// If the column also ends with the delimiter, we can just strip them and move on
    	if(firstColumn.endsWith(escapeIndicator))
    	{
    		String strippedColumn = firstColumn.substring(1, firstColumn.length() - 1);
    		setColumn(strippedColumn, startIndex);
    		return strippedColumn;
    	}

    	boolean endFound = false;
    	
    	for(int columnIndex = startIndex + 1; validColumnIndex(columnIndex); columnIndex++)
    	{
    		if(getColumn(columnIndex).endsWith(escapeIndicator))
    		{
    			endFound = true;
    			break;
    		}
    	}
    	
    	if(endFound)
    	{
        	// Remove the delimiter from the first column
    		setColumn(firstColumn.substring(1), startIndex);
    		
    		for(int columnIndex = startIndex; columnIndex < asList().size() - 1; )
        	{
    			String currentColumn = asList().get(columnIndex);
    			String nextColumn = asList().get(columnIndex + 1);
    			
    			boolean lastColumn = false;
    			
    			if(nextColumn.endsWith(escapeIndicator))
    			{
    				nextColumn = nextColumn.substring(0, nextColumn.length() - 1);
    				lastColumn = true;
    			}
    			
    			String newColumnValue = currentColumn + nextColumn;
	    		setColumn(newColumnValue, columnIndex);
	    		removeColumn(columnIndex + 1);
	    		
	    		if(lastColumn)
	    		{
	    			return newColumnValue;
	    		}
        	}
    	}
    	
    	String exceptionString = String.format("Could not find a column after %d that ended with a %s from %s", startIndex, 
    			escapeIndicator, toString());
    	
    	throw new IllegalArgumentException(exceptionString);
    }
    
    /**
     * Gets the first column that leads with the specified escape delimiter
     * 
     * @param escapeDelimiter The escape delimiter to use for the search
     * @return The index of the first column that leads with the escape delimiter. If none is found -1 is returned.
     */
    public int getFirstLeadingEscapeDelimiterColumnIndex(String escapeDelimiter)
    {
    	int foundIndex = 0;
		for(String column : this.asList())
		{
			if(column.startsWith(escapeDelimiter))
			{
				return foundIndex;
			}
			
			foundIndex++;
		}
		
		return -1;
    }
    
    /**
     * Clean an entire line bases on a escape delimiter
     * 
     * @param escapeDelimiter The escape delimiter to use for the search and replacement
     * @return The newly cleaned line
     */
    public DelimitedLine cleanLine(String escapeDelimiter)
	{
		int delimiterStartIndex = getFirstLeadingEscapeDelimiterColumnIndex(escapeDelimiter);
		while(delimiterStartIndex > -1)
		{
			mergeColumns(delimiterStartIndex, escapeDelimiter);
			delimiterStartIndex = getFirstLeadingEscapeDelimiterColumnIndex(escapeDelimiter);
		}
		
		return this;
	}
}