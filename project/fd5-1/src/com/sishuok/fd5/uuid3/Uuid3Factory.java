package com.sishuok.fd5.uuid3;

public class Uuid3Factory {
	private Uuid3Factory(){}
	
	public static IUuid createIUuid(){
		return new UuidService();
	}
}
