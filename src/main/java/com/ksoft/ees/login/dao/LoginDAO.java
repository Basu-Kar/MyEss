package com.ksoft.ees.login.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import org.springframework.transaction.annotation.Transactional;

import com.ksoft.ees.common.util.HibernateUtil;
import com.ksoft.ees.common.vo.PaginitionVO;
import com.ksoft.ees.common.vo.UserVO;
import com.ksoft.ees.login.vo.LoginVO;


@Repository
public class LoginDAO{
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
    @Transactional
	public UserVO validateLogin(LoginVO loginVO) {
		System.out.println(sessionFactory);
//		Session session=HibernateUtil.getHibernateSession();
		Session session = this.sessionFactory.getCurrentSession();
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

	public void declineUser(int userid) {
		Session session=HibernateUtil.getHibernateSession();
	     Transaction t=session.beginTransaction();    

		Query query = session.createQuery("delete UserVO where userId = :p1");
		query.setParameter("p1", userid);
		
		int result = query.executeUpdate();		
		t.commit();
	     session.close();
	}
	
	public int getTotalCountOfPendingUserStatus(){
		Session session=HibernateUtil.getHibernateSession();
		Query q = session.createQuery("select count(*) from  UserVO where userstatus=:p1");
		q.setParameter("p1", 1);

		
		
		return ((Long)q.uniqueResult()).intValue();
	}
	
	
	public List<UserVO> getUserStatusForPage(PaginitionVO paginitionVO){
		Session session=HibernateUtil.getHibernateSession();
		Query q = session.createQuery("select count(*) from  UserVO where userstatus=:p1");
		q.setParameter("p1", 1);
		q.setFirstResult(paginitionVO.getStartIndex());
		q.setMaxResults(paginitionVO.getEndIndex());		
		
		return q.list();
	}
 
}
