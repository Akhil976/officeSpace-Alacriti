package com.alacriti.officespace.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class TLSsend {
public static boolean sending(String toMail,String code){
	final String fromEmail = "akhil.rgukt976@gmail.com"; //requires valid gmail id
	final String password = "gakhil@8014"; // correct password for gmail id

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
	
	
	return EmailUtil.sendEmail(session,toMail,code);

}
}
