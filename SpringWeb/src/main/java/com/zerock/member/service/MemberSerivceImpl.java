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
		System.out.println("���̵� ���� : " + result);
		
		return result;
	}
	
	@Override
	public int join(MemberVO vo) {
		//mapper�� ����(MemberMapper) �� �Ŀ� DB�� ���̹�Ƽ���� ����ó��
		//ó���� ����� Ȯ�� ��ȯ������ �ѱ�.
		//���̹�Ƽ���� root-context.xml���� xml��ĵó���ؾ� ��.
		//xml���� ������ ���� ������ �����Ǿ�� �Ѵ�.
		int result = mapper.insert(vo);
		System.out.println("���� ����? " + result);
		
		if(result == 1) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public int login(MemberVO vo) {
		//1. mapper�� ����. ���� DB�� ���̹�Ƽ���� ����ó��
		//2. ó���� ����� ��ȯ������ �ѱ�
		//3. xml���� ������ ���� ������ �����Ǿ�� �Ѵ�.
		//4. select count(*) as result from member where id=#{id}
		int result = mapper.login(vo);
		System.out.println("���� ����? " + result );
		if(result == 1) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public int delete(String id) {
		int result = mapper.delete(id);
		
		System.out.println("���� ����? : " + result );
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
		
		System.out.println("���� ����? : " + result );
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
