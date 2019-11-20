package com.sishuok.fd2.warehouse;

import java.util.Map;

public abstract class Component{
	private int id;
	private int pId;
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void addChild(Component c){
		throw new UnsupportedOperationException("不支持这个功能");
	}
	public Component getChildren(int index){
		throw new UnsupportedOperationException("不支持这个功能");
	}
	public Map<Integer,Integer> allUseGrids(Map<Integer,Integer> map){
		throw new UnsupportedOperationException("不支持这个功能");
	}
}
