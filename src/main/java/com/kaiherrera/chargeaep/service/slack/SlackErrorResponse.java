package com.kaiherrera.chargeaep.service.slack;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlackErrorResponse extends SlackResponse {
	
	@JsonProperty
	private boolean ok;
	
	@JsonProperty
	private String error;
	
	public SlackErrorResponse(boolean ok, String error) {
		this.ok = ok;
		this.error = error;
	}
	
	@Override
	public boolean isOk() {
		return false;
	}
	
	@Override
	public String getError() {
		return error;
	}
	
}
