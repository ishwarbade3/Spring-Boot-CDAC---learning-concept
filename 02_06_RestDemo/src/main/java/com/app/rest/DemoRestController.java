package com.app.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	@GetMapping("/dateTime")
	public String getDateTime() {
		return LocalDateTime.now().toString();
	}
	@GetMapping("/hello/{id}")
	public String getID(@PathVariable int id) {
		return " id : "+id;
	}

}
