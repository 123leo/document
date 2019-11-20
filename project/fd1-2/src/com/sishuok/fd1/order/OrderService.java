package com.sishuok.fd1.order;

import com.sishuok.db.MapDB;
import com.sishuok.fd1.Maditor;
import com.sishuok.fd1.warehouse.WHFactory;

public class OrderService{

	
	public void valid(int... listOrderId) {
		//2.2：把订单的状态修改为  待分单
		for(int orderId : listOrderId){
			Order o = ((Order)MapDB.getMapDB().get("order"+orderId));
			o.setState(OrderState.waitDispatch);
			MapDB.getMapDB().put("order"+orderId, o);
		}
	}

	
	public void inValid(int... listOrderId) {
		//2.2：把订单的状态修改为  无效
		for(int orderId : listOrderId){
			Order o = ((Order)MapDB.getMapDB().get("order"+orderId));
			o.setState(OrderState.inValid);
			MapDB.getMapDB().put("order"+orderId, o);
		}
	}

	
	public void dispatchOrder(int warehouseId, int... listOrderId) {
		//3：把符合要求的订单传入WareHouse进行处理
		for(int orderId : listOrderId){
			Order o = ((Order)MapDB.getMapDB().get("order"+orderId));
			o.setWhId(warehouseId);
			o.setState(OrderState.waitPrepare);
			MapDB.getMapDB().put("order"+orderId, o);
		}
		
		//3.1：调用 IWareHouse.dispatchOrder
		//4：修改订单的状态为 waitPrepare
		Maditor.getInstance().dispatchOrder(warehouseId, listOrderId);
	}

	
	public void state2WaitOut(int orderId) {
		Order o = ((Order)MapDB.getMapDB().get("order"+orderId));
		o.setState(OrderState.waitOut);
		MapDB.getMapDB().put("order"+orderId, o);
	}
	public void back(int orderId) {
		//根据状态进行相应的退货处理
		Order o = ((Order)MapDB.getMapDB().get("order"+orderId));
		if(o.getState().equals(OrderState.waitCheck)
				|| o.getState().equals(OrderState.waitDispatch)
		){
			//在订单处理模块内处理退货
		}else if(o.getState().equals(OrderState.waitPrepare)
				|| o.getState().equals(OrderState.waitOut)
		){
			//在仓库管理模块内处理退货
		}
	}
}
