package com.sishuok.fd8.permitmgr.dispatch.vo;

public class PermitModel implements java.io.Serializable{
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
		return "PermitModel [id=" + id + ", name=" + name + "]";
	}
	
}
