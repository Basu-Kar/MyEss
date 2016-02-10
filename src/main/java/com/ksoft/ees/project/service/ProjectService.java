package com.ksoft.ees.project.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ksoft.ees.project.dao.IProjectDAO;
import com.ksoft.ees.project.vo.ProjectVO;

@Service
public class ProjectService implements IProjectService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private IProjectDAO projectDAO;
	
	@Transactional
	public void addProject(ProjectVO projectVO){
		projectDAO.addProject(projectVO);
	}
}
