package com.sishuok.fd2.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WareHouse extends Component{
	private List<Component> listChildren = new ArrayList<Component>();
	
	public List<Component> getListChildren() {
		return listChildren;
	}
	private String name;
	//1-�ֿ⣬2-����
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
		return "WareHouse [id=" + this.getId() + ", name=" + name + ", type=" + type
				+ ", pId=" + this.getpId() + "]";
	}
	
	public void addChild(Component c){
		this.listChildren.add(c);
	}
	public void removeChild(Component c){
		this.listChildren.remove(c);
	}
	public Component getChildren(int index){
		return this.listChildren.get(index);
	}
	
	public Map<Integer,Integer> allUseGrids(Map<Integer,Integer> map){
		//����һ��������������ʹ�õ� grid =  ����һ���Ŀ�����ʹ��grid�� + ����һ����ʹ��grid��
		int count = 0;
		for(Component c : this.listChildren){
			Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
			map2 = c.allUseGrids(map2);
			
			map.putAll(map2);
			
			for(int key : map2.keySet()){
				//�жϱ����Ǳ��ڵ���һ��ģ�����Ƕ�׼���
				//���������
				if((this.getId()==key) ||
					isChild(key)	
				){
					count += map2.get(key);
				}
			}			
		}		
		map.put(this.getId(), count);
		
		return map;
	}
	private boolean isChild(int id){
		for(Component c : this.listChildren){
			if(c.getId() == id){
				return true;
			}
		}
		return false;
	}
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
}
