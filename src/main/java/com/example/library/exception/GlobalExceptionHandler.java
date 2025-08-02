package com.example.library.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.library.exception.ErrorResponse; 

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleBookNotFound(BookNotFoundException ex) {
	    ErrorResponse error = new ErrorResponse(false, ex.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	 @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<ErrorResponse> handleGeneralError(RuntimeException ex) {
	        ErrorResponse error = new ErrorResponse(false, ex.getMessage());
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	    }
	 
	 
	 @ExceptionHandler(UserNotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex){
		 
		 ErrorResponse error=new ErrorResponse(false, ex.getMessage());
		 return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	 }
	 
	 
	 @ExceptionHandler(StockNotAvailableException.class)
	 public ResponseEntity<ErrorResponse> handleStockError(StockNotAvailableException ex){
		 ErrorResponse error=new ErrorResponse(false, ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		 
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	

}
