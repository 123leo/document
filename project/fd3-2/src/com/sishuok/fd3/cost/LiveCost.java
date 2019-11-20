package com.sishuok.fd3.cost;

import java.util.Map;

public class LiveCost extends CostComponent{
	public static final String LIVE_ITEM = "Live";
	
	private CostComponent component = null;
	
	public LiveCost(CostComponent component){
		this.component = component;
	}
	
	@Override
	public double calcCost(GroupModel gm, Map<String, Double> mapCost) {
		//具体业务上如何计算，这里不关心
		double cost = gm.getPersonNum() * 100;
		
		mapCost.put(LIVE_ITEM, cost);
		
		return component.calcCost(gm, mapCost) + cost;
	}

}
