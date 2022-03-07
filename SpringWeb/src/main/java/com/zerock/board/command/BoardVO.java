package com.zerock.board.command;

import java.sql.Timestamp;

public class BoardVO {
	
	//VO��ü�� DB�÷��� 1:1 ��Ī�� �ǵ��� ����
	//VO��ü�� �ݵ�� DB�÷���� �����ϰ� ����� ���� �����ϴ�.
	//VO��ü�� ���к����� �����ϵ�, getter, setter�� �����ؾ��Ѵ�.
	//VO��ü�� ��� �ɹ������� �ʱ�ȭ�ϴ� ������, �⺻ ������ 2���� �����մϴ�.
	
	private int num;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private Timestamp updatedate;
	
	public BoardVO() {}

	public BoardVO(int num, String title, String content, String writer, Timestamp regdate, Timestamp updatedate) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	
	
}
