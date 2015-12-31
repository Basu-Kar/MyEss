package com.ksoft.ees.common.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_STATUS")
public class UserStatusVO {

	@Column(name="USER_STAT_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int statusId;
	
	@Column(name="STAT_NAME")
	private String statusName;
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
	
}
