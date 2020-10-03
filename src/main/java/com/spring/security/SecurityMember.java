package com.spring.security;

import java.awt.GradientPaint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.spring.domain.Member;

import lombok.Data;

@Data
public class SecurityMember extends User {
	
	private static final String ROLE_PREFIX = "ROLE_";
	private Member member;

	public SecurityMember(Member member) {
		super(member.getUsername(), member.getPassword(), makeGrantedAuthority(member.getRolename()));
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(String role){
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(ROLE_PREFIX+role));
		return list;
	}
	
	

}
