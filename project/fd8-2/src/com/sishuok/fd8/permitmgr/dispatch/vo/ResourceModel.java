package com.sishuok.fd8.permitmgr.dispatch.vo;

public class ResourceModel implements java.io.Serializable{
	private int id;
	private String path;
	private String name;
	private String description;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResourceModel [id=" + id + ", path=" + path + ", name=" + name
				+ ", description=" + description + "]";
	}
	
	
}
