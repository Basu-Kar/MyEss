package com.ksoft.ees.registration.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksoft.ees.common.util.EmailUtil;
import com.ksoft.ees.common.vo.PaginitionVO;
import com.ksoft.ees.common.vo.UserVO;
import com.ksoft.ees.login.dao.LoginDAO;
import com.ksoft.ees.login.vo.LoginVO;
@Service
public class LoginService {
	@Autowired
	private LoginDAO loginDAO;
	
	public UserVO validateLogin(LoginVO loginVO) {
		return loginDAO.validateLogin(loginVO);
		
	}

	public List<UserVO> getPendingApprovalUserList() {
		return loginDAO.getPendingApprovalUserList();
	}

	public void approveUser(int userid) throws AddressException, MessagingException {
		String password= EmailUtil.generatePassword();
		loginDAO.approveUser(userid,password);
		
		UserVO uservo=loginDAO.getUserDetails(userid);
		sendApprovalEmail(uservo);		
	}
	private void sendApprovalEmail(UserVO uservo) throws AddressException, MessagingException {
		
		String toEmail = uservo.getEmailId();
		String subject = "Registration Status";
		String emailBody = "Dear "+uservo.getfName()+" "+uservo.getlName()
				+"\n\n You are registered successfully. "
				+ "\n\n Please find your email Id and Password. \n\n Email Id: "+uservo.getEmailId()+"\n\n Password: "+uservo.getPassword()+"\n\n.Note. This is an auto generated email,"
						+ "please do not reply. \n\nThanks & Regards, \n ESS Edmin";
		EmailUtil.sendEmail(toEmail, subject, emailBody);

    }
	

	public void declineUser(int userid) throws AddressException, MessagingException {
		UserVO uservo=loginDAO.getUserDetails(userid);

		loginDAO.declineUser(userid);
		sendDeclineEmail(uservo);		

		
	}
	private void sendDeclineEmail(UserVO uservo) throws AddressException, MessagingException {
			
			String toEmail = uservo.getEmailId();
			String subject = "Registration Status";
			String emailBody = "Dear "+uservo.getfName()+" "+uservo.getlName()
					+"\n\n Your request has been rejected. \n\n Please call helpdesk number:91-9886323700."
					+ "\n\nNote. This is an auto generated email,"
							+ "please do not reply. \n\n Thanks & Regards, \n ESS Edmin";
			EmailUtil.sendEmail(toEmail, subject, emailBody);
		
	
	}


	/**
	 * 
	 * @param paginitionVO
	 * @return
	 */
	public List<UserVO> getPaginatedApprovedUsers(PaginitionVO paginitionVO){
		
		int totalCount = loginDAO.getTotalCountOfPendingUserStatus();
		paginitionVO.setTotalCount(totalCount);
		paginate(paginitionVO);
		
		return loginDAO.getUserStatusForPage(paginitionVO);
		
	}

	
	/**
	 * 
	 * @param paginitionVO
	 */
	private void paginate(PaginitionVO paginitionVO){
		int noOfRecordsPerPage=10;
		int startIndex=(paginitionVO.getCurrentPage()-1)*noOfRecordsPerPage;
		int endIndex=noOfRecordsPerPage;
		paginitionVO.setStartIndex(startIndex);
		paginitionVO.setEndIndex(endIndex);
	}
}
