package com.zerock.testmapper;

import java.util.ArrayList;
import java.util.Map;

import com.zerock.command.ScoreVO;

public interface TestMapper {
	
	public String getTime();	//서버시간 알아오기
	public ArrayList<ScoreVO> select();
	public boolean insert(ScoreVO vo); //인자값에 hashmap을 사용해도된다.
	public boolean insert2(Map<String, String> map);
}
