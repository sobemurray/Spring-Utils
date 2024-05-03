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

import java.nio.file.Path;
import java.nio.file.Paths;

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
} 