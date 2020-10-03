package com.spring.persistence;

import java.util.List;

import com.spring.domain.Member;

public interface MemberDao {
	
	Member selectOne(String username);

	void addMember(Member member);

	void addRole(Member member);

	List<Member> findAllMemberById(List<String> ids);

	void updateMember(Member member);
}
