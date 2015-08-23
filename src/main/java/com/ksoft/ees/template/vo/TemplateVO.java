package com.ksoft.ees.template.vo;

import java.util.ArrayList;
import java.util.List;


public class TemplateVO {

	private int selTemplateId;
	private List<FieldVO> fieldList=new ArrayList<FieldVO>();
	public int getSelTemplateId() {
		return selTemplateId;
	}
	public void setSelTemplateId(int selTemplateId) {
		this.selTemplateId = selTemplateId;
	}
	public List<FieldVO> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<FieldVO> fieldList) {
		this.fieldList = fieldList;
	}
	
	
	
}
