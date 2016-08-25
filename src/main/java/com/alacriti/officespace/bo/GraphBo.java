package com.alacriti.officespace.bo;


import java.sql.Connection;

import com.alacriti.officespace.dao.GraphDao;
import com.alacriti.officespace.vo.GraphAnalyticsRequestVo;
import com.alacriti.officespace.vo.GraphMonthVo;
import com.alacriti.officespace.vo.GraphObjectsVo;
import com.alacriti.officespace.vo.GraphWeekVo;
import com.alacriti.officespace.vo.GraphYearVo;

public class GraphBo {
	
	public static GraphObjectsVo doGraphAnalytics(Connection connection,
			GraphAnalyticsRequestVo graphAnalyticsRequest) {
		GraphObjectsVo graphObjectsVo = new GraphObjectsVo();
		if (graphAnalyticsRequest.getGraphAnalyticsBy().equals("month")) {
			GraphMonthVo graphMonthVo = GraphDao.getMonthUsage(connection, graphAnalyticsRequest);
			
			graphObjectsVo.setGraphYearVo(null);
			graphObjectsVo.setGraphMonthVo(graphMonthVo);
			graphObjectsVo.setGraphWeekVo(null);
			return graphObjectsVo;
			
/*			Map<String,Integer> daysUsageInMonth = graphMonthVo.getGraphMonthVoMap();
			System.out.println(daysUsageInMonth);
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
			cfg.setClassForTemplateLoading(GraphBo.class, "/");

			Template template;
			StringWriter writer = new StringWriter();
			try {
				System.out.println("before");
				template = cfg.getTemplate("graphMonth.ftl");
				System.out.println("after");
				template.process(daysUsageInMonth, writer);
				System.out.println("after afete");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return writer.toString();*/
			
		}
		if (graphAnalyticsRequest.getGraphAnalyticsBy().equals("week")) {

			
			GraphWeekVo graphWeekVo = GraphDao.getWeekUsage(connection, graphAnalyticsRequest);
			
			graphObjectsVo.setGraphYearVo(null);
			graphObjectsVo.setGraphMonthVo(null);
			graphObjectsVo.setGraphWeekVo(graphWeekVo);
			return graphObjectsVo;
			
		}
		if (graphAnalyticsRequest.getGraphAnalyticsBy().equals("year")) {

			
			GraphYearVo graphYearVo = GraphDao.getYearUsage(connection, graphAnalyticsRequest);
			
			graphObjectsVo.setGraphYearVo(graphYearVo);
			graphObjectsVo.setGraphMonthVo(null);
			graphObjectsVo.setGraphWeekVo(null);
			return graphObjectsVo;
			
			
/*			Map<String,Integer> daysUsageInWeek = graphYearVo.getGraphMonthVoMap();
			System.out.println(daysUsageInWeek);
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_20);
			cfg.setClassForTemplateLoading(GraphBo.class, "/");

			Template template;
			StringWriter writer = new StringWriter();
			try {
				template = cfg.getTemplate("graphYear.ftl");
				template.process(daysUsageInWeek, writer);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return writer.toString();*/
			
		}
		
		return graphObjectsVo;
	}
}