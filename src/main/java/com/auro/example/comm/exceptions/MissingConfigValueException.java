package com.auro.example.comm.exceptions;

public class MissingConfigValueException extends IllegalArgumentException {
	
	public MissingConfigValueException(String message) {
		super(message);
	}
	
	public MissingConfigValueException(String message, Throwable cause) {
		super(message, cause);
	}
}
