package com.alacriti.officespace.bo;

import java.sql.Connection;

import com.alacriti.officespace.dao.ItemsMenuDao;
import com.alacriti.officespace.vo.ItemMenuResponseVo;

public class ItemsMenuBo {

	public static ItemMenuResponseVo getMenu(Connection connection) {
		return ItemsMenuDao.getMenu(connection);
	}


}
