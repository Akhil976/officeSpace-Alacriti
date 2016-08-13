package com.alacriti.officespace.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alacriti.officespace.vo.AnalyticsTotal;
import com.alacriti.officespace.vo.CategoryVo;
import com.alacriti.officespace.vo.GraphMonthVo;
import com.alacriti.officespace.vo.GraphObjectsVo;
import com.alacriti.officespace.vo.GraphWeekVo;
import com.alacriti.officespace.vo.GraphYearVo;
import com.alacriti.officespace.vo.ItemDetailsAdmin;
import com.alacriti.officespace.vo.ItemMenuResponseVo;
import com.alacriti.officespace.vo.ItemsListVo;
import com.alacriti.officespace.vo.PageNumberVo;
import com.alacriti.officespace.vo.PaginationConsumeVo;
import com.alacriti.officespace.vo.SessionObject;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GenerateFtlResponse {

	public static String getLoginPage(String file){
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
		cfg.setClassForTemplateLoading(LoginUtil.class, "/");
		cfg.setNumberFormat("0.######");
		
		Template template;
		StringWriter writer = null;
		
		try {
			template = cfg.getTemplate(file);
            writer = new StringWriter();
            template.process(null,writer);
    		
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
		return writer.toString();
		
	}
	
	public static String getInventoryPage(HttpServletRequest request, ItemDetailsAdmin itemDetailsAdmin) {
		
		Map itemInfo = new HashMap();
		
		itemInfo.put("avilableItems", itemDetailsAdmin.getAvailableItems());
		itemInfo.put("inventoryCapacity", itemDetailsAdmin.getInventoryCapacity());
		itemInfo.put("fillPercentage", itemDetailsAdmin.getFillPercentage());
		itemInfo.put("alalyticsDay", itemDetailsAdmin.getAlalyticsDay());
		itemInfo.put("alalyticsWeek", itemDetailsAdmin.getAlalyticsWeek());
		itemInfo.put("alalyticsMonth", itemDetailsAdmin.getAlalyticsMonth());
		itemInfo.put("alalyticsYear", itemDetailsAdmin.getAlalyticsYear());
		itemInfo.put("categoryList",itemDetailsAdmin.getCategoryList());
		
		if(itemDetailsAdmin.getFillPercentage()>25){
			itemInfo.put("barColor", "green" );
		}
		else{
			itemInfo.put("barColor", "red" );
		}
		/* Get the template (uses cache internally) */
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
		cfg.setClassForTemplateLoading(LoginUtil.class, "/");
		cfg.setNumberFormat("0.######");
		
		Template template;
		StringWriter writer = new StringWriter();
		
    	SessionObject sessionObject = (SessionObject) request.getSession().getAttribute("sessionObject");
		System.out.println(sessionObject);
		System.out.println("generating ftl response");
		if(sessionObject.getUserRole().equals("admin")){
			try {
				template = cfg.getTemplate("adminInventory.ftl");
				template.process(itemInfo, writer);
			} catch (IOException | TemplateException e) {
				e.printStackTrace();
			}
    	}
    	if(sessionObject.getUserRole().equals("supervisor")){
			try {
				template = cfg.getTemplate("supervisorInventory.ftl");
				template.process(itemInfo, writer);
			} catch (IOException | TemplateException e) {
				e.printStackTrace();
			}
    	}
    	if(sessionObject.getUserRole().equals("employee")){
			try {
				template = cfg.getTemplate("employeeInventory.ftl");
				template.process(itemInfo, writer);
			} catch (IOException | TemplateException e) {
				e.printStackTrace();
			}
    	}
    	System.out.println(writer.toString());
		return writer.toString();
	}

	public static String getGraph(GraphObjectsVo graphObjectsVo) {
		System.out.println("Generating ftl code");
		if(graphObjectsVo.getGraphWeekVo()!=null){
			
			GraphWeekVo graphWeekVo = graphObjectsVo.getGraphWeekVo();
			
			Map<String,Integer> daysUsageInWeek = graphWeekVo.getGraphMonthVoMap();
			System.out.println(daysUsageInWeek);
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
			cfg.setClassForTemplateLoading(LoginUtil.class, "/");
			cfg.setNumberFormat("0.######");

			Template template;
			StringWriter writer = new StringWriter();
			try {
				System.out.println("before");
				template = cfg.getTemplate("graphWeek.ftl");
				System.out.println("after");
				template.process(daysUsageInWeek, writer);
				System.out.println("after afete");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
			
			return writer.toString();
			
			
		}
		else if(graphObjectsVo.getGraphMonthVo()!=null){
			
			GraphMonthVo graphMonthVo = graphObjectsVo.getGraphMonthVo();
			
			Map<String,Integer> daysUsageInWeek = graphMonthVo.getGraphMonthVoMap();
			System.out.println(daysUsageInWeek);
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
			cfg.setClassForTemplateLoading(LoginUtil.class, "/");
			cfg.setNumberFormat("0.######");

			Template template;
			StringWriter writer = new StringWriter();
			try {
				System.out.println("before");
				template = cfg.getTemplate("graphMonth.ftl");
				System.out.println("after");
				template.process(daysUsageInWeek, writer);
				System.out.println("after afete");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
			
			return writer.toString();
			
		}
		else if(graphObjectsVo.getGraphYearVo()!=null){
			GraphYearVo graphYearVo = graphObjectsVo.getGraphYearVo();
			
			Map<String,Integer> daysUsageInWeek = graphYearVo.getGraphYearVoMap();
			System.out.println(daysUsageInWeek);
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
			cfg.setClassForTemplateLoading(LoginUtil.class, "/");
			cfg.setNumberFormat("0.######");

			Template template;
			StringWriter writer = new StringWriter();
			try {
				System.out.println("before");
				template = cfg.getTemplate("graphYear.ftl");
				System.out.println("after");
				template.process(daysUsageInWeek, writer);
				System.out.println("after afete");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
			System.out.println(writer.toString());
			return writer.toString();
		}
		
		
		return null;
	}

	public static String getAnalyticsCode(HttpServletRequest request,
			AnalyticsTotal analyticsTotal) {
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
		cfg.setClassForTemplateLoading(GenerateFtlResponse.class, "/");
		cfg.setNumberFormat("0.######");
		Map<String, Integer> analyticsInfo = new HashMap<String, Integer>();

		analyticsInfo.put("alalyticsDay", analyticsTotal.getAnalyticsDay());
		analyticsInfo.put("alalyticsWeek", analyticsTotal.getAnalyticsWeek());
		analyticsInfo.put("alalyticsMonth", analyticsTotal.getAnalyticsMonth());
		analyticsInfo.put("alalyticsYear", analyticsTotal.getAnalyticsYear());
		
		Template template;
		StringWriter writer = new StringWriter();
		try {
			
			template = cfg.getTemplate("analytics.ftl");
			template.process(analyticsInfo, writer);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	public static String getMenuCode(ItemMenuResponseVo itemsMenuResponseVo) {

		Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
		cfg.setClassForTemplateLoading(GenerateFtlResponse.class, "/");
		cfg.setNumberFormat("0.######");
		
/*		Collection list = itemsMenuResponseVo.getMenu;
		Map dataModel = new HashMap();
		dataModel.put("Collection", list);
*/
		Map dataModel = new HashMap();
		dataModel.put("itemsMenuResponseVo", itemsMenuResponseVo);
		
		Template template;
		StringWriter writer = new StringWriter();
		try {
			
			template = cfg.getTemplate("dashBoard.ftl");
			template.process(dataModel, writer);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
		System.out.println(writer.toString());
		
		return writer.toString();
		
	}

	public static String getItems(ItemsListVo itemsListVo) {
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
		cfg.setClassForTemplateLoading(GenerateFtlResponse.class, "/");
		cfg.setNumberFormat("0.######");
		
		Map itemsMap = new HashMap();
		
		itemsMap.put("itemsList", itemsListVo);
		
		Template template;
		StringWriter writer = new StringWriter();
		try {
			
			template = cfg.getTemplate("items.ftl");
			template.process(itemsMap, writer);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
		System.out.println(writer.toString());
		
		return writer.toString();
		
	}

	public static String getPagiantion(PaginationConsumeVo paginationConsumeVo) {
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
		cfg.setClassForTemplateLoading(GenerateFtlResponse.class, "/");
		cfg.setNumberFormat("0.######");
		int uniqueId=paginationConsumeVo.getUniqueId();
		int limit = paginationConsumeVo.getLimit();
		int totalPages = paginationConsumeVo.getTotalPages();
		ArrayList<PageNumberVo> pagesList = new ArrayList<PageNumberVo>(); 
		for(int i=0;i<totalPages;i++){
			pagesList.add(new PageNumberVo(uniqueId,i*limit,i,totalPages,limit));
		}
		
		Map itemsMap = new HashMap();
		System.out.println("paginationConsumeVo in generateftl: "+paginationConsumeVo.getItemConsumeList());
		itemsMap.put("paginationConsumeVo", paginationConsumeVo);
		itemsMap.put("pagesList", pagesList);
		
		Template template;
		StringWriter writer = new StringWriter();
		try {
			
			template = cfg.getTemplate("pagination.ftl");
			template.process(itemsMap, writer);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
		return writer.toString();
		
	}

	public static String getSideMenu(ItemMenuResponseVo itemsMenuResponseVo) {
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
		cfg.setClassForTemplateLoading(GenerateFtlResponse.class, "/");
		cfg.setNumberFormat("0.######");
		
/*		Collection list = itemsMenuResponseVo.getMenu;
		Map dataModel = new HashMap();
		dataModel.put("Collection", list);
*/
		Map dataModel = new HashMap();
		dataModel.put("itemsMenuResponseVo", itemsMenuResponseVo);
		
		Template template;
		StringWriter writer = new StringWriter();
		try {
			
			template = cfg.getTemplate("menu.ftl");
			template.process(dataModel, writer);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
		System.out.println(writer.toString());
		
		return writer.toString();
		
	}

	public static String getCategoryList(ArrayList<CategoryVo> categoryList) {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
		cfg.setClassForTemplateLoading(GenerateFtlResponse.class, "/");
		cfg.setNumberFormat("0.######");
		
		Map dataModel = new HashMap();
		dataModel.put("categoryList", categoryList);
		
		Template template;
		StringWriter writer = new StringWriter();
		try {
			
			template = cfg.getTemplate("category.ftl");
			template.process(dataModel, writer);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
		System.out.println(writer.toString());
		
		return writer.toString();
	}
	
}
