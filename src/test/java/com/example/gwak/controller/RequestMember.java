package com.example.gwak.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestMember {
	private String id;
	private String password;
	private String nickname;
}
