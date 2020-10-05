package com.example.gwak.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.gwak.dto.RequestMember;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest // 
// @WebMvcTest(slicing Test에선 SecurityConfiguration 설정에선 토큰생성기가 참조가 안됨)
public class MemberControllerTest {
	@Autowired
	private MemberController memberController; // To create Response and Request

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
	}



	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void createMembmerTest() throws Exception {

		RequestMember member = new RequestMember("Gwakheewon4","1234","GodHeewon");

		mockMvc.perform(post("/api/join")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(member)))
		.andDo(print())
		.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void loginTest() throws Exception {
		RequestMember member = new RequestMember("Gwakheewon3","1234","GodHeewon");

		mockMvc.perform(post("/api/login")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(member)))
		.andDo(print())
		.andExpect(status().is2xxSuccessful());
	}
}
