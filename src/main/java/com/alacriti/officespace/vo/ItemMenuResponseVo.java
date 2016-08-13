package com.alacriti.officespace.vo;

import java.util.ArrayList;
import java.util.Collection;

public class ItemMenuResponseVo {
	
	private Collection<Category> menu ;
	private ArrayList<GraphCategoryVo> graphCategoryList = new ArrayList<GraphCategoryVo>();
	
	public ItemMenuResponseVo() {
		super();
	}

	public ItemMenuResponseVo(Collection<Category> menu,
			ArrayList<GraphCategoryVo> graphCategoryList) {
		super();
		this.menu = menu;
		this.graphCategoryList = graphCategoryList;
	}


	public Collection<Category> getMenu() {
		return menu;
	}

	public void setMenu(Collection<Category> menu) {
		this.menu = menu;
	}

	
	
	public ArrayList<GraphCategoryVo> getGraphCategoryList() {
		return graphCategoryList;
	}

	public void setGraphCategoryList(GraphCategoryVo graphCategoryVo) {
		graphCategoryList.add(graphCategoryVo);
	}

	@Override
	public String toString() {
		return "ItemMenuResponseVo [menu=" + menu + "]";
	}
	
	
	
}
		