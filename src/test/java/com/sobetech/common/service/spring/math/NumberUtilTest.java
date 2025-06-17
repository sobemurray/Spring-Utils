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
package com.sobetech.common.service.spring.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sobetech.common.exception.ApiRuntimeException;

/**
 * JUnit test class for NumberUtil
 *
 * @author John Murray
 *
 * @since Jun 17, 2025
 *
 */
public class NumberUtilTest
{
	private final NumberUtil numberUtil = new NumberUtil();

	@Test
	void testGetRandomInt()
	{
		for(int i = 0; i < 100; i++)
		{
			int value = numberUtil.getRandomInt(10, 20);
			assertTrue(value >= 10 && value < 20);
		}
	}

	@Test
	void testToDouble()
	{
		assertEquals(10.5, numberUtil.toDouble("10.5"));
		assertEquals(0.0, numberUtil.toDouble("abc"));
		assertEquals(5.5, numberUtil.toDouble("bad", 5.5));
	}

	@Test
	void testToFloat()
	{
		assertEquals(10.5f, numberUtil.toFloat("10.5"));
		assertEquals(0f, numberUtil.toFloat("abc"));
		assertEquals(4.4f, numberUtil.toFloat(null, 4.4f));
	}

	@Test
	void testToInteger()
	{
		assertEquals(10, numberUtil.toInteger("10"));
		assertEquals(0, numberUtil.toInteger("abc"));
		assertEquals(42, numberUtil.toInteger("", 42));
	}

	@Test
	void testToLong()
	{
		assertEquals(10000000000L, numberUtil.toLong("10000000000"));
		assertEquals(0L, numberUtil.toLong("abc"));
		assertEquals(7L, numberUtil.toLong(null, 7L));
	}

	@Test
	void testToShort()
	{
		assertEquals((short) 10, numberUtil.toShort("10"));
		assertEquals((short) 0, numberUtil.toShort("not-a-number"));
		assertEquals((short) 9, numberUtil.toShort("", (short) 9));
	}

	@Test
	void testEquals()
	{
		assertTrue(numberUtil.equals(10, 10));
		assertFalse(numberUtil.equals(null, 10));
		assertFalse(numberUtil.equals(5, null));
		assertFalse(numberUtil.equals(5, 10));
	}

	@Test
	void testGreaterThan()
	{
		assertTrue(numberUtil.greaterThan(10, 5));
		assertFalse(numberUtil.greaterThan(5, 10));
		assertFalse(numberUtil.greaterThan(null, 1));
	}

	@Test
	void testGreaterThanEquals()
	{
		assertTrue(numberUtil.greaterThanEquals(10, 10));
		assertTrue(numberUtil.greaterThanEquals(20, 10));
		assertFalse(numberUtil.greaterThanEquals(10, 20));
	}

	@Test
	void testLessThan()
	{
		assertTrue(numberUtil.lessThan(1, 5));
		assertFalse(numberUtil.lessThan(5, 1));
		assertFalse(numberUtil.lessThan(null, 1));
	}

	@Test
	void testLessThanEquals()
	{
		assertTrue(numberUtil.lessThanEquals(5, 5));
		assertTrue(numberUtil.lessThanEquals(5, 10));
		assertFalse(numberUtil.lessThanEquals(10, 5));
	}

	@Test
	void testCalculateMean()
	{
		assertEquals(new BigDecimal("0.2500"), numberUtil.calculateMean(1, 4));
		assertEquals(new BigDecimal("0.25"), numberUtil.calculateMean(1, 4, 2));
		assertEquals(BigDecimal.ZERO, numberUtil.calculateMean(1, 0));
	}

	@Test
	void testCalculatePercentage()
	{
		assertEquals(new BigDecimal("25.0000"), numberUtil.calculatePercentage(1, 4));
		assertEquals(new BigDecimal("25.00"), numberUtil.calculatePercentage(1, 4, 2));
		assertThrows(ApiRuntimeException.class, () -> numberUtil.calculatePercentage(1, 0));
	}

	@Test
	void testCalculateMedianOdd()
	{
		List<Integer> numbers = Arrays.asList(3, 1, 2);
		assertEquals(2.0, numberUtil.calculateMedian(numbers));
	}

	@Test
	void testCalculateMedianEven()
	{
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		assertEquals(2.5, numberUtil.calculateMedian(numbers));
	}

	@Test
	void testCalculateMedianEmpty()
	{
		assertThrows(IllegalArgumentException.class, () -> numberUtil.calculateMedian(Collections.emptyList()));
	}
}
