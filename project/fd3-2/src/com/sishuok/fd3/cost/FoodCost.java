package com.sishuok.fd3.cost;

import java.util.Map;

public class FoodCost extends CostComponent{
	public static final String FOOD_ITEM = "Food";
	
	private CostComponent component = null;
	
	public FoodCost(CostComponent component){
		this.component = component;
	}
	
	@Override
	public double calcCost(GroupModel gm, Map<String, Double> mapCost) {
		//具体业务上如何计算，这里不关心
		double cost = gm.getPersonNum() * 15;
		
		mapCost.put(FOOD_ITEM, cost);
		
		return component.calcCost(gm, mapCost) + cost;
	}

}
