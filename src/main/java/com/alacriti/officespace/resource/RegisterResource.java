package com.alacriti.officespace.resource;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.alacriti.officespace.delegate.RegisterDelegate;
import com.alacriti.officespace.util.GenerateFtlResponse;
import com.alacriti.officespace.util.ResponseUtil;
import com.alacriti.officespace.vo.RegisterUtil;
import com.alacriti.officespace.vo.ResponseVo;


@Path("/getStarted")
public class RegisterResource {
	

	
	@GET
	public String abc(){
		return "abc";
	}
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String addUser(
			@FormParam("first_name") String first_name,
			@FormParam("last_name") String last_name,
			@FormParam("email_id") String email_id,
			@FormParam("contact_number") String contact_number,
			@FormParam("pass_word") String pass_word,
			@FormParam("confirmPass_word") String confirmPass_word,
			@FormParam("user_role") String user_role
			){
		
		RegisterUtil userInfo = new RegisterUtil();
		userInfo.setFirst_name(first_name);
		userInfo.setLast_name(last_name);
		userInfo.setEmail_id(email_id);
		userInfo.setContact_number(contact_number);
		userInfo.setPass_word(pass_word);
		userInfo.setConfirmPass_word(confirmPass_word);
		userInfo.setUser_role(user_role);
		
		
		ResponseVo responseVo =  RegisterDelegate.addUser(userInfo);
		String ftlCode = GenerateFtlResponse.getRegistrationCode(responseVo);
		return ftlCode;
	}
}
