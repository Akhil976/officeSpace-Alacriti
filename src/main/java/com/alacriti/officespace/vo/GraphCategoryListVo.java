package com.alacriti.officespace.vo;

import java.util.ArrayList;

public class GraphCategoryListVo {
	ArrayList<GraphCategoryVo> graphCategoryList = new ArrayList<GraphCategoryVo>();

	public ArrayList<GraphCategoryVo> getGraphCategoryList() {
		return graphCategoryList;
	}

	public void setGraphCategoryList(GraphCategoryVo graphCategoryVO) {
		graphCategoryList.add(graphCategoryVO);
	}
	
}
