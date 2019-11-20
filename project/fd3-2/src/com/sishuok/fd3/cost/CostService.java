package com.sishuok.fd3.cost;

import java.util.List;

import com.sishuok.db.MapDB;

public class CostService implements ICost{

	@Override
	public GroupModel calcCost(int groupId, List<String> calcItems) {
		
		GroupModel gm = FlyWeightFactory.getFlyweight(groupId);

		//ÒµÎñ¼ÆËã
		//kkkkk
		
		gm.calcCost(calcItems);
		
		return gm;
	}
}
