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
	
	@Override
	public MemberVO findId(String name, String phone, int phone1, int phone2, String question, String answer) {
		
		MemberVO vo = mapper.findId(name,phone,phone1,phone2,question,answer);
		System.out.println("아이디 : " + vo.getId());
		return vo;
	}
	
	@Override
	public int findPw(String id, String email, String emailAd) {
		int result = mapper.findPw(id, email, emailAd);
		
		return result;
	}
	
	@Override
	public int findIdCheck(String name, String phone, int phone1, int phone2, String question, String answer) {
		int result = mapper.findIdCheck(name, phone, phone1, phone2, question, answer);
				
		return result;
	}
	
	@Override
	public int updatePw(String id,String pw) {
		int result = mapper.updatePw(id,pw);
		return result;
	}
	
	@Override
	public MemberVO getInfo(String id) {
		MemberVO vo = mapper.getInfo(id);
		return vo;
	}
	
	@Override
	public int pwCheck(String id, String pw) {
		int result = mapper.pwCheck(id,pw);
		return result;
	}
	
	@Override
	public int update(MemberVO vo) {
		int result = mapper.update(vo);
		return result;
	}
	
	@Override
	public int unregister(String reason, String cause) {
		int result = mapper.unregister(reason, cause);
		return result;
	}
	@Override
	public void delete(String id) {
		mapper.delete(id);
	}
}
