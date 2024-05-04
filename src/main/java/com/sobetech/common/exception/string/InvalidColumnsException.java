/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.exception.string;

/**
 * A DataLineException when the number of columns in a line is not expected
 *
 * @author John Murray
 *
 * @since May 3, 2024
 *
 */
public class InvalidColumnsException extends DataLineException
{
	private static final long serialVersionUID = 562644843906061343L;

	/**
	 * Default constructor
	 */
	public InvalidColumnsException()
	{
    	super();
	}

	/**
     * Create exception with a message
     * 
     * @param message The message to include with this exception
     */
    public InvalidColumnsException(String message)
	{
		super(message);
	}
    
    /**
     * Create exception with a message with the expected and actual number of columns found
     * 
     * @param expectedColumns The expected number of columns
     * @param actualColumns The actual number of columns
     */
	public InvalidColumnsException(int expectedColumns, int actualColumns)
	{
		this(InvalidColumnsException.buildExceptionMessage(expectedColumns, actualColumns));
	}
	
	private static String buildExceptionMessage(int expectedColumns, int actualColumns)
	{
		return String.format("%d numbers were expected and %d were found", expectedColumns, actualColumns);
	}
}
