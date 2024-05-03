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
package com.sobetech.common.spring.service.io.parser.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Abstract class containing all of the items common to all parsers of text files. These kind of 
 * parsers are NOT to be used to manipulate the contents in ANY way. That should be done outside 
 * of the parser.
 *
 * @author John Murray
 *
 * @since 0.2.2
 *
 */
public abstract class AbstractTextFileParser<O extends Object> extends AbstractFileParser<O>
{
	private int headerLinesToIgnore = 0;
	
	private int footerLinesToIgnore = 0;
	
	private boolean removeBlankLines = true;
	
	private boolean removeLeadingWhitespace = true;
	
	private boolean removeTrailingWhitespace = true;
	
	protected AbstractTextFileParser(File file) throws FileNotFoundException
	{
		super(file);
	}

	protected AbstractTextFileParser(String directory, String fileName) throws FileNotFoundException
	{
		super(directory, fileName);
	}

	protected AbstractTextFileParser(String fileName) throws FileNotFoundException
	{
		super(fileName);
	}
	
	protected abstract O convertLinesToFile(List<String> stringLines);
	
	/**
	 * Parse the current file into a list of lines. The file will be separated into lines based 
	 * on the Scanner class. This will also clear out any previous file contents in the parser
	 * and replace it with contents of the file that you have requested to be loaded
	 * 
	 * @return The current file into a list of Strings for each line
	 * @throws FileNotFoundException If the file is not correctly initialized in this parser
	 */
	@Override
	public O parseFile() throws FileNotFoundException
	{
		List<String> fileLines = scanFileLines();
		adjustForEscapedContent(fileLines);
		this.fileContents = convertLinesToFile(fileLines);
		return this.fileContents;
	}
	
	/**
	 * Open the file and covert into a List of Strings
	 * 
	 * @return A List of Strings that was in the file being parsed
	 * @throws FileNotFoundException If the file to be parsed was not found
	 */
	protected List<String> scanFileLines() throws FileNotFoundException
	{
		Scanner scanner = new Scanner(getFile());
		List<String> stringLines = new ArrayList<>();
		while(scanner.hasNextLine())
		{
			String fileLine = scanner.nextLine();
			
			//Remove all leading whitespace
			if(removeLeadingWhitespace())
			{
				fileLine = fileLine.replaceAll("^\\s", "");
			}
			
			//Remove all trailing whitespace
			if(removeTrailingWhitespace())
			{
				fileLine = fileLine.replaceAll("\\s+$", "");
			}
			
			if(removeBlankLines() && fileLine.isBlank())
			{
				continue;
			}
			
			stringLines.add(fileLine);
		}
		scanner.close();
		
		int fromIndex = this.getHeaderLinesToIgnore();
		int toIndex = stringLines.size() - this.getFooterLinesToIgnore();
		
		return stringLines.subList(fromIndex, toIndex);
	}
	
	/**
	 * There might be issues with the data where there are delimiters that have
	 * been escaped in a way that Java can't really deal with String.split.
	 * 
	 * Therefore these methods have been created as extension points where 
	 * explicit logic can be added for specific files. The code in this class
	 * will not do any processing
	 * 
	 * @param fileLines A list of file line Strings that need to be adjusted
	 */
	protected void adjustForEscapedContent(List<String> fileLines)
	{
		ListIterator<String> iterator = fileLines.listIterator();
		
		while(iterator.hasNext())
		{
			String line = iterator.next();
		    iterator.set(adjustForEscapedContent(line));
		}
	}
	
	/**
	 * There might be issues with the data where there are delimiters that have
	 * been escaped in a way that Java can't really deal with String.split.
	 * 
	 * Therefore these methods have been created as extension points where 
	 * explicit logic can be added for specific files. The code in this class
	 * will not do any processing
	 * 
	 * @param lineString The String to make adjustments
	 */
	protected String adjustForEscapedContent(String lineString)
	{
		return lineString;
	}

	/**
	 * @return the headerLinesToIgnore
	 */
	public int getHeaderLinesToIgnore()
	{
		return this.headerLinesToIgnore;
	}

	/**
	 * @param headerLinesToIgnore the headerLinesToIgnore to set
	 */
	public void setHeaderLinesToIgnore(int headerLinesToIgnore)
	{
		this.headerLinesToIgnore = headerLinesToIgnore;
	}

	/**
	 * @return the footerLinesToIgnore
	 */
	public int getFooterLinesToIgnore()
	{
		return this.footerLinesToIgnore;
	}

	/**
	 * @param footerLinesToIgnore the footerLinesToIgnore to set
	 */
	public void setFooterLinesToIgnore(int footerLinesToIgnore)
	{
		this.footerLinesToIgnore = footerLinesToIgnore;
	}

	/**
	 * @return the removeBlankLines
	 */
	public boolean removeBlankLines()
	{
		return this.removeBlankLines;
	}

	/**
	 * @param removeBlankLines the removeBlankLines to set
	 */
	public void setRemoveBlankLines(boolean removeBlankLines)
	{
		this.removeBlankLines = removeBlankLines;
	}

	/**
	 * @return the removeLeadingWhitespace
	 */
	public boolean removeLeadingWhitespace()
	{
		return this.removeLeadingWhitespace;
	}

	/**
	 * @param removeLeadingWhitespace the removeLeadingWhitespace to set
	 */
	public void setRemoveLeadingWhitespace(boolean removeLeadingWhitespace)
	{
		this.removeLeadingWhitespace = removeLeadingWhitespace;
	}

	/**
	 * @return the removeTrailingWhitespace
	 */
	public boolean removeTrailingWhitespace()
	{
		return this.removeTrailingWhitespace;
	}

	/**
	 * @param removeTrailingWhitespace the removeTrailingWhitespace to set
	 */
	public void setRemoveTrailingWhitespace(boolean removeTrailingWhitespace)
	{
		this.removeTrailingWhitespace = removeTrailingWhitespace;
	}
}
