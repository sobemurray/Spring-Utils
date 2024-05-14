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
package com.sobetech.common.service.spring.io.parser.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.sobetech.common.model.io.CSVFile;
import com.sobetech.common.model.string.CSVLine;

/**
 * An instance of AbstractTextFileParser to create a CSVFile object from a file
 *
 * @author John Murray
 *
 * @since 0.2.2
 *
 */
public class CSVFileParser extends AbstractTextFileParser<CSVFile>
{
	/**
	 * Create a CSVFileParser from a File object
	 * 
	 * @param file The File object to parse
	 * @throws FileNotFoundException If the file is not found
	 */
	public CSVFileParser(File file) throws FileNotFoundException
	{
		super(file);
	}

	/**
	 * Create a CSVFileParser from File objects for the directory and file
	 * 
	 * @param directory The File object of the directory
	 * @param fileName The name of the file in the directory
	 * @throws FileNotFoundException If the file is not found
	 */
	public CSVFileParser(String directory, String fileName) throws FileNotFoundException
	{
		super(directory, fileName);
	}

	/**
	 * Create a CSVFileParser from a fully qualified file name
	 * 
	 * @param fileName A fully qualified file name
	 * @throws FileNotFoundException If the file is not found
	 */
	public CSVFileParser(String fileName) throws FileNotFoundException
	{
		super(fileName);
	}

	@Override
	protected CSVFile convertLinesToFile(List<String> stringLines)
	{
		CSVFile csvFile = new CSVFile();
		
		for(String line : stringLines)
		{
			csvFile.addLine(new CSVLine(line)); 
		}
		
		return csvFile;
	}

}
