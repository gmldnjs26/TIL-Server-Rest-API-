package com.example.gwak.exception.errdto;

import lombok.Data;

@Data
public class AppError {
	private String code;
	private String message;
}
