package com.sishuok.fd3.cost;

import java.util.List;

import com.sishuok.db.MapDB;

public class CostService implements ICost{

	@Override
	public GroupModel calcCost(int groupId, List<String> calcItems) {
		
		GroupModel gm = FlyWeightFactory.getFlyweight(groupId);

		//ҵ�����
		//kkkkk
		
		gm.calcCost(calcItems);
		
		return gm;
	}
}
