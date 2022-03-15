package com.project.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.home.command.CounterVO;
import com.project.home.mapper.HomeMapper;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeMapper mapper;
	
	@Override
	public void register(CounterVO counterVO) {
		mapper.insertCounter(counterVO);

	}
	
	@Override
	public int getCounter() {
		int counter = mapper.getCounter();
		return counter;
	}
	
	@Override
	public void update() {
		mapper.update();
	}

}
