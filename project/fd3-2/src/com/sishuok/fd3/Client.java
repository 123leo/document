package com.sishuok.fd3;

import java.util.ArrayList;
import java.util.List;

import com.sishuok.db.MapDB;
import com.sishuok.fd3.cost.CostFactory;
import com.sishuok.fd3.cost.FoodCost;
import com.sishuok.fd3.cost.GroupModel;
import com.sishuok.fd3.cost.LiveCost;
import com.sishuok.fd3.cost.TrafficCost;

public class Client {
	public static void main(String[] args) {
		GroupModel gm = new GroupModel();
		gm.setId(1);
		gm.setPersonNum(12);
		
		MapDB.getMapDB().put(gm.getId(), gm);
		
		
		List<String> list = new ArrayList<String>();
		list.add(TrafficCost.TRAFFIC_ITEM);

		GroupModel gm2 = CostFactory.createICost().calcCost(gm.getId(), list);
		System.out.println("gm2=="+gm2);
		
		list.add(LiveCost.LIVE_ITEM);
		gm2 = CostFactory.createICost().calcCost(gm.getId(), list);
		System.out.println("gm2=="+gm2);
		
		list.add(FoodCost.FOOD_ITEM);
		gm2 = CostFactory.createICost().calcCost(gm.getId(), list);
		System.out.println("gm2=="+gm2);
	}
}
