package com.spring.board;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.domain.Member;
import com.spring.persistence.MemberDao;
import com.spring.service.MemberService;

import lombok.extern.java.Log;

@Log
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:dbconfig/mybatis-context.xml")
public class MemberTest {
	
	@Autowired
	MemberDao dao;
	
	@Autowired
	MemberService service;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Test
	void selectMemberTest() {
		log.info("member......."+dao.selectOne("user0"));
	}
	
	@Test
	void registerMember() {
		
		for(int i = 0; i < 10; i++) {
			Member member = new Member();
			member.setUsername("user"+i);
			member.setPassword("pwd"+i);
			
			if(i > 2) 
				member.setRolename("BASIC");
			else if(i > 0) 
				member.setRolename("MANAGER");
			else 
				member.setRolename("ADMIN");
			
			service.registerMember(member);			
		}
		
	}
	
	@Test
	void encoding() {
		List<String> ids = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			ids.add("user"+i);
		}
		List<Member> members = dao.findAllMemberById(ids);
		members.forEach(member -> {
			member.setPassword(encoder.encode(member.getPassword()));
			dao.updateMember(member);
		});
	}
	
	@Test
	void t1() {
		List<String> ids = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			ids.add("user"+i);
		}
		String id = ids.toString();
		
		log.info("ids............"+id.substring(1, id.length()-1));
	}
}
