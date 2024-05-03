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
 * @param <O> The resulting object after the file is parsed. Since this is a quite generic parser, it is
 * best to make this as generic as possible
 *
 */
public abstract class AbstractTextFileParser<O extends Object> extends AbstractFileParser<O>
{
	private int headerLinesToIgnore = 0;
	
	private int footerLinesToIgnore = 0;
	
	private boolean removeBlankLines = true;
	
	private boolean removeLeadingWhitespace = true;
	
	private boolean removeTrailingWhitespace = true;
	
	/**
	 * Create a parser from a File object
	 * 
	 * @param file The File to be parsed
	 * @throws FileNotFoundException If the file could not be found
	 */
	protected AbstractTextFileParser(File file) throws FileNotFoundException
	{
		super(file);
	}

	/**
	 * Create a parser from a directory and a file name
	 * 
	 * @param directory The directory the file is located
	 * @param fileName The name of the file
	 * @throws FileNotFoundException If the file could not be found
	 */
	protected AbstractTextFileParser(String directory, String fileName) throws FileNotFoundException
	{
		super(directory, fileName);
	}

	/**
	 * Create a parser from a fully qualified file name
	 * @param fileName The fully qualified file name
	 * @throws FileNotFoundException FileNotFoundException If the file could not be found
	 */
	protected AbstractTextFileParser(String fileName) throws FileNotFoundException
	{
		super(fileName);
	}
	
	/**
	 * Convert a list of line Strings into an Object
	 * 
	 * @param stringLines The list of Strings to turn into an Object
	 * @return The resultant Object
	 */
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
		setFileContents(convertLinesToFile(fileLines));
		return getFileContents();
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
	 * @return The line adjusted for escaped content
	 */
	protected String adjustForEscapedContent(String lineString)
	{
		return lineString;
	}

	/**
	 * The number of header lines to ignore
	 * 
	 * @return the headerLinesToIgnore
	 */
	public int getHeaderLinesToIgnore()
	{
		return this.headerLinesToIgnore;
	}

	/**
	 * Set the number of header lines to ignore
	 * 
	 * @param headerLinesToIgnore the headerLinesToIgnore to set
	 */
	public void setHeaderLinesToIgnore(int headerLinesToIgnore)
	{
		this.headerLinesToIgnore = headerLinesToIgnore;
	}

	/**
	 * The number of footer lines to ignore
	 * 
	 * @return the footerLinesToIgnore
	 */
	public int getFooterLinesToIgnore()
	{
		return this.footerLinesToIgnore;
	}

	/**
	 * Set the number of footer lines to ignore
	 * 
	 * @param footerLinesToIgnore the footerLinesToIgnore to set
	 */
	public void setFooterLinesToIgnore(int footerLinesToIgnore)
	{
		this.footerLinesToIgnore = footerLinesToIgnore;
	}

	/**
	 * Does this parser remove blank lines
	 * 
	 * @return the removeBlankLines
	 */
	public boolean removeBlankLines()
	{
		return this.removeBlankLines;
	}

	/**
	 * Tells this parser whether or not to remove blank lines
	 * 
	 * @param removeBlankLines the removeBlankLines to set
	 */
	public void setRemoveBlankLines(boolean removeBlankLines)
	{
		this.removeBlankLines = removeBlankLines;
	}

	/**
	 * Does this remove leading whitespace from this line
	 * 
	 * @return the removeLeadingWhitespace
	 */
	public boolean removeLeadingWhitespace()
	{
		return this.removeLeadingWhitespace;
	}

	/**
	 * Tells this parser whether or not to remove leading whitespace from this line
	 * 
	 * @param removeLeadingWhitespace the removeLeadingWhitespace to set
	 */
	public void setRemoveLeadingWhitespace(boolean removeLeadingWhitespace)
	{
		this.removeLeadingWhitespace = removeLeadingWhitespace;
	}

	/**
	 * Does this remove trailing whitespace from this line
	 * 
	 * @return the removeTrailingWhitespace
	 */
	public boolean removeTrailingWhitespace()
	{
		return this.removeTrailingWhitespace;
	}

	/**
	 * Tells this parser whether or not to remove trailing whitespace from this line
	 * 
	 * @param removeTrailingWhitespace the removeTrailingWhitespace to set
	 */
	public void setRemoveTrailingWhitespace(boolean removeTrailingWhitespace)
	{
		this.removeTrailingWhitespace = removeTrailingWhitespace;
	}
}
