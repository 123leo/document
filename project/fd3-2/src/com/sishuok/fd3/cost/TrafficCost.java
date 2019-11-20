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
		//����������� ����ģʽ
		//Ҳ�������� ������ģʽ
		
		//����ҵ������μ��㣬���ﲻ����
		double cost = gm.getPersonNum() * 100;
		
		mapCost.put(TRAFFIC_ITEM, cost);
		
		return component.calcCost(gm, mapCost) + cost;
	}

}
