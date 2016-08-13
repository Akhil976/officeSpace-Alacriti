package com.alacriti.officespace.resource;

import com.alacriti.officespace.delegate.ItemsMenuDelegate;
import com.alacriti.officespace.util.GenerateFtlResponse;
import com.alacriti.officespace.vo.ItemMenuResponseVo;

public class ItemsMenuResource {
	
	public String getMenu(){
		
		ItemMenuResponseVo itemsMenuResponseVo =  ItemsMenuDelegate.getMenu();
		
		return GenerateFtlResponse.getMenuCode(itemsMenuResponseVo); 
		
	}
	
}
