package com.alacriti.officespace.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alacriti.officespace.resource.ItemsMenuResource;
import com.alacriti.officespace.vo.ItemDetailsAdmin;
import com.alacriti.officespace.vo.LoginRequestVo;
import com.alacriti.officespace.vo.LoginResponseVo;
import com.alacriti.officespace.vo.ResponseVo;
import com.alacriti.officespace.vo.SessionObject;


public class LoginUtil {

	public static String doLogin(HttpServletRequest request, LoginResponseVo loginResponseVo) {
		if(loginResponseVo.isSuccess()==true){

			HttpSession session = request.getSession();
			
			SessionObject sessionObject = new SessionObject();
			sessionObject.setUserId(loginResponseVo.getUserId());
			sessionObject.setUserRole(loginResponseVo.getUserRole());

			session.setAttribute("sessionObject", sessionObject);
	    	System.out.println("session created");
	    	
	    	ItemsMenuResource itemMenuResource = new ItemsMenuResource();
	    	System.out.println("going to item Menu resource");
	    	System.out.println(itemMenuResource.getMenu());
	    	return itemMenuResource.getMenu();
	    	
		}
		return null;
	}
	
}
