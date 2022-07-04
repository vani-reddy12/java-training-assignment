package com.zensar.springbootdemo.exceptions;

public class StudentAlreadyExistsException extends RuntimeException {

	private String message;

	public StudentAlreadyExistsException() {
		super();

	}

	public StudentAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}

}
