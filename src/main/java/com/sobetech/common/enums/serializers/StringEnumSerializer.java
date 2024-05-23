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
package com.sobetech.common.enums.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;

import org.springframework.stereotype.Component;

import com.sobetech.common.enums.StringEnum;

/**
 * A Custom Jackson serializer to work with StringEnum objects
 * 
 * @author Nicholas.Peterson
 *
 * @since Jul 18, 2022
 *
 */
@Component
public class StringEnumSerializer extends EnumSerializer<StringEnum>
{
	/**
	 * Default constructor
	 */
	public StringEnumSerializer() 
	{
		super(StringEnum.class);
	}
	
	@Override
	public void serialize(StringEnum value, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException
	{
		if(isStrict())
		{
			generator.writeString(value.toString());
		}
		
		generator.writeString(value.getValue());
	}

	@Override
	protected String getMessageKey()
	{
		return "sobetech.enum.StringEnum.serializer.strict";
	}

}
