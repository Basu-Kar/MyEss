package com.ksoft.ees.template.service;

import java.util.List;

import com.ksoft.ees.template.vo.TemplateVO;

public interface ITemplateService {

	public int saveTeample(TemplateVO templateVO);
	public int updateTemplate(TemplateVO templateVO);
	public int deleteTemplate(int templateId);
	public TemplateVO getTemplate(int templateId);
	public List<TemplateVO> getAllTemplates();
}
