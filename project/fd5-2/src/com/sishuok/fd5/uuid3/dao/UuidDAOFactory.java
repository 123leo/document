package com.sishuok.fd5.uuid3.dao;

public class UuidDAOFactory {
	private UuidDAOFactory(){}
	
	public static UuidDAO createUuidDAO(){
		return new FileImpl();
	}
}
