package com.zensar.product.exceptions;

public class ProductAlreadyExistsException extends RuntimeException {
	private String message;

	public ProductAlreadyExistsException() {
		super();
	}

	public ProductAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

}
