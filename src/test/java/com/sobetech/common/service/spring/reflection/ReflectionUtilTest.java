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
package com.sobetech.common.service.spring.reflection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.lang.reflect.Field;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit class for ReflectionUtil
 *
 * @author John Murray
 *
 * @since Jun 17, 2025
 *
 */
public class ReflectionUtilTest
{

	private ReflectionUtil util;

	@BeforeEach
	void setUp()
	{
		util = new ReflectionUtil();
	}

	@Test
	void testGetAllFields_includesSuperClassFields()
	{
		Set<Field> fields = util.getAllFields(DerivedClass.class);
		assertTrue(fields.stream().anyMatch(f -> f.getName().equals("baseField")));
		assertTrue(fields.stream().anyMatch(f -> f.getName().equals("derivedField")));
	}

	@Test
	void testCopyObjectAttributes_sameFieldNamesAndTypes() throws Exception
	{
		SampleSource source = new SampleSource();
		source.name = "Test Name";
		source.age = 30;

		SampleDestination dest = new SampleDestination();
		SampleDestination result = util.copyObjectAttributes(source, dest);

		assertEquals("Test Name", result.name);
		assertEquals(30, result.age);
	}

	@Test
	void testCreateAndCopyAttributes_returnsCopiedObject() throws Exception
	{
		SampleSource source = new SampleSource();
		source.name = "Copied Name";
		source.age = 99;

		SampleDestination result = util.createAndCopyAttributes(source, SampleDestination.class, false);
		assertEquals("Copied Name", result.name);
		assertEquals(99, result.age);
	}

	@Test
	void testCreateAndCopyAttributes_returnsNullIfSourceIsNull() throws Exception
	{
		SampleDestination result = util.createAndCopyAttributes(null, SampleDestination.class, false);
		assertNull(result);
	}

	// Add test here if you want to test getUiEnumsByClassName
	// Note: That requires a complex classpath setup with runtime scanning.

	// Sample classes for testing
	public static class BaseClass
	{
		@SuppressWarnings("unused")
		private String baseField;
	}

	public static class DerivedClass extends BaseClass
	{
		@SuppressWarnings("unused")
		private int derivedField;
	}

	public static class SampleSource
	{
		public String name;
		public int age;
	}

	public static class SampleDestination
	{
		public String name;
		public int age;
	}
}
