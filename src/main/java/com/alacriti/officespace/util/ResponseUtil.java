package com.alacriti.officespace.util;

import com.alacriti.officespace.vo.ResponseVo;

public class ResponseUtil {

	public static String getRegistrationResponse(ResponseVo responseVo) {
		
		if(responseVo.isSuccess()==true){
			return "successfully Registered";
		}
		else if(responseVo.isSuccess()==false){
			return "Registration fails";
		}
		else{
			return null;
		}
	}
	
}
