package com.sishuok.fd1;

import com.sishuok.fd1.order.OrderFactory;
import com.sishuok.fd1.warehouse.WHFactory;

public class Maditor {
	private static Maditor maditor = new Maditor();
	private Maditor(){}
	public static Maditor getInstance(){
		return maditor;
	}
	
	
	public void dispatchOrder(int warehouseId, int... listOrderId){
		WHFactory.createIWareHouse().dispatchOrder(warehouseId, listOrderId);
	}
	
	public void state2WaritOut(int orderId){
		OrderFactory.createIOrder().state2WaritOut(orderId);
	}
}