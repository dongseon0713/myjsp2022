package com.project.home.service;

import java.util.List;

import com.project.home.command.CounterVO;

public interface HomeService {

	public void register(CounterVO CounterVO);
	
	public int getCounter();
	
	public void update();
	
}
