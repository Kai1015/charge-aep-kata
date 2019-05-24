package com.kaiherrera.chargeaep.service.slack;

@SuppressWarnings("serial")
public class SlackExceptionResponse extends Exception {
	
	public SlackExceptionResponse(String error)  {
		super(error);
	}
	
}
