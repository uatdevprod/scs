package com.StoreCounterSystem.exception;

@SuppressWarnings("serial")

public class IdNotFoundException extends RuntimeException {
	public IdNotFoundException(String message) {
		super(message);
	}
}
