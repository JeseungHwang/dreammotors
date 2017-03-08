package com.dreammotors.vo;

public class PagingVO {
    private int firstPageNo; // 첫 번째 페이지 번호
    private int startPageNo; // 시작 페이지 (페이징 네비 기준)
    private int pageNo; // 페이지 번호
    private int endPageNo; // 끝 페이지 (페이징 네비 기준)
    private int finalPageNo; // 마지막 페이지 번호
    private int totalCount; // 게시 글 전체 수
    private int prevPageNo; // 이전 페이지 번호
    private int nextPageNo; // 다음 페이지 번호
    
    public PagingVO() {
    	pageNo = 1;
    	nextPageNo = 1;
    	prevPageNo = 0;
	}
	public int getFirstPageNo() {
		return firstPageNo;
	}
	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}
	public int getStartPageNo() {
		return startPageNo;
	}
	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getEndPageNo() {
		return endPageNo;
	}
	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}
	public int getFinalPageNo() {
		return finalPageNo;
	}
	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPrevPageNo() {
		return prevPageNo;
	}
	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}
	public int getNextPageNo() {
		return nextPageNo;
	}
	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}
	@Override
	public String toString() {
		return "PagingVO [ firstPageNo=" + firstPageNo + ", endPageNo=" + endPageNo + ", startPageNo=" + startPageNo + ", finalPageNo=" + finalPageNo +
			   ", pageNo=" + pageNo + ", totalCount=" + totalCount + ", prevPageNo=" + prevPageNo + ", nextPageNo=" + nextPageNo + "]";
	}
	
}
