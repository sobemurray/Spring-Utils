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

/**
 * Abstract class containing the scaffolding to create any type of file parser
 * 
 * @author John Murray
 * 
 * @since 0.0.1
 */
public abstract class AbstractFileParser<O extends Object>
{
	private File file;
	
	protected O fileContents;

	/**
	 * Load the file contents into the parser
	 * 
	 * @return The contents of the file after parsing
	 * @throws FileNotFoundException If the file is not correctly initialized in this parser
	 */
	public abstract O parseFile() throws FileNotFoundException;
	
	/**
	 * @throws FileNotFoundException 
	 * 
	 */
	protected AbstractFileParser(String fileName) throws FileNotFoundException
	{
		if( fileName == null || fileName.isEmpty() || fileName.isBlank() )
		{
			throw new FileNotFoundException("File cannot be parsed without a fileName");
		}
		
		setFile(new File(fileName));
	}
	
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
	
	
	protected AbstractFileParser(File file) throws FileNotFoundException
	{
		if(file == null)
		{
			throw new FileNotFoundException("A null file cannot be parsed");
		}
		
		setFile(file);
	}

	/**
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
	 * @return the fileContents
	 */
	public O getFileContents()
	{
		return this.fileContents;
	}
}
