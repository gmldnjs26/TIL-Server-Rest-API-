package com.example.gwak;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.gwak.dto.Member;
import com.example.gwak.service.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTilApplicationTests {
	@Autowired
	private MemberService memberService;
	@Test
	public void contextLoads() {
		Member memberVO = new Member("id2","password","nickname");
		memberService.join(memberVO);
		Member member = memberService.selectOne("id");
		assertNotNull(member);
	}

}
