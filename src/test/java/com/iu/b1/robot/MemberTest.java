package com.iu.b1.robot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.b1.member.MemberMapper;
import com.iu.b1.member.MemberVO;
@SpringBootTest
class MemberTest {

	@Autowired
	private MemberMapper memberMapper;
	@Test
	void test() throws Exception{
		MemberVO member=new MemberVO();
		member.setId("iu");
		member.setPw("iu");
		member.setName("iu");
		member.setEmail("iu@iu");
		int result=memberMapper.memberJoin(member);
		assertEquals(1, result);
	}
	
	//@Test
	void test2()throws Exception{
		MemberVO member=new MemberVO();
		member.setId("iu");
		member.setPw("iu");
		member=memberMapper.memberLogin(member);
		System.out.println(member.getName());
		System.out.println(member.getEmail());
		assertNotNull(member);
	}

}
