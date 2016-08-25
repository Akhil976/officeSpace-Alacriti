package com.alacriti.officespace.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.alacriti.officespace.delegate.GraphDelegate;
import com.alacriti.officespace.util.GenerateFtlResponse;
import com.alacriti.officespace.vo.GraphAnalyticsRequestVo;
import com.alacriti.officespace.vo.GraphObjectsVo;
import com.alacriti.officespace.vo.GraphWeekVo;

@Path("graphAnalytics")
public class GraphResource {
	
	@POST
	@Path("/{itemId}/{graphAnalyticsBy}/{graphCalValue}")
	public String doGraphAnalytics(
			@PathParam("itemId") int itemId,
			@PathParam("graphAnalyticsBy") String graphAnalyticsBy,
			@PathParam("graphCalValue") String graphCalValue
			){
		GraphAnalyticsRequestVo graphAnalyticsRequest = new GraphAnalyticsRequestVo();
		graphAnalyticsRequest.setItemId(itemId);
		graphAnalyticsRequest.setGraphAnalyticsBy(graphAnalyticsBy);
		graphAnalyticsRequest.setGraphCalValue(graphCalValue);
		
		GraphObjectsVo graphObjectsVo =  GraphDelegate.doGraphAnalytics(graphAnalyticsRequest);
		String ftlCode = GenerateFtlResponse.getGraph(graphObjectsVo);
		return ftlCode;
	}
}
