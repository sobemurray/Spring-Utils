/**
 * Created by Sobetech Holdings LLC
 *
 * Copyright © 2022 Sobetech Holdings LLC, All Rights Reserved
 *
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with Sobetech Holdings LLC, or one of its affiliates,
 * and may not be used, disseminated, or distributed except in accordance with
 * the terms of that agreement.
 *
 */
package com.sobetech.common.spring.service.date;

import org.springframework.stereotype.Service;

/**
 * This class generates fibonacci series for timeout wait, every iteration
 * returns next fibonacci number until max is reached.
 * 
 * The use case for this is when you are polling for a response from a remote system and want to start
 * polling on a rapid basis and to increase the wait time as the polling continues. That accounts for 
 * a system that is slow to generate a response not getting bombarded as time passes
 * 
 * @author 
 *
 * @since Sep 6, 2022
 *
 */

@Service
public class TimeoutUtility
{
	int n1 = 0, n2 = 1, n3, max;

	/**
	 * Create a new instance with a maximum number that will be returned
	 * 
	 * @param max The maximum wait time that will be generated
	 */
	public TimeoutUtility(int max)
	{
		this.max = max;
	}

	/**
	 * Get a new wait time based on the previous wait time returned. If the next wait time is greater
	 * than the maximum, then the previous wait time is returned
	 * 
	 * @return The new wait time
	 */
	public int getWaitTime()
	{
		if(n3 < max)
		{
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}
}
