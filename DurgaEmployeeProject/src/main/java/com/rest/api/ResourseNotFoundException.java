package com.rest.api;

public class ResourseNotFoundException extends RuntimeException {
	public ResourseNotFoundException() {
		super("Resouse not found exception");
	}
	public ResourseNotFoundException(String message) {
		super (message);
	}
}
