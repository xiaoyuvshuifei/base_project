package com.bp.baseProject.entity;

/**
 * 管理员角色
 * @author dige
 *
 */
public class AdminRoles extends BaseModel {

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 显示名称
	 */
	private String displayName;
	/**
	 * 描述
	 */
	private String description;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
