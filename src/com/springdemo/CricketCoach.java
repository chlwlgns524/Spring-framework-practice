package com.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	
	public CricketCoach() {
		System.out.println("No-arg constructor called right now!");
	}
	
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Setter method called right now!");
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return "From cricket coach: " + fortuneService.getFortune();
	}

}
