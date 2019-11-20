package com.sishuok.fd8.permitmgr.dispatch.vo;

public class PermitDispatchModel implements java.io.Serializable{
	private int id;
	private int userOrRoleId;
	private int type; //1-user,2-role
	private int resourcePermitId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserOrRoleId() {
		return userOrRoleId;
	}

	public void setUserOrRoleId(int userOrRoleId) {
		this.userOrRoleId = userOrRoleId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getResourcePermitId() {
		return resourcePermitId;
	}

	public void setResourcePermitId(int resourcePermitId) {
		this.resourcePermitId = resourcePermitId;
	}

	@Override
	public String toString() {
		return "PermitDispatchModel [id=" + id + ", userOrRoleId="
				+ userOrRoleId + ", type=" + type + ", resourcePermitId="
				+ resourcePermitId + "]";
	}
}
