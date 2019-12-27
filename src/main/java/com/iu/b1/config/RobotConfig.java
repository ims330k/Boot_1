package com.iu.b1.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iu.b1.robot.LeftArm;
import com.iu.b1.robot.rightArm;

@Configuration
public class RobotConfig {
	//객체 만들어주는 역할
	//xml의 역할
	@Bean("left")//이런식으로 이름 지정 가능 또는 
	@Qualifier("")//Qualifier로도 지정 가능
	public LeftArm getleArm()throws Exception{
		LeftArm leftArm=new LeftArm();
		return leftArm;	//결국 객체를 리턴
	}
	@Bean
	public rightArm getRightArm()throws Exception{
		return new rightArm();
	}
}
