/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2007 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 * 
 */
package com.sobetech.common.exception.io;

import java.io.IOException;

/**
 * Exception class to signify that a host name is illegal
 * 
 * @author John Murray
 * 
 * @since 0.2.0
 */
public class IllegalHostNameException extends IOException
{

    /**
     * 
     */
    private static final long serialVersionUID = -4237915215461340554L;

    /**
     * 
     */
    public IllegalHostNameException()
    {
    }

    /**
     * Create exception with a message
     * 
     * @param message The message to include with this exception
     */
    public IllegalHostNameException(String message)
    {
        super(message);
    }

    /**
     * Create exception with a message and the cause
     * 
     * @param message The message to include with this exception
     * @param cause The underlying cause of this exception
     */
	public IllegalHostNameException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
     * Create exception with a r cause
     * 
	 * @param cause The underlying cause of this exception
	 */
	public IllegalHostNameException(Throwable cause)
	{
		super(cause);
	}
}