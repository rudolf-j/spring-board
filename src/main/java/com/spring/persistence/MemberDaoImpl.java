package com.spring.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Member;
import com.spring.mapper.MemberMapper;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	MemberMapper mapper;
	
	@Override
	public Member selectOne(String username) {
		return mapper.selectById(username); 
	}
	
	@Override
	public void addMember(Member member) {
		mapper.addMember(member);
	}
	@Override
	public void addRole(Member member) {
		mapper.addRole(member);
	}

	@Override
	public List<Member> findAllMemberById(List<String> ids) {
		return mapper.findAllMemberById(ids);
	}

	@Override
	public void updateMember(Member member) {
		mapper.update(member);
	}

}
