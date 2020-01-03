package com.iu.b1.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
//<mapper namespace="com.iu.b1.member.MemberMapper"> 풀패키지명과 동일\
	
	public int memberJoin(MemberVO memberVO)throws Exception;
	public MemberVO memberLogin(MemberVO memberVO)throws Exception;
}
