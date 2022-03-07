package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zerock.command.JoinVO;
@Service("JoinService")
public class JoinServiceImpl implements JoinService {

	ArrayList<JoinVO> memberList = new ArrayList<>();
	
	@Override
	public void joinMember(JoinVO vo) {
		memberList.add(vo);

	}

	

}
