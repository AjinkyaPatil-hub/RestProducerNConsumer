package com.scp.utils;

public class GenericMessages {

	private String Code;
	private String Message;

	public GenericMessages() {
		super();
	}
	public GenericMessages(String code, String message) {
		Code = code;
		Message = message;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	@Override
	public String toString() {
		return "GenericMessages [Code=" + Code + ", Message=" + Message + "]";
	}
	
	
	
}
