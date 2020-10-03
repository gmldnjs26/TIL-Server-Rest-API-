package com.example.gwak.service;

import com.example.gwak.dto.AuthDto;
import com.example.gwak.dto.Member;

public interface MemberService {
	public int join(Member memberVO);
	public AuthDto login(Member memberVO) throws Exception;
}
