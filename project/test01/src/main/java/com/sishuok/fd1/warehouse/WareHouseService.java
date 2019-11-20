package com.sishuok.fd1.warehouse;

import com.sishuok.db.MapDB;
import com.sishuok.fd1.Maditor;
import com.sishuok.fd1.order.OrderFactory;

public class WareHouseService implements IWareHouse{

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {
		//1：循环为每个订单创建对应的出库单
		int count = 1;
		for(int orderId : listOrderId){
			Out out = new Out();
			out.setId(count++);
			out.setOrderId(orderId);
			out.setWhId(warehouseId);
			//2：出库单的初始状态为 待备货
			out.setState(WareHouseState.waitPrePare);
			
			MapDB.getMapDB().put("out"+out.getId(),out);
		}
	}

	@Override
	public void prepareOver(int outId) {
		//1：修改出库单的状态为 waitOut
		Out out = (Out)MapDB.getMapDB().get("out"+outId);
		out.setState(WareHouseState.waitOut);
		
		MapDB.getMapDB().put("out"+out.getId(),out);
		//2：反过去修改订单的状态 也为 waitOut		
		Maditor.getInstance().state2WaritOut(out.getOrderId());
	}

	@Override
	public void backOrder(int warehouseId, int orderId) {
		
	}
}
