package com.bp.baseProject.entity;

import java.util.Date;


/**
 * 管理员用户
 * @author dige
 *
 */
public class AdminUser extends BaseModel{
	
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 客户端id
	 */
	private String clientId;
	/**
	 * token
	 */
	private String apiToken;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 是否是超级管理员
	 */
	private int isSuper;
	/**
	 * 历史token
	 */
	private String rememberToken;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;
	/**
	 * 管理员状态。0/1
	 */
	private int status;

	/**
	 * 角色id
	 */
	private String roleId;
	/**
	 * 角色名称
	 */
	private String roleName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getApiToken() {
		return apiToken;
	}

	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(int isSuper) {
		this.isSuper = isSuper;
	}

	public String getRememberToken() {
		return rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
