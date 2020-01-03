package com.iu.b1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

//@Configuration
public class ScheduleConfig implements SchedulingConfigurer{

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub
	
		ThreadPoolTaskScheduler taskScheduler=new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(8);//8개쓰레드
		taskScheduler.setThreadNamePrefix("myThread : ");
		taskScheduler.initialize();//초기화
		taskRegistrar.setTaskScheduler(taskScheduler);
		
	}
}
