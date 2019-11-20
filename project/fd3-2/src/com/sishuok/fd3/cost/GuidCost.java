package com.sishuok.fd3.cost;

import java.util.Map;

public class GuidCost extends CostComponent{
	public static final String GUID_ITEM = "GUID";
	
	private CostComponent component = null;
	
	public GuidCost(CostComponent component){
		this.component = component;
	}
	
	@Override
	public double calcCost(GroupModel gm, Map<String, Double> mapCost) {
		//具体业务上如何计算，这里不关心
		double cost = gm.getPersonNum() * 10;
		
		mapCost.put(GUID_ITEM, cost);
		
		return component.calcCost(gm, mapCost) + cost;
	}

}
