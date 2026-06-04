package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/system")
	public String showSystem() {
		return "system";
	}
	@GetMapping("/leader")
	public String showLeader() {
		return "leader";
	}
	
	@GetMapping("/acess-denied")
	public String showAcessDenied() {
		return "acess-denied";
	}
}
