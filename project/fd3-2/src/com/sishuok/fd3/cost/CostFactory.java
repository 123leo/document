package com.sishuok.fd3.cost;

public class CostFactory {
	private CostFactory(){}
	
	public static ICost createICost(){
		return new CostService();
	}
}
