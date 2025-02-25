/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2025 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.service.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit class to perform tests for the NameParser class
 *
 * @author Murray Murray
 *
 * @since Feb 18, 2025
 *
 */
public class NameParserTest
{
	private NameParser nameParser = new NameParser();

	private String madonna = "Madonna";
	private String johnMurray = "Murray Murray";
	private String johnMurrayJr = "Murray Murray Jr";
	private String johnMurraySr = "Murray Murray Sr";
	private String johnMurrayII = "Murray Murray II";
	private String johnMurrayIII = "Murray Murray III";
	private String johnMurrayIV = "Murray Murray IV";
	private String jjWatt = "J J Watt";
	private String jjWattWithPeriods = "J. J. Watt";
	private String fMurrayAbraham = "F Murray Abraham";
	private String fMurrayAbrahamPeriods = "F. Murray Abraham";
	private String lucasVanNess = "Lucas Van Ness";
	private String janMichaelVincent = "Jan Michael Vincent";
	private String janMichaelVincentJr = "Jan Michael Vincent JR";
	private String michaelFWilbon = "Michael F Wilbon";
	
	/**
	 * Test the getFirstName method that returns expected results
	 */
	@Test
	public void getFirstNameTest()
	{
		assertEquals("Madonna", nameParser.getFirstName(madonna), "getFirstName for " + madonna + " should return 'Madonna'");
		assertEquals("Murray", nameParser.getFirstName(johnMurray), "getFirstName for " + johnMurray + " should return 'Murray'");
		assertEquals("Murray", nameParser.getFirstName(johnMurrayJr), "getFirstName for " + johnMurrayJr + " should return 'Murray'");
		assertEquals("Murray", nameParser.getFirstName(johnMurraySr), "getFirstName for " + johnMurraySr + " should return 'Murray'");
		assertEquals("Murray", nameParser.getFirstName(johnMurrayII), "getFirstName for " + johnMurrayII + " should return 'Murray'");
		assertEquals("Murray", nameParser.getFirstName(johnMurrayIII), "getFirstName for " + johnMurrayIII + " should return 'Murray'");
		assertEquals("Murray", nameParser.getFirstName(johnMurrayIV), "getFirstName for " + johnMurrayIV + " should return 'Murray'");
		assertEquals("J", nameParser.getFirstName(jjWatt), "getFirstName for " + jjWatt + " should return 'J'");
		assertEquals("J. J.", nameParser.getFirstName(jjWattWithPeriods), "getFirstName for " + jjWattWithPeriods + " should return 'J. J.'");
		assertEquals("Lucas", nameParser.getFirstName(lucasVanNess), "getFirstName for " + lucasVanNess + " should return 'Lucas'");
		assertEquals("Jan", nameParser.getFirstName(janMichaelVincent), "getFirstName for " + janMichaelVincent + " should return 'Jan'");
		assertEquals("Michael", nameParser.getFirstName(michaelFWilbon), "getFirstName for " + michaelFWilbon + " should return 'Michael'");
	}
	
	/**
	 * Test the getFirstName method with inputs that are not currently handled by this parser
	 */
	@Test
	public void getFirstNameTestExemptions()
	{
		assertNotEquals("F", nameParser.getFirstName(fMurrayAbraham), "getFirstName for " + fMurrayAbraham + " should not return 'F'");
		assertNotEquals("F.", nameParser.getFirstName(fMurrayAbrahamPeriods), "getFirstName for " + fMurrayAbrahamPeriods + " should not return 'F.'");
		assertNotEquals("Jan", nameParser.getFirstName(janMichaelVincentJr), "getFirstName for " + janMichaelVincentJr + " should not return 'Jan'");
	}
	
	/**
	 * Test the getLastName method that returns expected results
	 */
	@Test
	public void getLastNameTest()
	{
		assertEquals("", nameParser.getLastName(madonna), "getLastName for " + madonna + " should return an empty String");
		assertEquals("Murray", nameParser.getLastName(johnMurray), "getLastName for " + johnMurray + " should return 'Murray'");
		assertEquals("Murray", nameParser.getLastName(johnMurrayJr), "getLastName for " + johnMurrayJr + " should return 'Murray'");
		assertEquals("Murray", nameParser.getLastName(johnMurraySr), "getLastName for " + johnMurraySr + " should return 'Murray'");
		assertEquals("Murray", nameParser.getLastName(johnMurrayII), "getLastName for " + johnMurrayII + " should return 'Murray'");
		assertEquals("Murray", nameParser.getLastName(johnMurrayIII), "getLastName for " + johnMurrayIII + " should return 'Murray'");
		assertEquals("Murray", nameParser.getLastName(johnMurrayIV), "getLastName for " + johnMurrayIV + " should return 'Murray'");
		assertEquals("Watt", nameParser.getLastName(jjWatt), "getLastName for " + jjWatt + " should return 'Watt'");
		assertEquals("Watt", nameParser.getLastName(jjWattWithPeriods), "getLastName for " + jjWattWithPeriods + " should return 'Watt'");
		assertEquals("Van Ness", nameParser.getLastName(lucasVanNess), "getLastName for " + lucasVanNess + " should return 'Van Ness'");
		assertEquals("Vincent", nameParser.getLastName(janMichaelVincent), "getLastName for " + janMichaelVincent + " should return 'Vincent'");
		assertEquals("Wilbon", nameParser.getLastName(michaelFWilbon), "getLastName for " + michaelFWilbon + " should return 'Wilbon'");
	}
	
	/**
	 * Test the getLastName method with inputs that are not currently handled by this parser
	 */
	@Test
	public void getLastNameTestExemptions()
	{
		assertNotEquals("Abraham", nameParser.getLastName(fMurrayAbraham), "getLastName for " + fMurrayAbraham + " should return 'Abraham'");
		assertNotEquals("Abraham", nameParser.getLastName(fMurrayAbrahamPeriods), "getLastName for " + fMurrayAbrahamPeriods + " should return 'Abraham'");
		assertNotEquals("Vincent", nameParser.getLastName(janMichaelVincentJr), "getLastName for " + janMichaelVincentJr + " should return 'Vincent'");
	}
	
	/**
	 * Test the getMiddleName method where there is no middle name or initial
	 */
	@Test
	public void getMiddleNameEmptyTest()
	{
		assertEquals("", nameParser.getMiddleName(madonna), "getMiddleName for " + madonna + " should return an empty String");
		assertEquals("", nameParser.getMiddleName(johnMurray), "getMiddleName for " + johnMurray + " should return an empty String");
		assertEquals("", nameParser.getMiddleName(johnMurrayJr), "getMiddleName for " + johnMurrayJr + " should return an empty String");
		assertEquals("", nameParser.getMiddleName(johnMurraySr), "getMiddleName for " + johnMurraySr + " should return an empty String");
		assertEquals("", nameParser.getMiddleName(johnMurrayII), "getMiddleName for " + johnMurrayII + " should return an empty String");
		assertEquals("", nameParser.getMiddleName(johnMurrayIII), "getMiddleName for " + johnMurrayIII + " should return an empty String");
		assertEquals("", nameParser.getMiddleName(johnMurrayIV), "getMiddleName for " + johnMurrayIV + " should return an empty String");
		assertEquals("", nameParser.getMiddleName(jjWattWithPeriods), "getMiddleName for " + jjWattWithPeriods + " should return an empty String");
		assertEquals("", nameParser.getMiddleName(lucasVanNess), "getMiddleName for " + lucasVanNess + " should return an empty String");
	}
	
	/**
	 * Test the getMiddleName method where there is a middle name or initial
	 */
	@Test
	public void getMiddleNamePopulatedTest()
	{
		assertEquals("J", nameParser.getMiddleName(jjWatt), "getMiddleName for " + jjWatt + " should return 'J'");
		assertEquals("Michael", nameParser.getMiddleName(janMichaelVincent), "getMiddleName for " + janMichaelVincent + " should return 'Michael'");
		assertEquals("F", nameParser.getMiddleName(michaelFWilbon), "getMiddleName for " + michaelFWilbon + " should return 'F'");
	}
	
	/**
	 * Test the getMiddleName method with inputs that are not currently handled by this parser
	 */
	@Test
	public void getMiddleNameTestExemptions()
	{
		assertNotEquals("Abraham", nameParser.getMiddleName(fMurrayAbraham), "getMiddleName for " + fMurrayAbraham + " should return 'Abraham'");
		assertNotEquals("Abraham", nameParser.getMiddleName(fMurrayAbrahamPeriods), "getMiddleName for " + fMurrayAbrahamPeriods + " should return 'Abraham'");
		assertNotEquals("Vincent", nameParser.getMiddleName(janMichaelVincentJr), "getMiddleName for " + janMichaelVincentJr + " should return 'Vincent'");
	}
	
	/**
	 * Test the getSuffix method for names without a suffix
	 */
	@Test
	public void getSuffixEmptyTest()
	{
		assertEquals("", nameParser.getSuffix(madonna), "getSuffix for " + madonna + " should return an empty String");
		assertEquals("", nameParser.getSuffix(johnMurray), "getSuffix for " + johnMurray + " should return an empty String");
		assertEquals("", nameParser.getSuffix(jjWatt), "getSuffix for " + jjWatt + " should return an empty String");
		assertEquals("", nameParser.getSuffix(jjWattWithPeriods), "getSuffix for " + jjWattWithPeriods + " should return an empty String");
		assertEquals("", nameParser.getSuffix(lucasVanNess), "getSuffix for " + lucasVanNess + " should return an empty String");
		assertEquals("", nameParser.getSuffix(fMurrayAbraham), "getMiddleName for " + fMurrayAbraham + " should return an empty String");
		assertEquals("", nameParser.getSuffix(fMurrayAbrahamPeriods), "getMiddleName for " + fMurrayAbrahamPeriods + " should return an empty String");
		assertEquals("", nameParser.getSuffix(janMichaelVincentJr), "getMiddleName for " + janMichaelVincentJr + " should return an empty String");
		assertEquals("", nameParser.getSuffix(janMichaelVincent), "getSuffix for " + janMichaelVincent + " should return an empty String");
		assertEquals("", nameParser.getSuffix(michaelFWilbon), "getSuffix for " + michaelFWilbon + " should return an empty String");
	}
	
	/**
	 * Test the getSuffix method for names with a suffix
	 */
	@Test
	public void getSuffixPopulatedTest()
	{
		assertEquals("JR", nameParser.getSuffix(johnMurrayJr), "getSuffix for " + johnMurrayJr + " should return 'JR'");
		assertEquals("SR", nameParser.getSuffix(johnMurraySr), "getSuffix for " + johnMurraySr + " should return 'SR'");
		assertEquals("II", nameParser.getSuffix(johnMurrayII), "getSuffix for " + johnMurrayII + " should return 'II'");
		assertEquals("III", nameParser.getSuffix(johnMurrayIII), "getSuffix for " + johnMurrayIII + " should return 'III'");
		assertEquals("IV", nameParser.getSuffix(johnMurrayIV), "getSuffix for " + johnMurrayIV + " should return 'IV'");
	}
	
	/**
	 * Test the hasSuffix method for names with a suffix
	 */
	@Test
	public void hasSuffixTrueTest()
	{
		assertTrue(nameParser.hasSuffix(johnMurrayJr), "hasSuffix for " + johnMurrayJr + " should return true");
		assertTrue(nameParser.hasSuffix(johnMurraySr), "hasSuffix for " + johnMurraySr + " should return true");
		assertTrue(nameParser.hasSuffix(johnMurrayII), "hasSuffix for " + johnMurrayII + " should return 'true");
		assertTrue(nameParser.hasSuffix(johnMurrayIII), "hasSuffix for " + johnMurrayIII + " should return true");
		assertTrue(nameParser.hasSuffix(johnMurrayIV), "hasSuffix for " + johnMurrayIV + " should return true");
	}
	
	/**
	 * Test the hasSuffix method for names without a suffix
	 */
	@Test
	public void hasSuffixFalseTest()
	{
		assertFalse(nameParser.hasSuffix(madonna), "hasSuffix for " + madonna + " should return false");
		assertFalse(nameParser.hasSuffix(johnMurray), "hasSuffix for " + johnMurray + " should return false");
		assertFalse(nameParser.hasSuffix(jjWatt), "hasSuffix for " + jjWatt + " should return false");
		assertFalse(nameParser.hasSuffix(jjWattWithPeriods), "hasSuffix for " + jjWattWithPeriods + " should return false");
		assertFalse(nameParser.hasSuffix(lucasVanNess), "hasSuffix for " + lucasVanNess + " should return false");
		assertFalse(nameParser.hasSuffix(fMurrayAbraham), "getMiddleName for " + fMurrayAbraham + " should return false");
		assertFalse(nameParser.hasSuffix(fMurrayAbrahamPeriods), "getMiddleName for " + fMurrayAbrahamPeriods + " should return false");
		assertFalse(nameParser.hasSuffix(janMichaelVincentJr), "getMiddleName for " + janMichaelVincentJr + " should return false");
		assertFalse(nameParser.hasSuffix(janMichaelVincent), "hasSuffix for " + janMichaelVincent + " should return false");
		assertFalse(nameParser.hasSuffix(michaelFWilbon), "hasSuffix for " + michaelFWilbon + " should return false");
	}
}
