package com.example.gwak.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.gwak.dto.Member;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MemberServiceImplTest {
	@Autowired
	MemberServiceImpl memberServiceImpl;
	
	@Test
	public void test() {
		Member memberVO = new Member("id3","password","nickname");
		memberServiceImpl.join(memberVO);
		Member member = memberServiceImpl.selectOne("id3");
		assertNotNull(member);
	}

}
