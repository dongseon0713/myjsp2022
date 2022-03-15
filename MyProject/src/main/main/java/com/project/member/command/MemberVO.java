package com.project.member.command;

import java.sql.Timestamp;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String nickname;
	private String gender;
	private String address;
	private String email;
	private String emailAd;
	private String phone;
	private int phone1;
	private int phone2;
	private String question;
	private String answer;
	private Timestamp regdate;
	public MemberVO() {
		
	}
	public MemberVO(String id, String pw, String name, String nickname, String gender, String address, String email,
			String emailAd, String phone, int phone1, int phone2, String question, String answer, Timestamp regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.emailAd = emailAd;
		this.phone = phone;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.question = question;
		this.answer = answer;
		this.regdate = regdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailAd() {
		return emailAd;
	}
	public void setEmailAd(String emailAd) {
		this.emailAd = emailAd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPhone1() {
		return phone1;
	}
	public void setPhone1(int phone1) {
		this.phone1 = phone1;
	}
	public int getPhone2() {
		return phone2;
	}
	public void setPhone2(int phone2) {
		this.phone2 = phone2;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
}
