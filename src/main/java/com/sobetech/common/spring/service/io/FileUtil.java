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
package com.sobetech.common.spring.service.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

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
	
	public boolean savePlayersFile(String filePath, Collection<Object> objectsToWriteToFile)
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
} 