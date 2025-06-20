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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.sobetech.common.enums.BooleanFormat;

/**
 * JUnit test class for StringUtil
 *
 * @author John Murray
 *
 * @since Jun 17, 2025
 *
 */
public class SpringUtilTest
{
	private final StringUtil util = new StringUtil();

    @Test
    void testIsNullOrBlank() {
        assertTrue(util.isNullOrBlank(null));
        assertTrue(util.isNullOrBlank(""));
        assertTrue(util.isNullOrBlank("   "));
        assertFalse(util.isNullOrBlank("abc"));
    }

    @Test
    void testIsNotNullOrBlank() {
        assertFalse(util.isNotNullOrBlank(null));
        assertFalse(util.isNotNullOrBlank(""));
        assertFalse(util.isNotNullOrBlank(" "));
        assertTrue(util.isNotNullOrBlank("abc"));
    }

    @Test
    void testIsPresent() {
        assertFalse(util.isPresent(null));
        assertFalse(util.isPresent(""));
        assertFalse(util.isPresent(" "));
        assertTrue(util.isPresent("present"));
    }

    @Test
    void testNullSafeEqualsWithoutTrim() {
        assertTrue(util.nullSafeEquals(null, null));
        assertFalse(util.nullSafeEquals(null, "abc"));
        assertFalse(util.nullSafeEquals("abc", null));
        assertTrue(util.nullSafeEquals("abc", "abc"));
        assertFalse(util.nullSafeEquals("abc", " abc "));
    }

    @Test
    void testNullSafeEqualsWithTrim() {
        assertTrue(util.nullSafeEquals("abc", " abc ", true));
        assertFalse(util.nullSafeEquals("abc", "xyz", true));
    }

    @Test
    void testNullSafeEqualsIgnoreCaseWithoutTrim() {
        assertTrue(util.nullSafeEqualsIgnoreCase("ABC", "abc"));
        assertFalse(util.nullSafeEqualsIgnoreCase("abc", " abc "));
        assertTrue(util.nullSafeEqualsIgnoreCase(null, null));
        assertFalse(util.nullSafeEqualsIgnoreCase(null, "abc"));
    }

    @Test
    void testNullSafeEqualsIgnoreCaseWithTrim() {
        assertTrue(util.nullSafeEqualsIgnoreCase("abc", " abc ", true));
        assertTrue(util.nullSafeEqualsIgnoreCase("ABC", " abc ", true));
        assertFalse(util.nullSafeEqualsIgnoreCase("abc", "def", true));
    }
    
 // --- isLowerCase ---
    @Test
    void testIsLowerCase() {
        assertTrue(util.isLowerCase("abc"));
        assertFalse(util.isLowerCase("Abc"));
        assertFalse(util.isLowerCase("ABC"));
        assertTrue(util.isLowerCase(""));
        assertFalse(util.isLowerCase(null));
    }

    // --- isUpperCase ---
    @Test
    void testIsUpperCase() {
        assertTrue(util.isUpperCase("ABC"));
        assertFalse(util.isUpperCase("abc"));
        assertFalse(util.isUpperCase("Abc"));
        assertTrue(util.isUpperCase(""));
        assertFalse(util.isUpperCase(null));
    }

    // --- isNumeric ---
    @Test
    void testIsNumeric() {
        assertTrue(util.isNumeric("123"));
        assertTrue(util.isNumeric("123.45"));
        assertFalse(util.isNumeric("abc"));
        assertFalse(util.isNumeric(""));
        assertFalse(util.isNumeric(null));
    }

    // --- isUUID ---
    @Test
    void testIsUUID() {
        String validUUID = UUID.randomUUID().toString();
        assertTrue(util.isUUID(validUUID));
        assertFalse(util.isUUID("not-a-uuid"));
        assertFalse(util.isUUID(""));
        assertFalse(util.isUUID(null));
    }

    // --- toCharString ---
    @Test
    void testToCharString() {
        assertEquals("abc", util.toCharString('a', 'b', 'c'));
        assertEquals("", util.toCharString());
        assertEquals("", util.toCharString(null));
    }

    // --- getRandomAlphabeticString ---
    @Test
    void testGetRandomAlphabeticString() {
        String result = util.getRandomAlphabeticString(10);
        assertEquals(10, result.length());
        assertTrue(result.matches("[A-Za-z]{10}"));
    }

    // --- getRandomAlphanumericString ---
    @Test
    void testGetRandomAlphanumericString() {
        String result = util.getRandomAlphanumericString(15);
        assertEquals(15, result.length());
        assertTrue(result.matches("[A-Za-z0-9]{15}"));
    }
    
    @Test
    void testSafeToStringDefault() {
        assertEquals("", util.safeToString(null));
        assertEquals("123", util.safeToString(123));
        assertEquals("true", util.safeToString(true));
    }

    @Test
    void testSafeToStringWithDefault() {
        assertEquals("default", util.safeToString(null, "default"));
        assertEquals("value", util.safeToString("value", "default"));
    }

    @Test
    void testIsOneOfTheseStringsIgnoreCase() {
        assertTrue(util.isOneOfTheseStrings("apple", "Banana", "APPLE", "orange"));
        assertFalse(util.isOneOfTheseStrings("kiwi", "grape", "melon"));
    }

    @Test
    void testIsOneOfTheseStringsWithCaseSensitivity() {
        assertTrue(util.isOneOfTheseStrings("apple", false, "apple", "banana"));
        assertFalse(util.isOneOfTheseStrings("apple", false, "APPLE", "banana"));
    }

    @Test
    void testIsNotOneOfTheseStrings() {
        assertTrue(util.isNotOneOfTheseStrings("kiwi", "apple", "banana"));
        assertFalse(util.isNotOneOfTheseStrings("apple", "APPLE", "banana"));
    }

    @Test
    void testIsTrue() {
        assertTrue(util.isTrue("yes"));
        assertTrue(util.isTrue("y"));
        assertTrue(util.isTrue("Yes - Finished"));
        assertTrue(util.isTrue("YES - Unfinished"));
        assertFalse(util.isTrue("no"));
        assertFalse(util.isTrue(null));
        assertFalse(util.isTrue("yep"));
    }

    @Test
    void testToStringBoolean() {
        assertEquals("Y", util.toString(Boolean.TRUE, BooleanFormat.Y_N_UPPER_CASE));
        assertEquals("N", util.toString(Boolean.FALSE, BooleanFormat.Y_N_UPPER_CASE));
        assertNull(util.toString(null, BooleanFormat.Y_N_UPPER_CASE));
        assertEquals("", util.toString(null, BooleanFormat.Y_N_UPPER_CASE_NO_NULL));
    }

    @Test
    void testToStringBooleanThrowsOnNullFormat() {
        assertThrows(IllegalArgumentException.class, () -> util.toString(Boolean.TRUE, null));
    }

    @Test
    void testTodayAsString() {
        String format = "yyyy-MM-dd";
        String result = util.todayAsString(format);
        String expected = LocalDate.now().format(DateTimeFormatter.ofPattern(format));
        assertEquals(expected, result);
    }

    @Test
    void testNowAsString() {
        String format = "yyyy-MM-dd HH:mm";
        String result = util.nowAsString(format);
        String prefix = LocalDateTime.now().format(DateTimeFormatter.ofPattern(format)).substring(0, 13);
        assertTrue(result.startsWith(prefix)); // Only check partial match for timing tolerance
    }

    @Test
    void testFormatNumber() {
        assertEquals("1,234.56", util.formatNumber(1234.56, "#,###.##"));
        assertEquals("0", util.formatNumber(null, "#"));
    }

    @Test
    void testFormatNumberWithDefaultPattern() {
        String result = util.formatNumber(1234567.89, null);
        assertTrue(result.matches("[\\d,\\.\\-]+"));
    }

    @Test
    void testFormatDollarsAsK() {
        assertEquals("$250k", util.formatDollarsAsK(250000));
        assertEquals("$0k", util.formatDollarsAsK(0));
        assertEquals("", util.formatDollarsAsK(null));
    }
    @Test
    void testSplitCount() {
        assertEquals(3, util.splitCount("a,b,c", ','));
        assertEquals(1, util.splitCount("abc", ','));
        assertEquals(0, util.splitCount(null, ','));
        assertEquals(0, util.splitCount("   ", ','));
    }

    @Test
    void testGetSubstringBetweenSuccess() {
        String input = "I would like you to parse this string for me";
        assertEquals("to parse this string", util.getSubstringBetween(input, "like you ", " for"));
    }

    @Test
    void testGetSubstringBetweenNotFound() {
        assertEquals("", util.getSubstringBetween("a b c", "x", "c"));
        assertEquals("", util.getSubstringBetween("start middle end", "start", "nope"));
    }

    @Test
    void testGetSubstringBetweenInvalidArgs() {
        assertThrows(IllegalArgumentException.class, () -> util.getSubstringBetween(null, "x", "y"));
        assertThrows(IllegalArgumentException.class, () -> util.getSubstringBetween("", "x", "y"));
        assertThrows(IllegalArgumentException.class, () -> util.getSubstringBetween("test", "", "y"));
        assertThrows(IllegalArgumentException.class, () -> util.getSubstringBetween("test", "x", ""));
    }

    @Test
    void testToJsonStringWithoutWhitespace() {
        DummyObject obj = new DummyObject("Alice", 30);
        String json = util.toJsonString(obj);
        assertTrue(json.contains("Alice"));
        assertTrue(json.contains("30"));
        assertTrue(json.contains("name"));
        assertTrue(json.contains("age"));
    }

    @Test
    void testToJsonStringWithWhitespaceRemoval() {
        DummyObject obj = new DummyObject("Bob", 42);
        String minified = util.toJsonString(obj, true);
        assertFalse(minified.contains(" "));
        assertFalse(minified.contains("\n"));
        assertTrue(minified.contains("\"name\":\"Bob\""));
    }

    @Test
    void testRemoveJsonWhitespace() {
        String formattedJson = "{\n  \"name\": \"Charlie\",\n  \"age\": 25\n}";
        String compact = util.removeJsonWhitespace(formattedJson);
        assertEquals("{\"name\":\"Charlie\",\"age\":25}", compact);
    }

    @Test
    void testRemoveJsonWhitespaceInvalidJson() {
        String badJson = "{this is not valid JSON}";
        String result = util.removeJsonWhitespace(badJson);
        assertEquals(badJson, result);
    }

    @Test
    void testRemoveJsonWhitespaceNullInput() {
        assertNull(util.removeJsonWhitespace(null));
    }

    static class DummyObject {
        @JsonProperty
        private final String name;
        @JsonProperty
        private final int age;

        DummyObject(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
