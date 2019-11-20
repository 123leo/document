package com.sishuok.fd3.cost;

import java.util.Map;

public class TrafficCost extends CostComponent{
	public static final String TRAFFIC_ITEM = "Traffic";
	
	private CostComponent component = null;
	
	public TrafficCost(CostComponent component){
		this.component = component;
	}
	
	@Override
	public double calcCost(GroupModel gm, Map<String, Double> mapCost) {
		//这里可以引入 策略模式
		//也可以引入 解释器模式
		
		//具体业务上如何计算，这里不关心
		double cost = gm.getPersonNum() * 100;
		
		mapCost.put(TRAFFIC_ITEM, cost);
		
		return component.calcCost(gm, mapCost) + cost;
	}

}
