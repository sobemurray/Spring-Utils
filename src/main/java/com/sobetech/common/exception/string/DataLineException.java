/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2019 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 * 
 */
package com.sobetech.common.exception.string;


/**
 * Basic Exception class to signify problems with DataLine objects and their usage.
 * 
 * @author John Murray
 * 
 * @since 0.0.2
 */
public class DataLineException extends Exception
{

    private static final long serialVersionUID = 1029467033051512194L;

    /**
     * Empty exception
     */
    public DataLineException()
    {
    }

    /**
     * Create exception with a message
     * 
     * @param message The message to include with this exception
     */
    public DataLineException(String message)
    {
        super(message);
    }

    /**
     * Create exception with a message and the cause
     * 
     * @param message The message to include with this exception
     * @param cause The underlying cause of this exception
     */
	public DataLineException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
     * Create exception with a r cause
     * 
	 * @param cause The underlying cause of this exception
	 */
	public DataLineException(Throwable cause)
	{
		super(cause);
	}
}
