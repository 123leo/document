package com.sishuok.db;

import java.util.HashMap;
import java.util.Map;

public class MapDB {
	private static Map map = new HashMap();
	private MapDB(){}
	
	public static Map getMapDB(){
		return map;
	}
}
