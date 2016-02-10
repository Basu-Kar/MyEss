package com.ksoft.ees.proj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ksoft.ees.project.service.IProjectService;
import com.ksoft.ees.project.vo.ProjectVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext-Test.xml")
public class ProjectTest {

	@Autowired
	private IProjectService projectService;
	
	@Test
	public void testAddProject(){
		projectService.addProject(new ProjectVO());
	}
}
