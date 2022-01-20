package com.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	// add new fields for emailAddress and team
	private String team;
	private String emailAddress;

	
	// create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach();");
	}
	
	
	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("setFortuneService(FortuneService fortuneService);");
		this.fortuneService = fortuneService;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("setEmailAddress(String emailAddress);");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("setTeam(String team);");
		this.team = team;
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
