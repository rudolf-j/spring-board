package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/manager")
	public void manager() {
		
	}
	
	@RequestMapping("/basic")
	public void basic() {
		
	}

}
