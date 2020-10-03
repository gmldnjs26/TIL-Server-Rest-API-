package com.example.gwak.dto;

import lombok.Builder;

@Builder
public class AuthDto {
	private Member member;
	private String token;
}
