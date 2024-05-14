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
package com.sobetech.common.service.spring.io.parser.file;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Abstract class containing the scaffolding to create any type of file parser
 * 
 * @author John Murray
 * 
 * @since 0.0.1
 * 
 * @param <O> The resulting object after the file is parsed. Since this is a quite generic parser, it is
 * best to make this as generic as possible
 * 
 * @see AbstractTextFileParser
 */
public abstract class AbstractFileParser<O extends Object>
{
	private File file;
	
	private O fileContents;

	/**
	 * Load the file contents into the parser
	 * 
	 * @return The contents of the file after parsing
	 * @throws FileNotFoundException If the file is not correctly initialized in this parser
	 */
	public abstract O parseFile() throws FileNotFoundException;

	/**
	 * Create a parser from a fully qualified file name
	 * @param fileName The fully qualified file name
	 * @throws FileNotFoundException FileNotFoundException If the file could not be found
	 */
	protected AbstractFileParser(String fileName) throws FileNotFoundException
	{
		if( fileName == null || fileName.isEmpty() || fileName.isBlank() )
		{
			throw new FileNotFoundException("File cannot be parsed without a fileName");
		}
		
		setFile(new File(fileName));
	}
	
	/**
	 * Create a parser from a directory and a file name
	 * 
	 * @param directory The directory the file is located
	 * @param fileName The name of the file
	 * @throws FileNotFoundException If the file could not be found
	 */
	protected AbstractFileParser(String directory, String fileName) throws FileNotFoundException
	{
		if( directory == null || directory.isEmpty() || directory.isBlank() )
		{
			throw new FileNotFoundException("File cannot be parsed without a directory");
		}
		
		if( fileName == null || fileName.isEmpty() || fileName.isBlank() )
		{
			throw new FileNotFoundException("File cannot be parsed without a fileName");
		}
		
		setFile(new File(directory, fileName));
	}
	
	
	/**
	 * Create a parser from a File object
	 * 
	 * @param file The File to be parsed
	 * @throws FileNotFoundException If the file could not be found
	 */
	protected AbstractFileParser(File file) throws FileNotFoundException
	{
		if(file == null)
		{
			throw new FileNotFoundException("A null file cannot be parsed");
		}
		
		setFile(file);
	}

	/**
	 * The file being parsed
	 * 
	 * @return The file for this parser
	 */
	public File getFile()
	{
		return this.file;
	}


	/**
	 * Set the file that needs to be parsed
	 * 
	 * @param file The file to be parsed
	 * @throws FileNotFoundException If the file is null or a not a directory
	 */
	public void setFile(File file) throws FileNotFoundException
	{
		if(file == null)
		{
			throw new FileNotFoundException("A null file cannot be parsed");
		}
		
		if(!file.isFile())
		{
			throw new FileNotFoundException("This file object cannot be parsed because it is not a file");
		}
		
		this.file = file;
	}

	/**
	 * The contents of the file as an object
	 * 
	 * @return the fileContents
	 */
	public O getFileContents()
	{
		return this.fileContents;
	}

	/**
	 * Setter for attribute fileContents
	 *
	 * @param fileContents the fileContents to set
	 */
	public void setFileContents(O fileContents)
	{
		this.fileContents = fileContents;
	}
}
