package com.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restapi.error.Error;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(NoSuchCustomerFound.class)
	public ResponseEntity<Error> noCustomerFoundException(NoSuchCustomerFound ex) {
		Error error = new Error();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}
	
}
