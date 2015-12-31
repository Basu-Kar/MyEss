package com.ksoft.ees.common.vo;

	import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

	@Entity
	@Table(name="user_det")
	public class UserVO {


	@Column(name="f_name")
	private String fName;

	@Column(name="l_name")
	private String lName;

	@Column(name="email_id")
	private String emailId;

	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	@Column(name="role_id")
	private int roleId;

	@Column(name="USER_STAT_ID")
	private int userstatus;

	@Column(name="PASSWORD")
	private String password;
	
	@OneToOne
	@JoinColumn(name = "USER_STAT_ID",insertable=false,updatable=false)
	private UserStatusVO userStatusVO;
	
	@OneToOne
	@JoinColumn(name = "ROLE_ID")
	private RoleVO roleVO;
	
	


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}
	
	
	public RoleVO getRoleVO() {
		return roleVO;
	}
	public void setRoleVO(RoleVO roleVO) {
		this.roleVO = roleVO;
	}
	public UserStatusVO getUserStatusVO() {
		return userStatusVO;
	}
	public void setUserStatusVO(UserStatusVO userStatusVO) {
		this.userStatusVO = userStatusVO;
	}
	
}
