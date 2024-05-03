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
package com.sobetech.common.enums.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.sobetech.common.enums.StringEnum;

/**
 * A Custom Jackson serializer to work with StringEnum objects but to remove underscores in the enum
 *
 * @author John.Murray
 *
 * @since Aug 2, 2023
 *
 */
public class StringEnumUnderscoreSerializer extends StdSerializer<StringEnum>
{
	public StringEnumUnderscoreSerializer() 
	{
		super(StringEnum.class);
	}
	
	@Override
	public void serialize(StringEnum stringEnum, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException
	{
		String enumString = stringEnum.toString();
		generator.writeString(enumString.replaceAll("_", ""));
	}
}
