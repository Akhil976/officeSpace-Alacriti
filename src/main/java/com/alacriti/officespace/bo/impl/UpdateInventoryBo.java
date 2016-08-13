package com.alacriti.officespace.bo.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alacriti.officespace.dao.impl.AnalyticsDao;
import com.alacriti.officespace.dao.impl.ItemDao;
import com.alacriti.officespace.dao.impl.UpdateInventoryDao;
import com.alacriti.officespace.delegate.UpdateInventoryDelegate;
import com.alacriti.officespace.vo.AddItemVo;
import com.alacriti.officespace.vo.CategoryVo;
import com.alacriti.officespace.vo.ItemsListVo;
import com.alacriti.officespace.vo.ResponseVo;
import com.alacriti.officespace.vo.UpdateAvailabilityVo;
import com.alacriti.officespace.vo.UpdateCapacityVo;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class UpdateInventoryBo {

	public static ResponseVo doUpdateAvailability(Connection connection, UpdateAvailabilityVo updateAvailability) {
		
		return UpdateInventoryDao.doUpdateAvailability(connection, updateAvailability);
		
	}
	public static ResponseVo doUpdateCapacity(Connection connection, UpdateCapacityVo updateCapacity) {
		
		return UpdateInventoryDao.doUpdateCapacity(connection, updateCapacity);

	}
	
	public static String doAddItem(Connection connection, AddItemVo addItem) {
		return UpdateInventoryDao.doAddItem(connection, addItem);
		
	}
	public static ResponseVo addCategory(Connection connection,	String newCategoryName) {
		return UpdateInventoryDao.addCategory(connection, newCategoryName);
	}
	public static ResponseVo deleteCategory(Connection connection, int categoryId) {
		System.out.println("delete bo");
		return UpdateInventoryDao.deleteCategory(connection, categoryId);
	}
	public static ItemsListVo ajaxItem(Connection connection, int categoryId) {
		System.out.println("delete bo");
		return UpdateInventoryDao.ajaxItem(connection, categoryId);
	}
	public static ResponseVo deleteItem(Connection connection, int itemId) {
		System.out.println("delete item bo");
		return UpdateInventoryDao.deleteItem(connection, itemId);
	}
	public static ArrayList<CategoryVo> ajaxCategory(Connection connection) {
		return ItemDao.getCategories(connection, 1);
	}

}
