package com.kaiherrera.chargeaep.service.slack;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.kaiherrera.chargeaep.domain.slack.SlackUser;
import com.kaiherrera.chargeaep.domain.slack.SlackUserResponse;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = As.PROPERTY,
		property = "ok"
)
@JsonSubTypes({
	@JsonSubTypes.Type(value = SlackUserResponse.class, name = "true"),
	@JsonSubTypes.Type(value = SlackErrorResponse.class, name = "false")
})
abstract public class SlackResponse {
	
	public boolean isOk() {
		return false;
	}
	
	public SlackUser getUser() {
		return null;
	}

	public String getError() {
		return null;
	}
}

