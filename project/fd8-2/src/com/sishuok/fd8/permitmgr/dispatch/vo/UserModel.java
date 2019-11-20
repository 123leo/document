package com.sishuok.fd8.permitmgr.dispatch.vo;

public class UserModel implements java.io.Serializable{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + "]";
	}
	
}
