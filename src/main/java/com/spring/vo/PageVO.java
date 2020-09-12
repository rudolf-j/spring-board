package com.spring.vo;

import lombok.Data;

@Data
public class PageVO {
	
	// �������� �Խñ�, ������ ����
	private static final int PAGE_SIZE = 5;
	private static final int PAGE_RANGE = 5;
	
	// ���� ������ ��ȣ
	private int currentPage = 1;
	private int currentPageIdx;
	
	// ���� ������ �������� ù��° ������, ������ ������
	private int startPage;
	private int endPage;

	// ���� �������� ù��° �Խñ�, ������ �Խñ� �ε���
	private int startItem;
	private int endItem;
	
	// ��ü �Խñ� ��
	private int rowCount;
	
	// �� ������ ��
	private int pageCount;
	
	// �˻� Ű����, �ɼ�
	private String option = "";
	private String keyword = "";
	
	public PageVO() { }
	
	public PageVO(int currentPage, int rowCount) {
		this.currentPage = currentPage;
		this.rowCount = rowCount;
		calcPage();
	}
	
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		calcPage();
	}
	
	public void calcPage() {
		
		currentPageIdx = currentPage-1;
		
		pageCount = (int)Math.ceil(rowCount/PAGE_SIZE);
		
		startPage = ((currentPageIdx/PAGE_RANGE)*PAGE_RANGE)+1;
		
		int endPageTemp = (startPage+(PAGE_RANGE-1));
		endPage = endPageTemp > pageCount ? pageCount : endPageTemp;
		
		startItem = currentPageIdx * PAGE_SIZE;
		
		endItem = currentPageIdx == pageCount ? rowCount - 1 : startItem + (PAGE_SIZE-1);
	}

}
