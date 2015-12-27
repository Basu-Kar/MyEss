package com.ksoft.ees.login.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ksoft.ees.common.util.HibernateUtil;
import com.ksoft.ees.common.vo.UserVO;
import com.ksoft.ees.login.vo.LoginVO;
@Repository
public class LoginDAO {
	
	public UserVO validateLogin(LoginVO loginVO) {
		Session session=HibernateUtil.getHibernateSession();
		Criteria cr = session.createCriteria(UserVO.class);
		cr.add(Restrictions.eq("emailId", loginVO.getLoginId()));
		cr.add(Restrictions.eq("password", loginVO.getPassword()));

		return (UserVO)cr.uniqueResult();
	}

	public List<UserVO> getPendingApprovalUserList() {
		Session session=HibernateUtil.getHibernateSession();
		Criteria cr = session.createCriteria(UserVO.class);
		cr.add(Restrictions.eq("userstatus", 1));
		return cr.list();
	}

	public void approveUser(int userid,String password) {
		Session session=HibernateUtil.getHibernateSession();
	     Transaction t=session.beginTransaction();    
	     Query query=session.createQuery(" update UserVO set userstatus=:p1,password=:p2 where userId=:p3 ");
	     query.setParameter("p1",2);
	     query.setParameter("p2",password);
	     
	     query.setParameter("p3",userid);

	     int status=query.executeUpdate(); 
	     System.out.println(status); 
	     t.commit();
	     session.close();

	}

	public UserVO getUserDetails(int userid) {
		Session session=HibernateUtil.getHibernateSession();
		Criteria cr = session.createCriteria(UserVO.class);
		cr.add(Restrictions.eq("userId", userid));
	

		return (UserVO)cr.uniqueResult();
	}
 
}
