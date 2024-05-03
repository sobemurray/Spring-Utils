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
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.sobetech.common.enums.StringEnum;

/**
 * A Custom Jackson serializer to work with StringEnum objects
 * 
 * @author Nicholas.Peterson
 *
 * @since Jul 18, 2022
 *
 */
public class StringEnumSerializer extends StdSerializer<StringEnum>
{
	private static final long serialVersionUID = 1L;


	public StringEnumSerializer() 
	{
		super(StringEnum.class);
	}
	
	@Override
	public void serialize(StringEnum value, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException
	{
		generator.writeString(value.getValue());
	}
}
