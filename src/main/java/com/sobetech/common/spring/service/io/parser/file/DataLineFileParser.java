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

import com.sobetech.common.model.string.DataLine;

/**
 * A basic file parser to convert any text file into a list of DataLine objects. One DataLine object
 *  for each line in the file. This parser is NOT to be used to manipulate the contents in ANY way. 
 *  That should be done outside of the parser.
 * 
 * @author John Murray
 *
 * @since 0.2.1
 */
public class DataLineFileParser extends AbstractTextFileParser<List<DataLine>>
{

	/**
	 * Create a DataLineFileParser based on a full file path
	 * 
	 * @param fileName Full file path of the file to parse
	 * @throws FileNotFoundException If the file does not exist or if the file is actually a directory
	 */
	public DataLineFileParser(String fileName) throws FileNotFoundException
	{
		super(fileName);
	}

	/**
	 * Create a DataLineFileParser based on a directory name and a file name
	 * 
	 * @param directory The directory name
	 * @param fileName The file name
	 * @throws FileNotFoundException If the file does not exist or if the file is actually a directory
	 */
	public DataLineFileParser(String directory, String fileName) throws FileNotFoundException
	{
		super(directory, fileName);
	}

	/**
	 * Create a DataLineFileParser based on a File object
	 * 
	 * @param file The File object to parse
	 * @throws FileNotFoundException If the file is actually a directory
	 */
	public DataLineFileParser(File file) throws FileNotFoundException
	{
		super(file);
	}

	@Override
	protected List<DataLine> convertLinesToFile(List<String> stringLines)
	{
		List<DataLine> lineList = new ArrayList<>();
		
		for(String line : stringLines)
		{
			lineList.add(new DataLine(line)); 
		}
		
		return lineList;
	}
}