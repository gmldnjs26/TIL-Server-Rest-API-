package com.example.gwak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gwak.config.security.JwtTokenProvider;
import com.example.gwak.dto.AuthDto;
import com.example.gwak.dto.Member;
import com.example.gwak.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {
	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	/* JWT Token 매번 인증시 사용하는 친구 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberMapper.selectOne(username);
		if (member == null) {
			throw new UsernameNotFoundException(username);
		}
		return member;
	}

	@Override
	public AuthDto login(Member memberVO) throws Exception {
		Member member = memberMapper.selectOne(memberVO.getUsername());
		if (member == null) { // Is it an existing id?
			throw new UsernameNotFoundException(memberVO.getUsername());

		} 
		else if (!passwordEncoder.matches(memberVO.getPassword(), member.getPassword())) {
			throw new IllegalArgumentException("Password is Wrong");
		} 
		else {
			String token = jwtTokenProvider.createToken(member.getUsername(), member.getAuthorities());
			return AuthDto.builder()
					.token(token)
					.member(member).build();
		}
	}

	@Override
	public int join(Member memberVO) {
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		return memberMapper.join(memberVO);
	}
}
