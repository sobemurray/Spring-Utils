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

import com.sobetech.common.enums.CodedEnum;

/**
 * A Jackson serliazer to use for CodedEnum objects
 *
 * @author John.Murray
 *
 * @since Aug 2, 2023
 *
 */
public class CodedEnumSerializer extends StdSerializer<CodedEnum>
{
	public CodedEnumSerializer() 
	{
		super(CodedEnum.class);
	}
	
	@Override
	public void serialize(CodedEnum codedEnum, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException
	{
		generator.writeString(String.valueOf(codedEnum.getCode()));
	}
}
