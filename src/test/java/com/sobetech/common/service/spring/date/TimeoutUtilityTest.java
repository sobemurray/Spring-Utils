/**
 * Created by Sobetech Holdings LLC
 *
 * Copyright © 2025 Sobetech Holdings LLC, All Rights Reserved
 *
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with Sobetech Holdings LLC, or one of its affiliates,
 * and may not be used, disseminated, or distributed except in accordance with
 * the terms of that agreement.
 *
 */
package com.sobetech.common.service.spring.date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test for TimeoutUtility
 *
 * @author John Murray
 *
 * @since Jun 17, 2025
 *
 */
public class TimeoutUtilityTest
{
	TimeoutUtility timeoutUtility;

	@BeforeEach
	void setUp()
	{
		// Reset before each test
		timeoutUtility = new TimeoutUtility(100); // max = 100
	}

	@Test
	void testInitialWaitTime()
	{
		// First call should be 1 (0+1)
		assertEquals(1, timeoutUtility.getWaitTime());
	}

	@Test
	void testFibonacciSequenceWithinMax()
	{
		int[] expected = { 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
		for(int expectedValue : expected)
		{
			assertEquals(expectedValue, timeoutUtility.getWaitTime());
		}
	}

	@Test
	void testCappedAtMax()
	{
		timeoutUtility = new TimeoutUtility(10);
		int[] expected = { 1, 2, 3, 5, 8, 10, 10, 10 };
		for(int expectedValue : expected)
		{
			assertEquals(expectedValue, timeoutUtility.getWaitTime());
		}
	}

	@Test
	void testNoMaxCapSet()
	{
		// If max is 0, Fibonacci should stop at 0 and never increment
		timeoutUtility = new TimeoutUtility(0);
		assertEquals(0, timeoutUtility.getWaitTime());
		assertEquals(0, timeoutUtility.getWaitTime());
	}

	@Test
	void testConstructorDefaultBehavior()
	{
		timeoutUtility = new TimeoutUtility(); // max not set
		// max defaults to 0, so should not proceed past 0
		assertEquals(0, timeoutUtility.getWaitTime());
	}
}
