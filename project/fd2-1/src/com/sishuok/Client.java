package com.sishuok;

import com.sishuok.db.MapDB;

public class Client {
	public static void main(String[] args) {
		//���� �ֿ⡢��������λ�Ķ���Ȼ�����Щ���ݴ�ŵ�MapDB
		
		
		
		
	}
	
	private static void printMapDB(String str){
		System.out.println(str+"================================");
		for(Object key : MapDB.getMapDB().keySet()){
			System.err.println("key="+key+" , value="+MapDB.getMapDB().get(key));
		}
	}
}
