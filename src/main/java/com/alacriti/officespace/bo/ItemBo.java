package com.alacriti.officespace.bo;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alacriti.officespace.dao.ItemDao;
import com.alacriti.officespace.vo.AnalyticsTotal;
import com.alacriti.officespace.vo.Category;
import com.alacriti.officespace.vo.CategoryVo;
import com.alacriti.officespace.vo.ItemDetailsAdmin;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class ItemBo {

	public static ItemDetailsAdmin getItemDetails(Connection connection, int itemId)
			throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException, SQLException {

			int availableItems = ItemDao.getAvailableItems(connection, itemId);
			int inventoryCapacity = ItemDao.getCapacity(connection, itemId);
			int fillPercentage = (availableItems * 100) / inventoryCapacity;
			AnalyticsTotal analytics = ItemDao.getAnalytics(connection, itemId);
			ArrayList<CategoryVo> categoryList= ItemDao.getCategories(connection,itemId);
			
			ItemDetailsAdmin itemDetailsAdmin = new ItemDetailsAdmin();
			
			itemDetailsAdmin.setAvailableItems(availableItems);
			itemDetailsAdmin.setInventoryCapacity(inventoryCapacity);
			itemDetailsAdmin.setFillPercentage(fillPercentage);
			itemDetailsAdmin.setAlalyticsDay(analytics.getAnalyticsDay());
			itemDetailsAdmin.setAlalyticsWeek(analytics.getAnalyticsWeek());
			itemDetailsAdmin.setAlalyticsMonth(analytics.getAnalyticsMonth());
			itemDetailsAdmin.setAlalyticsYear(analytics.getAnalyticsYear());
			itemDetailsAdmin.setCategoryList(categoryList);
			
			
			return itemDetailsAdmin;
			

		}
}
