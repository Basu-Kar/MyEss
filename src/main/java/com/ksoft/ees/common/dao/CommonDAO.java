package com.ksoft.ees.common.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ksoft.ees.common.util.HibernateUtil;
import com.ksoft.ees.common.vo.RoleVO;
import com.ksoft.ees.registration.vo.RegistrationVO;
@Repository
public class CommonDAO {

	public List<RoleVO> getRoleList() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getHibernateSession();
		Query query = session.createQuery("from RoleVO");
		
		return query.list();
	}

	

	public void submitSignUp(RegistrationVO regVO) {
		// TODO Auto-generated method stub
		
		regVO.setUserstatus(1);
	
		Session session=HibernateUtil.getHibernateSession();
		Transaction t=session.beginTransaction();
		session.persist(regVO);
		t.commit();
		session.close();
	}
 
}
