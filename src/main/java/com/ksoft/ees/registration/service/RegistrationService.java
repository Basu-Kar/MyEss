

package com.ksoft.ees.registration.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksoft.ees.common.dao.CommonDAO;
import com.ksoft.ees.common.util.EmailUtil;
import com.ksoft.ees.registration.vo.RegistrationVO;



@Service
public class RegistrationService {
	@Autowired
	private CommonDAO commonDAO;
	
	
	public void submitSignUp(RegistrationVO regVO) {
		try {
			sendEmail(regVO);
		} catch (AddressException e1) {
			e1.printStackTrace();
		} catch (javax.mail.MessagingException e1) {
			e1.printStackTrace();
		}
		
		 commonDAO.submitSignUp(regVO);
	}

	/**
	 * This method is used to send the password in email.
	 * @throws AddressException
	 * @throws javax.mail.MessagingException
	 */
	private void sendEmail( RegistrationVO regVO) throws AddressException, javax.mail.MessagingException
    {
		String toEmail = regVO.getEmailId();
		String subject = "Registration Status";
		String emailBody = "Dear "+regVO.getfName()+" "+regVO.getlName()
				+ "\n\n Your registration has been submitted and its under review now. You will receive another email after review.\n\n "
				+ "Note. This is an auto generated email, please do not reply. \n\n Thanks & Regards,\nESS Admin \n";

		EmailUtil.sendEmail(toEmail, subject, emailBody);
		System.out.println("Done");
    }
	
	

}
