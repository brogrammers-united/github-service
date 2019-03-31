package org.bgu.model.json;

import java.io.IOException;

import org.bgu.model.GhRepositoryResponse;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class GhRepositoryResponseDeserializer extends StdDeserializer<GhRepositoryResponse> {

	private static final long serialVersionUID = 1L;

	public GhRepositoryResponseDeserializer() {
		this(null);
	}
	
	public GhRepositoryResponseDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public GhRepositoryResponse deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		return new GhRepositoryResponse(
					node.get("id").asText(),
					node.get("name").asText(),
					node.get("html_url").asText(),
					node.get("clone_url").asText(),
					node.get("ssh_url").asText()
				);
	}

}
