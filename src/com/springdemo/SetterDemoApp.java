package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach cricketCoach = context.getBean("myCricketCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(cricketCoach.getDailyWorkout());		
		System.out.println(cricketCoach.getDailyFortune());
		
		// close the context
		context.close();

	}

}
