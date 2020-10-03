package com.example.gwak;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<Object> AIOOBHandler(ArrayIndexOutOfBoundsException e) {
		AppError appError = new AppError();
		appError.setCode("AIOO");
		appError.setMessage("ArrayIndexOutOfBoundsException");
		System.out.println("ArrayIndexOutOfBoundsException");
		return new ResponseEntity<Object>(appError,HttpStatus.BAD_REQUEST);
	}
}
