package com.zerock.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.member.command.MemberVO;
import com.zerock.member.mapper.MemberMapper;

@Service("memberService")
public class MemberSerivceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int checkId(String id) {
		
		int result = mapper.checkId(id);
		System.out.println("아이디 개수 : " + result);
		
		return result;
	}
	
	@Override
	public int join(MemberVO vo) {
		//mapper를 생성(MemberMapper) 한 후에 DB와 마이바티스로 연동처리
		//처리된 결과를 확인 반환값으로 넘김.
		//마이바티스는 root-context.xml에서 xml스캔처리해야 함.
		//xml에는 쿼리에 대한 내용이 정리되어야 한다.
		int result = mapper.insert(vo);
		System.out.println("성공 실패? " + result);
		
		if(result == 1) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public int login(MemberVO vo) {
		//1. mapper를 생성. 이후 DB와 마이바티스로 연동처리
		//2. 처리된 결과를 반환값으로 넘김
		//3. xml에서 쿼리에 대한 내용이 정리되어야 한다.
		//4. select count(*) as result from member where id=#{id}
		int result = mapper.login(vo);
		System.out.println("성공 실패? " + result );
		if(result == 1) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public int delete(String id) {
		int result = mapper.delete(id);
		
		System.out.println("성공 실패? : " + result );
		if(result == 1) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public MemberVO getInfo(String id) {
		MemberVO vo = mapper.getInfo(id);
		return vo;
	}
	
	@Override
	public int update(MemberVO vo) {
		int result = mapper.update(vo);
		
		System.out.println("성공 실패? : " + result );
		if(result == 1) {
			return 1;
		}
		
		return 0;
	}
	
	@Override
	public int updatePw(String id, String pw) {
		
		System.out.println("--------------");
		System.out.println(pw);
		System.out.println(id);
		int result = mapper.updatePw(pw, id);
		return result;
	}
}
