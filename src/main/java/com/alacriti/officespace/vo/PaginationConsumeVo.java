package com.alacriti.officespace.vo;

import java.util.ArrayList;

public class PaginationConsumeVo {

	private ArrayList<ItemConsumeVo> itemConsumeList = new ArrayList<ItemConsumeVo>();
	private int uniqueId;
	private int offset;
	private int limit;
	private int pageNo;
	private int totalPages;

	public PaginationConsumeVo() {
		super();
	}

	public PaginationConsumeVo(ArrayList<ItemConsumeVo> itemConsumeList, int uniqueId,
			int offset, int limit, int pageNo, int totalPages) {
		super();
		this.itemConsumeList = itemConsumeList;
		this.uniqueId = uniqueId;
		this.offset = offset;
		this.limit = limit;
		this.pageNo = pageNo;
		this.totalPages = totalPages;
	}

	public ArrayList<ItemConsumeVo> getItemConsumeList() {
		return itemConsumeList;
	}

	public void setItemConsumeVo(ItemConsumeVo itemConsumeVo) {
		itemConsumeList.add(itemConsumeVo);
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

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "PaginationConsumeVo [itemConsumeVo=" + itemConsumeList
				+ ", uniqueId=" + uniqueId + ", offset=" + offset + ", limit="
				+ limit + ", pageNo=" + pageNo + ", totalPages=" + totalPages
				+ "]";
	}

}
