package com.alacriti.officespace.delegate;

import java.sql.Connection;

import com.alacriti.officespace.bo.impl.AnalyticsBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.AnalyticsRequestVo;
import com.alacriti.officespace.vo.AnalyticsTotal;
import com.alacriti.officespace.vo.PaginationConsumeVo;
import com.alacriti.officespace.vo.PaginationRequestVo;

public class AnalyticsDelegate {

	public static AnalyticsTotal getAnalytics(AnalyticsRequestVo analyticsCustom) {
		Connection connection = DbConnection.getConnection();
		return AnalyticsBo.getAnalytics(connection,analyticsCustom);
	}

	public static PaginationConsumeVo getPaginaion(PaginationRequestVo paginationRequestVo) {
		Connection connection = DbConnection.getConnection();
		return AnalyticsBo.getPagiantion(connection,paginationRequestVo);
	}

}
