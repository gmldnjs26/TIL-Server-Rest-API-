package com.example.gwak.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter // Java Bean 스펙을 준수하면 자동 Converter를 해준다.

/* 로그인시 사용자 정보와 Token을 담아서 반환하기 위해 만든 껍데기 */
public class AuthDto {
	
	private Member member;
	
	private String token;
}
