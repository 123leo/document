package com.sishuok.fd8.permitmgr.dispatch.vo;

public class RoleModel implements java.io.Serializable{
	private int id;
	private String verifyName;
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVerifyName() {
		return verifyName;
	}

	public void setVerifyName(String verifyName) {
		this.verifyName = verifyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RoleModel [id=" + id + ", verifyName=" + verifyName + ", name="
				+ name + "]";
	}
	
}
