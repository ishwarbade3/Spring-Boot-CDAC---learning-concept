package com.app.utility;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {

	@Override
	public String getWorkOut() {
		return "running sprint football";
	}
	
	public FootBallCoach() {
		System.out.println("In football Coach Constructer ");
	}
	
	

}
