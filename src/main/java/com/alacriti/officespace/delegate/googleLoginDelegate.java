package com.alacriti.officespace.delegate;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.alacriti.officespace.util.LoginUtil;
import com.alacriti.officespace.vo.LoginResponseVo;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;


public class googleLoginDelegate {

	private static final String CLIENT_ID = "360785064192-idqsajfiss7kivd2gi0uscqm3jrrntr0.apps.googleusercontent.com";
	private static final HttpTransport transport = new NetHttpTransport();;
	private static final JsonFactory jsonFactory = new JacksonFactory();

	public static String validation(HttpServletRequest request, String id_token) {
		
	GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
	    .setAudience(Arrays.asList(CLIENT_ID))
	    .setIssuer("accounts.google.com")
	    .build();
	
	GoogleIdToken idToken;
	try {
		idToken = verifier.verify(id_token);
		
		System.out.println(idToken);
		
		if (idToken != null) {
			  Payload payload = idToken.getPayload();
			
			  String userId = payload.getSubject();
			  System.out.println("User ID: " + userId);
			
			  String email = payload.getEmail();
			  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			  
			  String name = (String) payload.get("name");
			  String pictureUrl = (String) payload.get("picture");
			  String locale = (String) payload.get("locale");
			  String familyName = (String) payload.get("family_name");
			  String givenName = (String) payload.get("given_name");
			  
			  if(email.contains("@alacriti.com")){
				
				LoginResponseVo loginResponseVo = new LoginResponseVo();
				loginResponseVo.setSuccess(true);
				loginResponseVo.setUserRole("employee");
				loginResponseVo.setUserId(0);
				
				return LoginUtil.doLogin(request, loginResponseVo);
				
				
			  }
			  else{
				  System.out.println("you are not an alacrity employee");
				  return "you are not an alacrity employee";
			  }
			
		} else {
		  System.out.println("Invalid ID token.");
		}
	} catch (GeneralSecurityException | IOException e) {
		e.printStackTrace();
	}
	return "Something wrong in login delegate";

		
	}

}
