package com.sishuok;

import com.sishuok.db.MapDB;
import com.sishuok.fd1.order.Order;
import com.sishuok.fd1.order.OrderFactory;
import com.sishuok.fd1.order.OrderState;
import com.sishuok.fd1.warehouse.Out;
import com.sishuok.fd1.warehouse.WHFactory;
import com.sishuok.fd1.warehouse.WareHouse;

public class Client {
	public static void main(String[] args) {
		Order o1 = new Order();
		o1.setId(1);
		o1.setState(OrderState.waitCheck);
		
		Order o2 = new Order();
		o2.setId(2);
		o2.setState(OrderState.waitCheck);
		
		MapDB.getMapDB().put("order"+o1.getId(), o1);
		MapDB.getMapDB().put("order"+o2.getId(), o2);
		
		WareHouse wh1 = new WareHouse();		
		wh1.setId(1);
		wh1.setName("wh 1");
		MapDB.getMapDB().put("wh"+wh1.getId(), wh1);
		
		
		OrderFactory.createIOrder().valid(1);
		printMapDB("valid");
		OrderFactory.createIOrder().dispatchOrder(1, 1);
		printMapDB("dispatchOrder");
		WHFactory.createIWareHouse().prepareOver(1);
		printMapDB("prepareOver");
	}
	
	private static void printMapDB(String str){
		System.out.println(str+"================================");
		for(Object key : MapDB.getMapDB().keySet()){
			System.err.println("key="+key+" , value="+MapDB.getMapDB().get(key));
		}
	}
}
