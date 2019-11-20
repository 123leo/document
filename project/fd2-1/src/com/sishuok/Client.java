package com.sishuok;

import com.sishuok.db.MapDB;

public class Client {
	public static void main(String[] args) {
		//创建 仓库、库区、堆位的对象，然后把这些数据存放到MapDB
		
		
		
		
	}
	
	private static void printMapDB(String str){
		System.out.println(str+"================================");
		for(Object key : MapDB.getMapDB().keySet()){
			System.err.println("key="+key+" , value="+MapDB.getMapDB().get(key));
		}
	}
}
