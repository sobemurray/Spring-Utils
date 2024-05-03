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
package com.sobetech.common.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A POJO that could contain a value as a number or a string. An example from deductible is a
 * set deductible is a number (5000) or a string (5%)
 *
 * @author John.Murray
 *
 * @since Aug 8, 2023
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true) 
public class NumberOrStringValue
{
	/**
	 * Values such as hurricaneDeductible that should be in an enum
	 */
	private String id;
	
	/**
	 * Values such as aopDeductible that should be in an enum
	 */
	private String label;
	
	/*
	 * Holds percentage values as "3%"
	 */
	private String textValue;
	
	/*
	 * Holds real dollar values
	 */
	private BigDecimal value;
	
	/**
	 * Checks this value to see if the value in the object has a numeric value. If for some reason
	 * there are entries in the value AND textValue attribute, then it will be deemed as numeric
	 * 
	 * @return <code>true</code> if the value attribute is not null. Zero is a valid numeric value
	 */
	public boolean isNumericValue()
	{
		if(value == null)
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * Returns a string based on the type of value this object is. If it is numeric Integer is returned. Otherwise
	 * Text will be returned
	 * 
	 * @return If it is numeric 'Integer' is returned. Otherwise 'Text' will be returned
	 */
	public String stringValueType()
	{
		if(isNumericValue())
		{
			return "Integer";
		}

		return "Text";
	}

	/**
	 * Getter for attribute id
	 *
	 * @return the id
	 */
	public String getId()
	{
		return this.id;
	}

	/**
	 * Setter for attribute id
	 *
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * Getter for attribute label
	 *
	 * @return the label
	 */
	public String getLabel()
	{
		return this.label;
	}

	/**
	 * Setter for attribute label
	 *
	 * @param label the label to set
	 */
	public void setLabel(String label)
	{
		this.label = label;
	}

	/**
	 * Getter for attribute textValue
	 *
	 * @return the textValue
	 */
	public String getTextValue()
	{
		return this.textValue;
	}

	/**
	 * Setter for attribute textValue
	 *
	 * @param textValue the textValue to set
	 */
	public void setTextValue(String textValue)
	{
		this.textValue = textValue;
	}

	/**
	 * Getter for attribute value
	 *
	 * @return the value
	 */
	public BigDecimal getValue()
	{
		return this.value;
	}

	/**
	 * Setter for attribute value
	 *
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value)
	{
		this.value = value;
	}
}
