package com.alacriti.officespace.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
@Path("/logout")
public class LogoutResource {
	
	@POST
	public String doLogout(@Context HttpServletRequest request){
		HttpSession session = request.getSession(false);
		session.removeAttribute("sessionObject");
		session.invalidate();
		return "/OfficeSpace/html/login.html";
	}
}
