package com.sishuok.fd5.uuid3.arithmatic;

import java.util.HashMap;
import java.util.Map;

import com.sishuok.fd5.uuid3.dao.UuidDAOFactory;

public class CacheManager {
	private Map<String,Integer> mapDB = new HashMap<String,Integer>();
	private Map<String,Integer> mapNow = new HashMap<String,Integer>();
	
	private static CacheManager cm = new CacheManager();
	private CacheManager(){
		//init data
		mapDB = UuidDAOFactory.createUuidDAO().getAll();
		mapNow = UuidDAOFactory.createUuidDAO().getAll();
	}
	
	public static CacheManager getInstance(){
		return cm;
	}
	
	public Map<String,Integer> getMapDB(){
		return mapDB;
	}
	public Map<String,Integer> getMapNow(){
		return mapNow;
	}
}
