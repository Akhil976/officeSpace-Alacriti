package com.alacriti.officespace.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.alacriti.officespace.delegate.LoginDelegate;
import com.alacriti.officespace.delegate.googleLoginDelegate;
import com.alacriti.officespace.util.LoginUtil;
import com.alacriti.officespace.vo.GoogleLoginRequest;
import com.alacriti.officespace.vo.LoginRequestVo;
import com.alacriti.officespace.vo.LoginResponseVo;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Path("/login")
public class LoginResource {
 
	@POST
	public String login(@FormParam("loginEmail_id") String email_id,
						@FormParam("loginPass_word") String pass_word,
						@Context HttpServletRequest request          )throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException
	{
		System.out.println("login resources");
		LoginRequestVo loginInfo = new LoginRequestVo();
		loginInfo.setEmail_id(email_id);
		loginInfo.setPass_word(pass_word);
		
		LoginResponseVo loginResponseVo = LoginDelegate.login(loginInfo);
		System.out.println("going to login util");
		String ftlCode = LoginUtil.doLogin(request, loginResponseVo);
		
		return ftlCode;
	}
	@Context HttpServletRequest request;
	@POST
	@Path("/google")
	public String googleLogin(GoogleLoginRequest googleLoginRequest){
		String id_token=googleLoginRequest.getId_token();
		System.out.println(id_token);
		return googleLoginDelegate.validation(request,id_token);
		
	}
}
