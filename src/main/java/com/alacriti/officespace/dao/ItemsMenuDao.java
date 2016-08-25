package com.alacriti.officespace.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alacriti.officespace.vo.Category;
import com.alacriti.officespace.vo.GraphCategoryVo;
import com.alacriti.officespace.vo.Item;
import com.alacriti.officespace.vo.ItemMenuResponseVo;


public class ItemsMenuDao {

	public static  ItemMenuResponseVo getMenu(Connection connection) {

		Statement st = null;
		ResultSet rs = null;
		ItemMenuResponseVo itemMenuResponseVo = new ItemMenuResponseVo();
		try {
			st = connection.createStatement();
			int categoryId,itemId;
			String categoryName,itemName;
			Map<Integer,Category> categoryObjectsMap = new HashMap<Integer,Category>();

			rs = st.executeQuery("select a.catg_id, a.catg_name, b.item_id, b.item_name from officespace_items_catg_tbl a, officespace_items_tbl b where a.catg_id=b.catg_id;");

			while (rs.next()) {
				categoryId = rs.getInt("catg_id");
				itemId = rs.getInt("item_id");
				categoryName = rs.getString("catg_name");
				itemName = rs.getString("item_name");
				
				Item item = new Item(itemId,itemName );
				if(categoryObjectsMap.containsKey(categoryId)){
					categoryObjectsMap.get(categoryId).setItem(item);
				}
				else{
					ArrayList<Item> itemList = new ArrayList<Item>();
					itemList.add(item);
					Category category = new Category(categoryId,categoryName,itemList);
					categoryObjectsMap.put(categoryId, category);
				}
			}
			
			itemMenuResponseVo.setMenu(categoryObjectsMap.values());
			//Graph Values
			
			itemMenuResponseVo.setGraphCategoryList(new GraphCategoryVo("Stationary",1,100));
			itemMenuResponseVo.setGraphCategoryList(new GraphCategoryVo("Pantry",2,150));
			itemMenuResponseVo.setGraphCategoryList(new GraphCategoryVo("cleaning",3,70));
			itemMenuResponseVo.setGraphCategoryList(new GraphCategoryVo("system",3,100));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemMenuResponseVo;

	}
}
