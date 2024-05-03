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
import java.util.List;

import com.sobetech.common.model.io.TextFile;
import com.sobetech.common.model.string.TextLine;

/**
 * An instance of AbstractTextFileParser to create a TextFile object from a file
 * 
 * @author John Murray
 *
 * @since 0.2.0
 */
public class TextFileParser extends AbstractTextFileParser<TextFile>
{

	/**
	 * Create a TextFileParser from a File object
	 * 
	 * @param file The File object to parse
	 * @throws FileNotFoundException If the file is not found
	 */
	public TextFileParser(File file) throws FileNotFoundException
	{
		super(file);
	}

	/**
	 * Create a TextFileParser from File objects for the directory and file
	 * 
	 * @param directory The File object of the directory
	 * @param fileName The name of the file in the directory
	 * @throws FileNotFoundException If the file is not found
	 */
	public TextFileParser(String directory, String fileName) throws FileNotFoundException
	{
		super(directory, fileName);
	}

	/**
	 * Create a TextFileParser from a fully qualified file name
	 * 
	 * @param fileName A fully qualified file name
	 * @throws FileNotFoundException If the file is not found
	 */
	public TextFileParser(String fileName) throws FileNotFoundException
	{
		super(fileName);
	}

	@Override
	protected TextFile convertLinesToFile(List<String> stringLines)
	{
		TextFile textFile = new TextFile();
		
		for(String line : stringLines)
		{
			textFile.addLine(new TextLine(line)); 
		}
		
		return textFile;
	}

}