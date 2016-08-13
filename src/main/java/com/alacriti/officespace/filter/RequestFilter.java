package com.alacriti.officespace.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class RequestFilter implements ContainerRequestFilter {
	String loginPath = "/login";
	String registrationPath = "/getStarted";
	@Context HttpServletRequest httpServletRequest;
	public void filter(ContainerRequestContext request) throws IOException {
		System.out.println("in filter");
		String requestPath = request.getUriInfo().getPath();
		
		HttpSession session = httpServletRequest.getSession(false);
		
		if(requestPath.contains(loginPath) || requestPath.contains(registrationPath)){
			System.out.println("int if");
			return ;
		}
		else if(session != null){
			System.out.println("in else if");
			return;
		}
		else{
			System.out.println("Invalied Request: Filter.");
			request.abortWith(Response.status(Response.Status.FORBIDDEN).entity("/OfficeSpace/html/login.html").build());
		}
	}
	
}
