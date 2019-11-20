package com.sishuok.fd3.cost;

import java.util.Map;

public abstract class CostComponent {
	public abstract double calcCost(GroupModel gm,Map<String,Double> mapCost);
}
