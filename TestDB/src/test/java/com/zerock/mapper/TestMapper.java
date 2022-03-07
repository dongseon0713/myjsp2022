package com.zerock.mapper;

import java.util.ArrayList;

import com.zerock.vo.ScoreVO;

public interface TestMapper {
	
	public ArrayList<ScoreVO> select();
	public boolean insert(ScoreVO vo);
	public boolean update(String num);
	public boolean delete(String num);
}
