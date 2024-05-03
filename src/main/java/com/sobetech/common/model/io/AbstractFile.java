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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sobetech.common.model.string.TextLine;

/**
 * An abstract class to represent an text file. While this might seem unnecessary it creates the opportunity
 * to consolidate many methods and operations into one place
 *
 * @author John Murray
 *
 * @since 0.3.1
 *
 * @param <L> Any class that is a TextLine class or extension of it
 * 
 * @see CSVFile
 * @see TextFile
 *
 */
public abstract class AbstractFile <L extends TextLine>
{
	private Optional<List<L>> lines;
	
	/**
	 * Empty Constructor
	 */
	public AbstractFile()
	{
		clearLines();
	}

	/**
	 * Gets all of the lines of the file
	 * 
	 * @return An Optional instance of the lines in the file for null safety
	 */
	public Optional<List<L>> getLines()
	{
		return this.lines;
	}
	
	/**
	 * Gets the number of lines in this file. If for some reason the lines have been nullified, this will still return 0
	 * 
	 * @return The number of lines in this file
	 */
	public int getLineCount()
	{
		if(this.lines.isPresent())
		{
			return this.lines.get().size();
		}
		
		return 0;
	}
	
	/**
	 * Add a new line to the end of the file
	 * 
	 * @param newLine The new line to add to the file
	 * @return <code>true</code> if the new line has been added. This will also return <code>false</code> if the newLine is null
	 */
	public boolean addLine(L newLine)
	{
		if(newLine == null)
		{
			return false;
		}
		
		if(this.lines.isEmpty())
		{
			this.lines = Optional.of(new ArrayList<L>());
		}
		
		return this.lines.get().add(newLine);
	}
	
	/**
	 * Inserts a new line into the specified location of the file. All other lines will be shifted downward. If the index
	 * specified is out of bounds, the line will be added to the end of the file
	 * 
	 * @param newLine The new line to add to the file
	 * @param index The index location to add this line
	 * @return <code>true</code> if the new line has been added. This will also return <code>false</code> if the newLine is null
	 */
	public boolean addLine(L newLine, int index)
	{
		if(newLine == null)
		{
			return false;
		}
		
		if(this.lines.isEmpty())
		{
			this.lines = Optional.of(new ArrayList<L>());
		}
		
		try
		{
			this.lines.get().add(index, newLine);
		}
		catch(IndexOutOfBoundsException e)
		{
			return addLine(newLine);
		}
		
		return true;
	}
	
	/**
	 * Get the line at a zero-based line number
	 * 
	 * @param lineIndex The zero-based line number
	 * @return The line at this index
	 * @throws IndexOutOfBoundsException if the index is not valid for the lines
	 */
	public L getLine(int lineIndex)
	{
		return this.lines.get().get(lineIndex);
	}
	
	/**
	 * Remove the line at a zero-based line number
	 * 
	 * @param lineIndex The zero-based line number
	 * @return The line that was in that zero-based line number
	 * @throws IndexOutOfBoundsException if the index is not valid for the lines
	 */
	public L removeLine(int lineIndex)
	{
		return this.lines.get().remove(lineIndex);
	}
	
	/**
	 * Remove all of the lines that are in this file. It will reset the lines to an empty list and not set it to null
	 */
	public void clearLines()
	{
		this.lines = Optional.of(new ArrayList<L>());
	}

	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		if(this.lines.isPresent())
		{
			boolean addNewLine = false;
			
			for(L line : this.lines.get())
			{
				if(addNewLine)
				{
					stringBuilder.append(System.getProperty("line.separator"));
				}
				
				stringBuilder.append(line.toString());
			}
		}

		return stringBuilder.toString();
	}
}
