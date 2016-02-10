package com.ksoft.ees.project.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ksoft.ees.common.vo.UserVO;
import com.ksoft.ees.project.vo.ProjectVO;

@Repository
public class ProjectDAO implements IProjectDAO{

	@Autowired
	private SessionFactory sessionFactory;
	 
	public void addProject(ProjectVO projectVO){
		List<UserVO> list = this.sessionFactory.getCurrentSession().createQuery("from UserVO ")
        //.setParameter(0, category)
        .list();
		System.out.println(list);
		
	}
	
}
