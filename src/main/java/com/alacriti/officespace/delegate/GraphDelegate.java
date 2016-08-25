package com.alacriti.officespace.delegate;

import java.sql.Connection;

import com.alacriti.officespace.bo.GraphBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.GraphAnalyticsRequestVo;
import com.alacriti.officespace.vo.GraphMonthVo;
import com.alacriti.officespace.vo.GraphObjectsVo;

public class GraphDelegate {

	public static GraphObjectsVo doGraphAnalytics(
		GraphAnalyticsRequestVo graphAnalyticsRequest) {
		Connection connection = DbConnection.getConnection();
		return GraphBo.doGraphAnalytics(connection,graphAnalyticsRequest);
	}

}
