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
package com.sobetech.common.model.io;

import com.sobetech.common.model.string.TextLine;

/**
 * An AbstractFile implementation for files containing TextLines
 *
 * @author John Murray
 *
 * @since 0.3.1
 *
 */
public class TextFile extends AbstractFile<TextLine>
{
	/**
	 * Default constructor
	 */
	public TextFile()
	{
		super();
	}
	
	/**
	 * Create a new file with the flag to allow empty lines or not
	 * 
	 * @param allowsEmptyLines If <code>true</code> this file will allow empty lines. This is false by default
	 */
	public TextFile(boolean allowsEmptyLines)
	{
		super(allowsEmptyLines);
	}
}