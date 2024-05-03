/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2020 Sobetech Holdings LLC, All Rights Reserved
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


/**
 * A basic file parser to convert any text file into a list of strings. One string for each line
 * in the file. This parser is NOT to be used to manipulate the contents in ANY way. That should
 * be done outside of the parser.
 * 
 * @author John Murray
 *
 * @since 0.0.1
 */
public class StringLineFileParser extends AbstractTextFileParser<List<String>>
{

	/**
	 * Create a StringLineFileParser based on a full file path
	 * 
	 * @param fileName Full file path of the file to parse
	 * @throws FileNotFoundException If the file does not exist or if the file is actually a directory
	 */
	public StringLineFileParser(String fileName) throws FileNotFoundException
	{
		super(fileName);
	}

	/**
	 * Create a StringLineFileParser based on a directory name and a file name
	 * 
	 * @param directory The directory name
	 * @param fileName The file name
	 * @throws FileNotFoundException If the file does not exist or if the file is actually a directory
	 */
	public StringLineFileParser(String directory, String fileName) throws FileNotFoundException
	{
		super(directory, fileName);
	}

	/**
	 * Create a StringLineFileParser based on a File object
	 * 
	 * @param file The File object to parse
	 * @throws FileNotFoundException If the file is actually a directory
	 */
	public StringLineFileParser(File file) throws FileNotFoundException
	{
		super(file);
	}

	@Override
	protected List<String> convertLinesToFile(List<String> stringLines)
	{
		List<String> lineList = new ArrayList<>();
		
		for(String line : stringLines)
		{
			lineList.add(line); 
		}
		
		return lineList;
	}
}