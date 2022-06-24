package com.zensar.entity;

public class ErrorResponse {
	 private int statusCode;
	 private String message;
	public ErrorResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorResponse [statusCode=" + statusCode + ", message=" + message + "]";
	}

}
