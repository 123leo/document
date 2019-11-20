package com.sishuok.fd2.warehouse;

import java.util.HashMap;
import java.util.Map;

public class CountMondy implements Visitor{

	@Override
	public Object visit(Component c) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		if(c instanceof WareHouse){
			return this.calculateWareHouse((WareHouse)c,map);
		}else{
			return this.calculateGrid((Grid)c,map);
		}
	}
	private Object calculateGrid(Grid g,Map<Integer,Integer> map){
		Object obj = map.get(g.getpId());
		int count = 0;
		if(obj!=null){
			count = (Integer)obj;
		}
		
		if(g.getUseState() == 1){
			map.put(g.getpId(), (count+1) * 10);
		}else{
			map.put(g.getpId(), count * 10);
		}
		
		return map;
	}
	private Object calculateWareHouse(WareHouse wh,Map<Integer,Integer> map){
		int count = 0;
		for(Component c : wh.getListChildren()){
			Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
			map2 = (Map<Integer,Integer>) c.accept(this);
			
			map.putAll(map2);
			
			for(int key : map2.keySet()){
				//判断必须是本节点下一层的，不再嵌套计算
				//有两种情况
				if((wh.getId()==key) ||
					isChild(key,wh)	
				){
					count += map2.get(key);
				}
			}			
		}		
		map.put(wh.getId(), count);
		
		return map;
	}
	
	private boolean isChild(int id,WareHouse wh){
		for(Component c : wh.getListChildren()){
			if(c.getId() == id){
				return true;
			}
		}
		return false;
	}
}
