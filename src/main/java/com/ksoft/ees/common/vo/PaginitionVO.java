package com.ksoft.ees.common.vo;

public class PaginitionVO {

	private int totalCount;
	private int maxRecordsPerPage;
	private int startIndex;
	private int endIndex;
	
	private int currentPage;
	private String order;
	private String orderBy;
	
	public PaginitionVO(){}
	public PaginitionVO(int totalCount,int startIndex,int endIndex){
		this.totalCount=totalCount;
		this.startIndex=startIndex;
		this.endIndex=endIndex;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getMaxRecordsPerPage() {
		return maxRecordsPerPage;
	}
	public void setMaxRecordsPerPage(int maxRecordsPerPage) {
		this.maxRecordsPerPage = maxRecordsPerPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
}
