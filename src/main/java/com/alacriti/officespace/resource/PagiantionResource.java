package com.alacriti.officespace.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.alacriti.officespace.delegate.PaginationDelegate;
import com.alacriti.officespace.util.GenerateFtlResponse;
import com.alacriti.officespace.vo.PaginationConsumeVo;
@Path("/getPagination")
public class PagiantionResource {
	@POST
	@Path("{uniqueId}/{offset}/{limit}/{pageNumber}/{totalPages}")
	public String pagination(@PathParam("uniqueId") int uniqueId,
			@PathParam("offset") int offset,
			@PathParam("limit") int limit,
			@PathParam("pageNumber") int pageNumber,
			@PathParam("totalPages") int totalPages){
		
		System.out.println("in pagination resource");
		
		PaginationConsumeVo paginationConsumeVo = new PaginationConsumeVo();
		paginationConsumeVo.setUniqueId(uniqueId);
		paginationConsumeVo.setOffset(offset);
		paginationConsumeVo.setLimit(limit);
		paginationConsumeVo.setPageNo(pageNumber);
		paginationConsumeVo.setTotalPages(totalPages);
		
		PaginationConsumeVo pageConsumeVo=PaginationDelegate.pagination(paginationConsumeVo);
		
		System.out.println("Pagination resource: "+pageConsumeVo);
		
		String ftlCode= GenerateFtlResponse.getPagiantion(pageConsumeVo);

		return ftlCode;
	}
}	
