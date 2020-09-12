package com.spring.vo;

import lombok.Data;

@Data
public class PageVO {
	
	// 페이지당 게시글, 페이지 범위
	private static final int PAGE_SIZE = 5;
	private static final int PAGE_RANGE = 5;
	
	// 현재 페이지 번호
	private int currentPage = 1;
	private int currentPageIdx;
	
	// 현재 페이지 범위에서 첫번째 페이지, 마지막 페이지
	private int startPage;
	private int endPage;

	// 현재 페이지의 첫번째 게시글, 마지막 게시글 인덱스
	private int startItem;
	private int endItem;
	
	// 전체 게시글 수
	private int rowCount;
	
	// 총 페이지 수
	private int pageCount;
	
	// 검색 키워드, 옵션
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
