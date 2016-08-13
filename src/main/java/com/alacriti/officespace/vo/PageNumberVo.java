package com.alacriti.officespace.vo;

public class PageNumberVo {
	
	private int uniqueId;
	private int offset;
	private int pageNumber;
	private int totalPages;
	private int limit;
	
	public PageNumberVo() {
		super();
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public PageNumberVo(int uniqueId, int offset, int pageNumber,
			int totalPages, int limit) {
		super();
		this.uniqueId = uniqueId;
		this.offset = offset;
		this.pageNumber = pageNumber;
		this.totalPages = totalPages;
		this.limit = limit;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "PageNumberVo [uniqueId=" + uniqueId + ", offset=" + offset
				+ ", pageNumber=" + pageNumber + "]";
	}

}
