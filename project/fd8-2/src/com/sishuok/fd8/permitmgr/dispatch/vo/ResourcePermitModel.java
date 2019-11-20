package com.sishuok.fd8.permitmgr.dispatch.vo;

public class ResourcePermitModel implements java.io.Serializable{
	private int id;
	private int resourceId;
	private int permitId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getPermitId() {
		return permitId;
	}

	public void setPermitId(int permitId) {
		this.permitId = permitId;
	}

	@Override
	public String toString() {
		return "ResourcePermitModel [id=" + id + ", resourceId=" + resourceId
				+ ", permitId=" + permitId + "]";
	}
	
	
}
