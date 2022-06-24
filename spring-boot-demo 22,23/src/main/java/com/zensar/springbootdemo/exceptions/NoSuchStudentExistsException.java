package com.zensar.springbootdemo.exceptions;

public class NoSuchStudentExistsException extends RuntimeException{
	private String message;

	public NoSuchStudentExistsException() {
		super();
		
	}

	public NoSuchStudentExistsException(String message) {
		super(message);
		this.message = message;
	}
	

}
