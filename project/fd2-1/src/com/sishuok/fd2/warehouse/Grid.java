package com.sishuok.fd2.warehouse;

public class Grid {
	private int id;
	private String desc;
	private int pId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "Grid [id=" + id + ", desc=" + desc + ", pId=" + pId + "]";
	}
	
	
}
