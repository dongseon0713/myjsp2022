package com.zerock.command;

public class Criteria {
	
	//	mysql, mariadb : select * from board num desc limit ?(시작값),?(마지막값)
	//	oracle : select * from (select rownum as rnum, num, writer from board where rownum <= ?(마지막값) order by num desc)
	//			 where ?(시작값) <= rnum;
	private int pageNum; //페이지 번호
	private int count; 	//몇개의 데이터를 게시판에 출력할지 결정
	
	public Criteria() {
		//최초 게시판에 진입할 때 기본값을 1번 페이지, 10개 데이터 세팅!! [count값을 기준으로 보여준다.]
		this.pageNum = 1;
		this.count = 10;
	}

	public Criteria(int pageNum, int count) {
		//전달 받은 매개변수를 이용한 페이지 값 출력
		super();
		this.pageNum = pageNum;
		this.count = count;
	}
	
	// mysql, mariadb limit x, count 구문의 x값을 구하는 메서드를 생성
	public int getPageStart() {
		//return ( pageNum - 1 ) * count; -> mysql,mariadb인 경우
		return (( pageNum - 1 ) * count) + 1 ;  //oracle인 경우
	}
	
	//게터 세터 설정
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {	//mysql,mariadb 같은 경우에는 count값이 변하지 않지만 oracle의 경우에는 다르다.
		return count;
	}

	public int getCount_oracle() {	// 위 쿼리에 따라서는 첫 번째 ?의 값이 증가하기 때문에...
		return (pageNum * count);
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
