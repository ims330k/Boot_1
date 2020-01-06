package com.iu.b1.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomSchedule {

	//@Scheduled(fixedRate = 1000)
	//@Scheduled(fixedRateString = "1000")
	public void fixRateSchedule()throws Exception{
		System.out.println("fixRate  "+Thread.currentThread().getName());
	}
	
	//@Scheduled(fixedDelay = 3000)
	public void fixedDelaySchedule()throws Exception{
		System.out.println("fix Delay  "+Thread.currentThread().getName());
	}
	
	//@Scheduled(cron = "*/3 * * * * *")
	public void cronSchedule()throws Exception{
		System.out.println("쉬는시간 지킵시다....  "+Thread.currentThread().getName());
	}
	
}
