package com.alacriti.officespace.resource;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.alacriti.officespace.delegate.ItemDelegate;
import com.alacriti.officespace.util.GenerateFtlResponse;
import com.alacriti.officespace.vo.ItemDetailsAdmin;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;


@Path("/item")
public class ItemResource {
	
	@GET
	@Path("{itemId}")
	public String abc(@PathParam("itemId") int itemId){
		System.out.println("item Resource");
		return "The item id is "+itemId;
	}
	@POST
	@Path("{itemId}")
	public String getItemDetails(@PathParam("itemId") int itemId, @Context HttpServletRequest request) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException, SQLException{
		
		ItemDetailsAdmin itemDetailsAdmin = ItemDelegate.getItemDetails(itemId);
		String ftlCode = GenerateFtlResponse.getInventoryPage(request, itemDetailsAdmin);
		return ftlCode;
		
	}
}
