package com.alacriti.officespace.delegate;

import java.sql.Connection;

import com.alacriti.officespace.bo.ItemsMenuBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.ItemMenuResponseVo;

public class ItemsMenuDelegate {

	public static ItemMenuResponseVo getMenu() {
		Connection connection = DbConnection.getConnection();
		return ItemsMenuBo.getMenu(connection);
	}

}
