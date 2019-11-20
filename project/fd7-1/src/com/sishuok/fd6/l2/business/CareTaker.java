package com.sishuok.fd6.l2.business;

import java.util.HashMap;
import java.util.Map;

public class CareTaker {
	private CareTaker(){}
	
	private static Map<String,IMsgMemento> map = new HashMap<String,IMsgMemento>();
	
	public static void setMemento(String key,IMsgMemento m){
		map.put(key, m);
	}
	public static IMsgMemento getMemento(String key){
		return map.get(key);
	}
}
