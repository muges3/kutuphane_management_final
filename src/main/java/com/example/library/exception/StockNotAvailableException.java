package com.example.library.exception;

public class StockNotAvailableException extends RuntimeException {

	public StockNotAvailableException(String message) {
		
		super(message);
	}
}
