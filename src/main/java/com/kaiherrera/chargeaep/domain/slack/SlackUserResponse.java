package com.kaiherrera.chargeaep.domain.slack;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaiherrera.chargeaep.service.slack.SlackResponse;

public class SlackUserResponse extends SlackResponse {

	@JsonProperty
	private boolean ok;
	
	@JsonProperty
	private SlackUser user;
	
	public SlackUserResponse(boolean ok, SlackUser user) {
		this.ok = ok;
		this.user = user;
	}
	
	@Override
	public boolean isOk() {
		return true;
	}
	
	@Override
	public SlackUser getUser() {
		return user;
	}

}
