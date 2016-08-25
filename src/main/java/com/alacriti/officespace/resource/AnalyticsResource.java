package com.alacriti.officespace.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import com.alacriti.officespace.delegate.AnalyticsDelegate;
import com.alacriti.officespace.util.GenerateFtlResponse;
import com.alacriti.officespace.vo.AnalyticsRequestVo;
import com.alacriti.officespace.vo.AnalyticsTotal;
import com.alacriti.officespace.vo.PaginationConsumeVo;
import com.alacriti.officespace.vo.PaginationRequestVo;

@Path("/analytics")
public class AnalyticsResource {
		
		@POST
		@Path("/{itemId}/{analyticsBy}/{calValue}")
		public String getAnalytics(
				@PathParam("itemId") int itemId,
				@PathParam("analyticsBy") String analyticsBy,
				@PathParam("calValue") String calenderValue,
				@Context HttpServletRequest request
				){
			AnalyticsRequestVo analyticsRequestVo = new AnalyticsRequestVo();
			analyticsRequestVo.setItemId(itemId);
			analyticsRequestVo.setAnalyticsBy(analyticsBy);
			analyticsRequestVo.setCalenderValue(calenderValue);
			
			String ftlCode;
			AnalyticsTotal analyticsTotal = new AnalyticsTotal();
			
			analyticsTotal = AnalyticsDelegate.getAnalytics(analyticsRequestVo);
			ftlCode = GenerateFtlResponse.getAnalyticsCode(request, analyticsTotal);
			
			return ftlCode;
		}
		@POST
		@Path("/pagination/{itemId}/{analyticsBy}/{date}")
		public String getPagination(@PathParam("itemId") int itemId, @PathParam("analyticsBy") String analyticsBy ,@PathParam("date") String date){
			
			PaginationRequestVo paginationRequestVo = new PaginationRequestVo();
			paginationRequestVo.setCategoryId(1);
			paginationRequestVo.setItemId(itemId);
			paginationRequestVo.setDate(date);
			
			PaginationConsumeVo paginationConsumeVo = AnalyticsDelegate.getPaginaion(paginationRequestVo);
			int uniqueId = paginationConsumeVo.getUniqueId();
			int limit=paginationConsumeVo.getLimit();
			int offset = paginationConsumeVo.getOffset();
			int pageNumber = paginationConsumeVo.getPageNo();
			int totalpages = paginationConsumeVo.getTotalPages();
			PagiantionResource pagiantionResource = new PagiantionResource();
			String ftlCode = pagiantionResource.pagination(uniqueId,offset,limit,pageNumber,totalpages);
			
			return ftlCode;
			
		}
}
