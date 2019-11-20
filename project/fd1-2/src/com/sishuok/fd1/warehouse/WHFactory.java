package com.sishuok.fd1.warehouse;

public class WHFactory {
	private WHFactory(){
		
	}
	public static IWareHouse createIWareHouse(){
		return new WareHouseService();
	}
}
