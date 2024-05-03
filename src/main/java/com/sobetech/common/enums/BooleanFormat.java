/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2023 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.enums;

/**
 * An enum to determine the correct String Format to use when converting a boolean to a string
 *
 * @author John.Murray
 *
 * @since Aug 9, 2023
 *
 */
public enum BooleanFormat
{
	T_F_UPPER_CASE("T", "F", null),
	T_F_UPPER_CASE_NO_NULL("T", "F", ""),
	T_F_LOWER_CASE("t", "f", null),
	T_F_LOWER_CASE_NO_NULL("t", "f", ""),
	Y_N_UPPER_CASE("Y", "N", null),
	Y_N_UPPER_CASE_NO_NULL("Y", "N", ""),
	Y_N_LOWER_CASE("y", "n", null),
	Y_N_LOWER_CASE_NO_NULL("y", "n", ""),
	TRUE_FALSE_UPPER_CASE("TRUE", "FALSE", null),
	TRUE_FALSE_UPPER_CASE_NO_NULL("TRUE", "FALSE", ""),
	TRUE_FALSE_LOWER_CASE("true", "false", null),
	TRUE_FALSE_LOWER_CASE_NO_NULL("true", "false", ""),
	TRUE_FALSE_SPLIT_CASE("True", "False", null),
	TRUE_FALSE_SPLIT_CASE_NO_NULL("True", "False", ""),
	YES_NO_UPPER_CASE("YES", "NO", null),
	YES_NO_UPPER_CASE_NO_NULL("YES", "NO", ""),
	YES_NO_LOWER_CASE("yes", "no", null),
	YES_NO_LOWER_CASE_NO_NULL("yes", "no", ""),
	YES_NO_SPLIT_CASE("Yes", "No", null),
	YES_NO_SPLIT_CASE_NO_NULL("Yes", "No", "");
	
	private String trueString;
	private String falseString;
	private String nullString;
	
	private BooleanFormat(String trueString, String falseString, String nullString)
	{
		this.trueString = trueString;
		this.falseString = falseString;
		this.nullString = nullString;
	}

	/**
	 * Getter for attribute trueString
	 *
	 * @return the trueString
	 */
	public String getTrueString()
	{
		return this.trueString;
	}

	/**
	 * Getter for attribute falseString
	 *
	 * @return the falseString
	 */
	public String getFalseString()
	{
		return this.falseString;
	}

	/**
	 * Getter for attribute nullString
	 *
	 * @return the nullString
	 */
	public String getNullString()
	{
		return this.nullString;
	}
}
