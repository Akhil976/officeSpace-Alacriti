package com.alacriti.officespace.bo;

import java.sql.Connection;

import com.alacriti.officespace.dao.AnalyticsDao;
import com.alacriti.officespace.vo.AnalyticsRequestVo;
import com.alacriti.officespace.vo.AnalyticsTotal;
import com.alacriti.officespace.vo.PaginationConsumeVo;
import com.alacriti.officespace.vo.PaginationRequestVo;


public class AnalyticsBo {

	public static AnalyticsTotal getAnalytics(Connection connection,AnalyticsRequestVo analyticsCustom) {
		AnalyticsTotal analyticsTotal = new AnalyticsTotal();
		int analyticsDay=0;
		int analyticsWeek=0;
		int analyticsMonth=0;
		int analyticsYear=0;
		
		if(analyticsCustom.getAnalyticsBy().equals("day")){
			
			analyticsDay = AnalyticsDao.getDayUsage(connection,analyticsCustom);
			analyticsWeek = analyticsDay*7;
			analyticsMonth = analyticsWeek*30;
			analyticsYear = analyticsMonth*365;
			
		}
		
		else if(analyticsCustom.getAnalyticsBy().equals("week")){
			
			analyticsWeek = AnalyticsDao.getWeekUsage(connection,analyticsCustom);
			analyticsDay = analyticsWeek/7;
			analyticsMonth = analyticsWeek*4;
			analyticsYear = analyticsWeek*52;
		}
		
		else if(analyticsCustom.getAnalyticsBy().equals("month")){
			
			analyticsMonth = AnalyticsDao.getMonthUsage(connection,analyticsCustom);
			analyticsDay = analyticsMonth/30;
			analyticsWeek = analyticsMonth/4;
			analyticsYear = analyticsMonth*12;
			
		}
		else if(analyticsCustom.getAnalyticsBy().equals("year")){

			analyticsYear = AnalyticsDao.getYearUsage(connection,analyticsCustom);
			analyticsDay = analyticsYear/365;
			analyticsWeek = analyticsYear/54;
			analyticsMonth = analyticsYear/12;
		}
		
		analyticsTotal.setAnalyticsDay(analyticsDay);
		analyticsTotal.setAnalyticsWeek(analyticsWeek);
		analyticsTotal.setAnalyticsMonth(analyticsMonth);
		analyticsTotal.setAnalyticsYear(analyticsYear);
		
		return analyticsTotal;
		
	}

	public static PaginationConsumeVo getPagiantion(Connection connection, PaginationRequestVo paginationRequestVo) {
		return AnalyticsDao.getPagination(connection, paginationRequestVo);
	}

}
