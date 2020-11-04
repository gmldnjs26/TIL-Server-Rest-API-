package com.example.gwak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.gwak.exception.errdto.AppError;
import com.example.gwak.exception.exceptions.CustomLoginException;

@RestControllerAdvice
public class GlobalExceptionController {
	/**
     * Test Error Handler
     */
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<Object> AIOOBHandler(ArrayIndexOutOfBoundsException e) {
		AppError appError = new AppError();
		appError.setCode("AIOO");
		appError.setMessage("ArrayIndexOutOfBoundsException");
		return new ResponseEntity<Object>(appError,HttpStatus.BAD_REQUEST);
	}
	
	/**
     * Login Error Handler
     */
	@ExceptionHandler(CustomLoginException.class)
	public ResponseEntity<Object> CustomLoginExceptionHandler(CustomLoginException e) {
		AppError appError = new AppError();
		appError.setCode(e.getErrCode());
		appError.setMessage(e.getMessage());
		return new ResponseEntity<Object>(appError,HttpStatus.BAD_REQUEST);
	}
}
