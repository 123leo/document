package com.sishuok.fd3.cost;

import java.util.HashMap;
import java.util.Map;

import com.sishuok.db.MapDB;

public class FlyWeightFactory {
	private static Map<Integer,GroupModel> map = new HashMap<Integer,GroupModel>();
	private FlyWeightFactory(){
		
	}	
	public static GroupModel getFlyweight(int groupId){
		//Java缓存的基本写法
		Object obj = map.get(groupId);
		GroupModel gm = null;
		if(obj!=null){
			gm = (GroupModel)obj;
		}else{
			gm = (GroupModel)MapDB.getMapDB().get(groupId);
			map.put(groupId, gm);
		}
//		return (GroupModel)gm.clone();
		return gm;
	}
}
