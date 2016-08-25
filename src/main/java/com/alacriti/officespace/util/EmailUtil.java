package com.alacriti.officespace.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


@SuppressWarnings("unused")
public class EmailUtil {

	public static boolean sendEmail(Session session,String toMail,String code) {
		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			//msg.setFrom(new InternetAddress("p.sureshmme@gmail.com","HI"));

			//msg.setReplyTo(InternetAddress.parse("no_reply@journaldev.com",false));

			msg.setSubject("This is replay for password reset", "UTF-8");

			msg.setText("OfficeSpace Verification code: "+code, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toMail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");
			//Store in sent mail dao
		
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
