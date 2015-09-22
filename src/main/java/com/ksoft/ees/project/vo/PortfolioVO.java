package com.ksoft.ees.project.vo;

import java.util.List;

public class PortfolioVO {

	private int portFolioId;
	private String portFolioName;
	private List<ProjectVO> projectList;
	
	
	public int getPortFolioId() {
		return portFolioId;
	}
	public void setPortFolioId(int portFolioId) {
		this.portFolioId = portFolioId;
	}
	public String getPortFolioName() {
		return portFolioName;
	}
	public void setPortFolioName(String portFolioName) {
		this.portFolioName = portFolioName;
	}
	public List<ProjectVO> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<ProjectVO> projectList) {
		this.projectList = projectList;
	}
	
	
}
