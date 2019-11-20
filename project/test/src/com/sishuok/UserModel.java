package com.sishuok;

public class UserModel implements java.io.Serializable {
	private int id = 0;
	private String name = "";
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
	public UserModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
