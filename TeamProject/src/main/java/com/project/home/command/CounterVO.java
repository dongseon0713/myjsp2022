package com.project.home.command;

public class CounterVO {

	private int num;
	private String sessionid;



public CounterVO() {
	
}



public CounterVO(int num, String sessionid) {
	super();
	this.num = num;
	this.sessionid = sessionid;
}



public int getNum() {
	return num;
}



public void setNum(int num) {
	this.num = num;
}



public String getSessionid() {
	return sessionid;
}



public void setSessionid(String sessionid) {
	this.sessionid = sessionid;
}





}
