package com.zerock.board.command;


public class PageVO {
	//Critaria�� �������� ���踦 ������.
	//ȭ�鿡 �׷��� ��ư���� ������ ����ϴ� Ŭ����
	private int startPage;	//���� ��ȣ
	private int endPage;	//�� ��ȣ
	private int total;		//��ü �Խñ� ��
	
	private int pageNum;	//���� ��ȸ�ϴ� ������
	
	private boolean next;	//���� ��ư Ȱ��ȭ ����
	private boolean prev;	//���� ��ư Ȱ��ȭ ����
	
	private Criteria cri;	//������ ����
	
	
	// �����ڸ� �⺻ �����ڷ� �������� ���ϰ�, 
	// total�� Criteria�� �޾Ƽ� ��� ó���ϵ��� ����
	
	public PageVO(int total, Criteria cri) {
		//���޵Ǵ� �Ű��������� �ʱⰪ�� ����
		this.total = total;
		this.cri = cri;
		this.pageNum = cri.getPageNum();
		
		//�������� ���
		//��ȸ�ϴ� ������ ��ȣ�� 1 ~ 10 => 10
		//��ȸ�ϴ� ������ ��ȣ�� 11 ~ 20 => 20
		//Math.ceil() �ø�
		//���� = (int)Math.ceil(��ȸ�ϴ� ������ ��ȣ / (double)10) * 10;
		this.endPage = (int)Math.ceil(cri.getPageNum() / (double)10 ) * 10;
		
		//���������� ��� = �������� ��ȣ +(-�ѹ��� ������ ������ ��ȣ + 1)
		this.startPage = endPage - 9;	// �ѹ��� ������ ������ ��ȣ -> �ϴ� ������ ��ȣ
		
		//������ ��ȣ�� ���� �� ��Ÿ���� ��¥ ����ȣ
		//total�� ��ü �Խù�... ex)��ü �Խù��� 117��  117 / 10 => 11.7 => 12
		int realEnd = (int)Math.ceil(this.total / (double)10);
		
		//������ ������ ���ÿ��� ������� �� ��ȣ
		if(this.endPage > realEnd ) {
			this.endPage = realEnd;
		}
		
		//���� ������ ��ư Ȱ��ȭ ����
		//startPage => 1, 11, 21, 31, 41, ...
		//startPage�� 1���� ũ�� true
		this.prev = startPage > 1;
		
		//���������� ��ư Ȱ��ȭ ����
		this.next = realEnd > this.endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
}