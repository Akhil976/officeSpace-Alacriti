package com.alacriti.officespace.delegate;

import java.sql.Connection;

import com.alacriti.officespace.bo.impl.GraphBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.GraphAnalyticsRequestVo;
import com.alacriti.officespace.vo.GraphMonthVo;
import com.alacriti.officespace.vo.GraphObjectsVo;

public class GraphDelegate {

	public static GraphObjectsVo doGraphAnalytics(
		GraphAnalyticsRequestVo graphAnalyticsRequest) {
		System.out.println("graph Resource");
		Connection connection = DbConnection.getConnection();
		return GraphBo.doGraphAnalytics(connection,graphAnalyticsRequest);
	}

}
