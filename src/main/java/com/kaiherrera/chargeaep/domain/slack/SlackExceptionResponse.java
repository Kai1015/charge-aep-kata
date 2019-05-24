package com.kaiherrera.chargeaep.domain.slack;

@SuppressWarnings("serial")
public class SlackExceptionResponse extends Exception {
	
	public SlackExceptionResponse(String error)  {
		super(error);
	}
	
}
