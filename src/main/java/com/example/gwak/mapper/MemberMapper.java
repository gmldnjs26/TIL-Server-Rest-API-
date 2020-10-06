package com.example.gwak.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.gwak.dto.Member;

@Mapper
public interface MemberMapper {
	public int join(Member memberVO);
	public Member selectOne(String username);
}
