package com.project.home.mapper;

import java.util.List;

import com.project.home.command.CounterVO;

public interface HomeMapper {

	  public void insertCounter(CounterVO counterVO);
	
	  public int getCounter();
	  
	  public void update();
	  
	  
}
