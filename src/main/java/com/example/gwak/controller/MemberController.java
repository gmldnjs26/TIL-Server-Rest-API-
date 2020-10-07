package com.example.gwak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gwak.dto.AuthDto;
import com.example.gwak.dto.Member;
import com.example.gwak.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/api/join")
	public ResponseEntity join(@RequestBody Member member) {
		try {
			memberService.join(member);
			return ResponseEntity.ok(member);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
		
	}
	
	@PostMapping("/api/login")
	public ResponseEntity<AuthDto> login(@RequestBody Member member) throws Exception {
		return ResponseEntity.ok(memberService.login(member));
	}
	
}
