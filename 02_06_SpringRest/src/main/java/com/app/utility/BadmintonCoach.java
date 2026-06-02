package com.app.utility;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class BadmintonCoach implements Coach {

	@Override
	public String getWorkOut() {

		return "playing with Racket ";
	}

	public BadmintonCoach() {
		System.out.println("In Badminton Constructor !!!!");
	}

}
