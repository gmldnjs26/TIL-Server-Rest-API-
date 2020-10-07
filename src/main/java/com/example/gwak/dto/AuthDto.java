package com.example.gwak.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter // Java Bean 스펙을 준수하면 자동 Converter를 해준다.
public class AuthDto {
	private Member member;
	private String token;
}
