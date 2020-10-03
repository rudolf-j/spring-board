package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.Member;

@Mapper
public interface MemberMapper {
	Member selectById(String username);

	void addMember(Member member);

	void addRole(Member member);

	List<Member> findAllMemberById(List<String> ids);

	void update(Member member);
}
