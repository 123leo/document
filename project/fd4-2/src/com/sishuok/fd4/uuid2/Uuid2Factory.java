package com.sishuok.fd4.uuid2;

public class Uuid2Factory {
	private Uuid2Factory(){}
	
	public static IUuid createIUuid(){
		return new UuidService();
	}
}
