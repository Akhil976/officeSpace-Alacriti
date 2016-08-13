package com.alacriti.officespace.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;


public class TLSsend {
public boolean sending(String toMail){
	final String fromEmail = "from@gmail.com"; //requires valid gmail id
	final String password = "*********"; // correct password for gmail id

	System.out.println("TLSEmail Start");
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host"relay.jangosmtp.net";
	props.put("mail.smtp.port", "587"); //TLS Port
	props.put("mail.smtp.auth", "true"); //enable authentication
	props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
	
            //create Authenticator object to pass in Session.getInstance argument
	Authenticator auth = new Authenticator() {
		//override the getPasswordAuthentication method
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(fromEmail,password);
		}
	};
	Session session = Session.getInstance(props, auth);
	
	
	return EmailUtil.sendEmail(session,toMail);
	
	

}
}
