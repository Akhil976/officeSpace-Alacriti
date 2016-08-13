package com.alacriti.officespace.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.officespace.vo.AddItemVo;
import com.alacriti.officespace.vo.Item;
import com.alacriti.officespace.vo.ItemsListVo;
import com.alacriti.officespace.vo.ResponseVo;
import com.alacriti.officespace.vo.UpdateAvailabilityVo;
import com.alacriti.officespace.vo.UpdateCapacityVo;

public class UpdateInventoryDao {
	static final String DB_URL = "jdbc:mysql://192.168.35.70:3306/trainee_dev";
	static final String USER_NAME = "trainee_dev";
	static final String PASSWORD = "trainee_dev";
	
	public static ResponseVo doUpdateAvailability(Connection connection, UpdateAvailabilityVo updateAvailability) {
		System.out.println("update Dao");
		//inserting data
		int categoryId = updateAvailability.getCategoryId();
		int itemId = updateAvailability.getItemId();
		int updateAmount = updateAvailability.getUpdateAmount();
		String updateAction = updateAvailability.getUpdateAction();
		ResponseVo responseVo = new ResponseVo();
		Statement st = null;
		try {
			st = connection.createStatement();
			if(updateAction.equals("add")){
				st.executeUpdate("insert into officespace_items_purchase_tbl values("+itemId+","+categoryId+",now(),"+updateAmount+")");
			}
			else if(updateAction.equals("remove"))
			{
				System.out.println("insert into officespace_items_consume_tbl values("+itemId+","+categoryId+",now(),"+updateAmount+")");
				st.executeUpdate("insert into officespace_items_consume_tbl values("+itemId+","+categoryId+",now(),"+updateAmount+")");
			}
			responseVo.setSuccess(true);
		} catch (SQLException e) {
			e.printStackTrace();
			responseVo.setSuccess(false);
		}
		return responseVo;
	}

	public static ResponseVo doUpdateCapacity(Connection connection, UpdateCapacityVo updateCapacity) {
		int newCapacity = updateCapacity.getNewCapacity();
		int itemId = updateCapacity.getItemId();
		ResponseVo responseVo = new ResponseVo();
		Statement st = null;
		System.out.println("UPDATE officespace_items_tbl SET max_capacity="+newCapacity+" WHERE item_id="+itemId);
		try {
			st = connection.createStatement();
			st.executeUpdate("UPDATE officespace_items_tbl SET max_capacity="+newCapacity+" WHERE item_id="+itemId);
			responseVo.setSuccess(true);
		} catch (SQLException e) {
			e.printStackTrace();
			responseVo.setSuccess(false);
		}
		return responseVo;
	}

	public static String doAddItem(Connection connection, AddItemVo addItem) {
		System.out.println("update Dao");
		try(Connection conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);Statement st = conn.createStatement();) {
			//inserting data
			int categoryId = addItem.getCategoryId();
			String newItem = addItem.getNewItem();
			int maxCapacity = addItem.getMaxCapacity();
			
			System.out.println("insert into officespace_items_tbl(item_name,catg_id,max_capacity) values ("+"'"+newItem+"',"+categoryId+","+maxCapacity+")");
			
			st.executeUpdate("insert into officespace_items_tbl(item_name,catg_id,max_capacity) values ("+"'"+newItem+"',"+categoryId+","+maxCapacity+")");
			
			return "Successfully Updated";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Something wrong";
	}

	public static ResponseVo addCategory(Connection connection, String newCategoryName) {
		
		ResponseVo responseVo = new ResponseVo();
		Statement st = null;
		try {
			st = connection.createStatement();
			st.executeUpdate("insert into officespace_items_catg_tbl(catg_name) values ('"+newCategoryName+"')");
			responseVo.setSuccess(true);
		} catch (SQLException e) {
			e.printStackTrace();
			responseVo.setSuccess(false);
		}
		
		
		return responseVo;
	}

	public static ResponseVo deleteCategory(Connection connection, int categoryId) {
		System.out.println("delete dao");
		ResponseVo responseVo = new ResponseVo();
		Statement st = null;
		try {
			System.out.println("creating statement");
			st = connection.createStatement();
			System.out.println("executing query");
			st.executeUpdate("delete from officespace_items_catg_tbl where catg_id="+categoryId);
			responseVo.setSuccess(true);
		} catch (SQLException e) {
			e.printStackTrace();
			responseVo.setSuccess(false);
		}
		return responseVo;
	}

	public static ItemsListVo ajaxItem(Connection connection, int categoryId) {
		System.out.println("delete dao");
		ResponseVo responseVo = new ResponseVo();
		Statement st = null;
		ItemsListVo itemList = new ItemsListVo();
		try {
			System.out.println("creating statement");
			st = connection.createStatement();
			System.out.println("executing query");
			ResultSet rs = st.executeQuery("select item_id,item_name from officespace_items_tbl where catg_id = "+categoryId);
			while(rs.next()){
				itemList.setItemsList(new Item(rs.getInt("item_id"), rs.getString("item_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			responseVo.setSuccess(false);
		}
		return itemList;
	}

	public static ResponseVo deleteItem(Connection connection, int itemId) {
		System.out.println("delete item dao");
		ResponseVo responseVo = new ResponseVo();
		Statement st = null;
		try {
			System.out.println("creating statement");
			st = connection.createStatement();
			System.out.println("executing query");
			st.executeUpdate("delete from officespace_items_tbl where item_id="+itemId);
			responseVo.setSuccess(true);
		} catch (SQLException e) {
			e.printStackTrace();
			responseVo.setSuccess(false);
		}
		return responseVo;
	}
	
	
}
