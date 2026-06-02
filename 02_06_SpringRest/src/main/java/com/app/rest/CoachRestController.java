package com.app.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.app.utility.Coach;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CoachRestController {

	private Coach theCoach;

	public CoachRestController(@Qualifier("footBallCoach") Coach theCoach) {
		this.theCoach = theCoach;
	}

	@GetMapping("/workout")
	public String workout() {
		return theCoach.getWorkOut();
	}

}
