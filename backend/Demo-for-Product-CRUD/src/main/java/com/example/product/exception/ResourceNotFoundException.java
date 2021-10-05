package com.example.product.exception;

/**
 * WrapperException class for RuntimeException
 * 
 * @author home
 * @version 1.0
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
