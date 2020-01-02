package com.iu.b1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAOP {
//@Aspect는 포인트컷하고 어드바이스 합쳐놓은거
	
	@Before("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public void before()throws Exception{
		System.out.println("***********************before member login");
	}
	
	@AfterReturning("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public void after()throws Exception{
		System.out.println("***********************after member login");
	}
	
	@AfterThrowing("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	public void throwing()throws Exception{
		System.out.println("***********************throwing");
	}
	
	@After("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	public void after1()throws Exception{
		//정상종료든 예외든 무조건 실행시킨다.
	}
	
	@Around("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public Object around(ProceedingJoinPoint joinpoint)throws Throwable{
		System.out.println("메서드 실행전");
		Object obj=joinpoint.proceed();
		System.out.println("메서드 실행후");
		return obj;
	}
}
