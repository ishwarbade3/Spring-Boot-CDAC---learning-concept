package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.utility.FootBallCoach;

@Configuration
public class AppConfig {
	 @Bean
	    public FootBallCoach footBallCoach() {
	        return new FootBallCoach();
	    }

	
}
