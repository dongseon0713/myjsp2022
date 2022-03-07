package com.zerock.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zerock.command.ScoreVO;
//@Component	//잘됨
//@Component("scoreService")
//@Repository
import com.zerock.dao.ScoreDAO;
import com.zerock.dao.ScoreDAOImpl;
import com.zerock.mapper.ScoreMapper;

//@Service
@Service("scoreService") //해당 클래스를 컨테이너 빈으로 생성하겠다는 어노테이션
public class ScoreServiceImpl implements ScoreService {

//	//ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
//	
//	@Override
//	public void scoreRegist(ScoreVO dao) {
//		System.out.println("--------- 서비스 계층 ---------");
//		System.out.println(dao.getName());
//		System.out.println(dao.getKor());
//		System.out.println(dao.getEng());
//		System.out.println(dao.getMath());
//		
//		list.add(dao);
//		
//		System.out.println(list.toString());
//	}
//
//	@Override
//	public ArrayList<ScoreVO> scoreResult() {
//		
//		return list;
//	}
//
//	@Override
//	public void scoreDelete(String number) {
//		
//		int num = Integer.parseInt(number);
//		list.remove(num);
//	}
	//----------------DAO들어가기----------------
	
//	//1번 style
//	ScoreDAO scoreDAO = new ScoreDAOImpl();
	
	//2번 style : DispatcherServlet을 이용 - Servlet-Context.xml설정에 bean 등록
	
	//3번 style : 자동 의존성 주입을 어노테이션을 이용하여...
	@Autowired
	private ScoreMapper mapper;

	@Override
	public void scoreRegist(ScoreVO vo) {
		
		//boolean result = mapper.insert(vo);
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", vo.getName());
		map.put("kor", vo.getKor());
		map.put("eng", vo.getEng());
		map.put("math", vo.getMath());
		
		boolean result2 = mapper.insert(map);
		
		//System.out.println("결과 : " + result);
		System.out.println("결과 : " + result2);
	}
	
	@Override
	public ArrayList<ScoreVO> scoreResult() {
		
		ArrayList<ScoreVO> DB = mapper.select();
		
		return DB;
	}
	
	@Override
	public void scoreDelete(String num) {
		
		mapper.delete(num);
		
	}
}
