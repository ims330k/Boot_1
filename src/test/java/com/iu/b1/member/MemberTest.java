package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
class MemberTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void test() throws Exception{
		MemberVO memberVO=new MemberVO();
		memberVO.setId("teest12");
		memberVO.setPw("teest12");
		memberVO.setEmail("teest66");
		memberVO.setName("teest12");
		int result=memberMapper.memberJoin(memberVO);
		assertEquals(1, result);
	}

	
	
}
