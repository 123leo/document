package com.sishuok.fd2.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WareHouse extends Component{
	private List<Component> listChildren = new ArrayList<Component>();
	public void addChild(Component c){
		this.listChildren.add(c);
	}
	public Component getChildren(int index){
		return this.listChildren.get(index);
	}
	public Map<Integer,Integer> allUseGrids(Map<Integer,Integer> map){
		int count = 0;
		for(Component c : listChildren){
			Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
			map2 = c.allUseGrids(map2);
			map.putAll(map2);
			
			for(int key : map2.keySet()){				
				if(getId() == key || isChild(key)){
					count = count + map2.get(key);
				}
			}
		}
		map.put(this.getId(), count);
		return map;
	}
	private boolean isChild(int id){
		for(Component c : listChildren){
			if(c.getId() == id){
				return true;
			}
		}
		return false;
	}
	public Map<Integer,Integer> allUnUseGrids(){
		return null;
	}
	
	private String name;
	//1-²Ö¿â£¬2-¿âÇø
	private int type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "WareHouse [id=" + getId() + ", name=" + name + ", type=" + type
				+ ", pId=" + this.getpId() + "]";
	}
	
	
}
