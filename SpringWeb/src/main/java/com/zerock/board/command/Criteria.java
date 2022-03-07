package com.zerock.board.command;

public class Criteria {
	
	//	mysql, mariadb : select * from board num desc limit ?(���۰�),?(��������)
	//	oracle : select * from (select rownum as rnum, num, writer from board where rownum <= ?(��������) order by num desc)
	//			 where ?(���۰�) <= rnum;
	private int pageNum; //������ ��ȣ
	private int count; 	//��� �����͸� �Խ��ǿ� ������� ����
	
	public Criteria() {
		//���� �Խ��ǿ� ������ �� �⺻���� 1�� ������, 10�� ������ ����!! [count���� �������� �����ش�.]
		this.pageNum = 1;
		this.count = 10;
	}

	public Criteria(int pageNum, int count) {
		//���� ���� �Ű������� �̿��� ������ �� ���
		super();
		this.pageNum = pageNum;
		this.count = count;
	}
	
	// mysql, mariadb limit x, count ������ x���� ���ϴ� �޼��带 ����
	public int getPageStart() {
		//return ( pageNum - 1 ) * count; -> mysql,mariadb�� ���
		return (( pageNum - 1 ) * count) + 1 ;  //oracle�� ���
	}
	
	//���� ���� ����
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {	//mysql,mariadb ���� ��쿡�� count���� ������ ������ oracle�� ��쿡�� �ٸ���.
		return count;
	}

	public int getCount_oracle() {	// �� ������ ���󼭴� ù ��° ?�� ���� �����ϱ� ������...
		return (pageNum * count);
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
}