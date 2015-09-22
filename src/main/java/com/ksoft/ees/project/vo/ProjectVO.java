package com.ksoft.ees.project.vo;

import com.ksoft.ees.common.vo.CodeVO;

public class ProjectVO {

	private int projectId;
	private String projectName;
	private CodeVO technologyStack;
	
	

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public CodeVO getTechnologyStack() {
		return technologyStack;
	}

	public void setTechnologyStack(CodeVO technologyStack) {
		this.technologyStack = technologyStack;
	}

	
}
