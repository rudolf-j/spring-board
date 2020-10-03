package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.domain.Member;
import com.spring.service.MemberService;

import lombok.extern.java.Log;

@Log
@Controller
public class MemberController {
	
	@Autowired
	PasswordEncoder pwEncoder;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/signUp")
	public String signUpForm() {
		return "signUp";
	}
	
	@PostMapping("/signUp")
	public String signUp(Member member) {
		log.info("member................"+member);
		log.info("encoded pw................."+pwEncoder.encode(member.getPassword()));
		String encodedPw = pwEncoder.encode(member.getPassword());
		member.setPassword(encodedPw);
		memberService.registerMember(member);
		return "redirect:/";
	}

}
