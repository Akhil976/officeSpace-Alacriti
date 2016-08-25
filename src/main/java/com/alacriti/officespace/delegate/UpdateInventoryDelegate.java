package com.alacriti.officespace.delegate;

import java.sql.Connection;
import java.util.ArrayList;

import com.alacriti.officespace.bo.UpdateInventoryBo;
import com.alacriti.officespace.dao.UpdateInventoryDao;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.AddItemVo;
import com.alacriti.officespace.vo.CategoryVo;
import com.alacriti.officespace.vo.ItemsListVo;
import com.alacriti.officespace.vo.ResponseVo;
import com.alacriti.officespace.vo.UpdateAvailabilityVo;
import com.alacriti.officespace.vo.UpdateCapacityVo;

public class UpdateInventoryDelegate {
	static Connection connection = DbConnection.getConnection();
	public static ResponseVo doUpdateAvailability(UpdateAvailabilityVo updateAvailability){
		return UpdateInventoryBo.doUpdateAvailability(connection,updateAvailability);
	}

	public static ResponseVo doUpdateCapacity(UpdateCapacityVo updateCapacity) {
		return UpdateInventoryBo.doUpdateCapacity(connection,updateCapacity);
	}

	public static String doAddItem(AddItemVo addItem) {
		return UpdateInventoryBo.doAddItem(connection, addItem);
	}

	public static ResponseVo addCategory(String newCategoryName) {
		return UpdateInventoryBo.addCategory(connection, newCategoryName);
	}

	public static ResponseVo deleteCategory(int categoryId) {
		System.out.println("delete delegate");
		return UpdateInventoryBo.deleteCategory(connection, categoryId);
	}

	public static ItemsListVo ajaxItem(int categoryId) {
		System.out.println("ajax delegate");
		return UpdateInventoryBo.ajaxItem(connection, categoryId);
		
	}

	public static ResponseVo deleteItem(int itemId) {
		System.out.println("delete item delegate");
		return UpdateInventoryBo.deleteItem(connection, itemId);
	}

	public static ArrayList<CategoryVo> ajaxCategory() {
		return UpdateInventoryBo.ajaxCategory(connection);
	}
}
