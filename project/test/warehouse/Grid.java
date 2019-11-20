package com.sishuok.fd2.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Grid extends Component{
	
	private String desc;
	
	private int useState;
	
	public Map<Integer,Integer> allUseGrids(Map<Integer,Integer> map){
		Object obj = map.get(this.getpId());
		int count = 0;
		if(obj!=null){
			count = (Integer)obj;
		}
		if(this.getUseState()==1){
			
			map.put(this.getpId(),count+1);
		}else{
			map.put(this.getpId(), count);
		}
		return map;
	}
	
	public int getUseState() {
		return useState;
	}
	public void setUseState(int useState) {
		this.useState = useState;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Grid [id=" + getId() + ", desc=" + desc + ", pId=" + this.getpId()
				+ ", useState=" + useState + "]";
	}
	
	
}
