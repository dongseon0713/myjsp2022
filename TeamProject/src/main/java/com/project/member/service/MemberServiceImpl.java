package com.project.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.member.command.MemberVO;
import com.project.member.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	
	@Override
	public int delete(String id) {
		mapper.delete();
		return 0;
	}
	@Override
	public int join(MemberVO vo) {
		System.out.println(vo.getPhone());
		int result = mapper.join(vo);
		
		if(result == 1) {
			return 1;
		}
		return 0;
	}
	@Override
	public int login(MemberVO vo) {
		int result = mapper.login(vo);
		System.out.println("성공 실패? " + result );
		if(result == 1) {
			return 1;
		}
		return 0;
	}
	@Override
	public void update(MemberVO vo) {
		mapper.update();
		
	}
	@Override
	public int checkId(String id) {
		
		int result = mapper.checkId(id);
		System.out.println("아이디 개수 : " + result);
		
		return result;
	}
	@Override
	public int checkNname(String nickname) {
		
		int result = mapper.checkNname(nickname);
		System.out.println("아이디 개수 : " + result);
		
		return result;
	}

}
