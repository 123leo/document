package com.sishuok.fd4.uuid1.dao;

public class UuidDAOFactory {
	private UuidDAOFactory(){}
	
	public static UuidDAO createUuidDAO(){
		return new FileImpl();
	}
}
