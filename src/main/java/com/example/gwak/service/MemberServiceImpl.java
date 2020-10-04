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
public class MemberServiceImpl implements MemberService,UserDetailsService{
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	
	/* JWT Token 매번 인증시 사용하는 친구 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 로거 
		Member member = memberMapper.selectOne(username);
		if(member == null) {
			throw new UsernameNotFoundException(username);
		}
		return member;
	}
	
	@Override
	public AuthDto login(Member memberVO) throws Exception {
		Member member = memberMapper.selectOne(memberVO.getUsername());
		if(member == null) {
			throw new UsernameNotFoundException(memberVO.getUsername());
		} else {
			if(member.getPassword().equals(passwordEncoder.encode(memberVO.getPassword()))) {
				String token = jwtTokenProvider.createToken(member.getUsername(), member.getAuthorities());
				return AuthDto.builder()
						.token(token)
						.member(member)
						.build();
			} else {
				throw new Exception("Password is Wrong");
			}
		}
	}

	@Override
	public int join(Member memberVO) {
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		return memberMapper.join(memberVO);
	}
}
