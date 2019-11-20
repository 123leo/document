package com.sishuok.fd8.permitmgr.dispatch.vo;

public class UserRoleModel implements java.io.Serializable{
	private int id;
	private int userId;
	private int roleId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "UserRoleModel [id=" + id + ", userId=" + userId + ", roleId="
				+ roleId + "]";
	}
	
	
}
