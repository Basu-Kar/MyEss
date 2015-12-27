package com.ksoft.ees.common.util;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	public static Session getEmailSession(){
		 Properties emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", "587");
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        emailProperties.put("mail.smtp.host", "smtp.gmail.com");
        Session  mailSession = Session.getInstance(emailProperties,
      		  new javax.mail.Authenticator() {
      			protected PasswordAuthentication getPasswordAuthentication() {
      				return new PasswordAuthentication("basudeva.kar@gmail.com", "fuezqajebqbnyujr");
      			}
      		  });
	        
	   return mailSession;     
	        
	}
	
	/**
	 * This method is used to generate password when admin user approves the submitted registration request.
	 * @return
	 */
	public static String generatePassword(){
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();		
		   StringBuilder sb = new StringBuilder( 8 );
		   for( int i = 0; i < 8; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
		
	}
	
	public static void sendEmail(String toEmail, String subject, String emailBody) throws MessagingException{
		Session mailSession= getEmailSession();
		
		Message message = new MimeMessage(mailSession);
		message.setFrom(new InternetAddress("ess.admin@gmail.com"));
		
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(toEmail));
		
		message.setSubject(subject);
		message.setText(emailBody);
		Transport.send(message);
		
	}

}
