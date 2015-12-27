package com.ksoft.ees.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksoft.ees.common.dao.CommonDAO;
import com.ksoft.ees.common.vo.RoleVO;
@Service
public class CommonService {
	@Autowired
	private CommonDAO commonDAO;
	public List<RoleVO> getRoleList() {
		return commonDAO.getRoleList();
	}
}
