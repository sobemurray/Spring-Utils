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
package com.sobetech.common.service.spring.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Java utilities to work with Files
 *
 * @author John Murray
 *
 * @since 0.2.2
 *
 *
 */
@Service
public class FileUtil
{
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Gets the file path string for the resources directory of a codebase
	 * 
	 * @return The file path string for the resources directory of a codebase
	 */
	public String getSourceResourcesPathString()
	{
		Path resourceDirectory = Paths.get("src","main","resources");
		return resourceDirectory.toFile().getAbsolutePath();
	}
	
	/**
	 * Gets the file path string for the test resources directory of a codebase
	 * 
	 * @return The file path string for the test resources directory of a codebase
	 */
	public String getTestResourcesPathString()
	{
		Path resourceDirectory = Paths.get("src","test","resources");
		return resourceDirectory.toFile().getAbsolutePath();
	}
	
	/**
	 * Save a collection of Objects into a File. Each Object will converted into a String by its toString
	 * methods and each of those lines will be written as its own line
	 * 
	 * @param filePath The fully qualified path of the file to be saved
	 * @param objectsToWriteToFile The Collection of Objects to be saved in the file
	 * @return <code>true</code> if the file has been saved successfully
	 */
	public boolean saveFile(String filePath, Collection<? extends Object> objectsToWriteToFile)
	{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
        {
            // Iterate over the list and write each object's data fields separated by pipes
            for (Object objectsToWrite : objectsToWriteToFile) 
            {
                writer.write(objectsToWrite.toString());
                writer.newLine(); // Move to the next line
            }
        } 
        catch (IOException e) 
        {
            LOG.error("File could not be saved", e);
            return false;
        }
        
        return true;
	}
	
	/**
	 * Open a file and convert each line to a String
	 * 
	 * @param filePath The fully qualified path of the file to be saved 
	 * @return The contents of the file as a List of Strings
	 */
	public List<String> openFile(String filePath)
	{
		List<String> lines = new ArrayList<>();
        try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) 
			{
			    lines.add(line);
			}
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			LOG.error("File {} could not be found", filePath);
		}
		catch(IOException e)
		{
			LOG.error("Error in reading file", e);
		}
        return lines;
	}
} 