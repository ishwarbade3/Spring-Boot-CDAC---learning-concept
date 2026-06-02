package com.app.utility;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Primary
public class CricketCoach implements Coach {

	@Override
	public String getWorkOut() {
		// TODO Auto-generated method stub
		return "Balling In Space Manner";
	}

	public CricketCoach() {
		System.out.println("In Cricket Coachn Constructor");
		
	}
	@PostConstruct
	public void init() {
		System.out.println("IN Init of Cricket Coach !!!");
		
	}
	@PreDestroy
	public void destroy() {
		System.out.println("IN Destroy of Cricket Coach !!!");
		
	}
	
	

}
