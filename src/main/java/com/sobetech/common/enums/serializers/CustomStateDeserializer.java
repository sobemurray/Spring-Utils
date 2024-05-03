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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import com.sobetech.common.enums.State;

import java.io.IOException;

/**
 * A Custom Jackson serializer to work with State objects
 *
 *
 * @author John.Murray
 *
 * @since Dec 2, 2022
 *
 */
public class CustomStateDeserializer extends StdDeserializer<State>
{

	private static final long serialVersionUID = -8913678073665695706L;

	public CustomStateDeserializer()
	{
		super(State.class);
	}

	@Override
	public State deserialize(JsonParser jsonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException
	{
		JsonNode node = jsonParser.getCodec().readTree(jsonParser);
		String value = node.textValue();
		return State.fromString(value);
	}
}
