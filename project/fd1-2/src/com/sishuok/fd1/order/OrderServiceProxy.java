package com.sishuok.fd1.order;

import com.sishuok.db.MapDB;
import com.sishuok.fd1.warehouse.WHFactory;

public class OrderServiceProxy implements IOrder{
	private OrderService orderService = new OrderService();
	
	@Override
	public void valid(int... listOrderId) {
		//1：检查输入数据是否正确
		if(listOrderId==null || listOrderId.length==0){
			return;
		}
		//2：循环处理每个订单
		//2.1：检查状态是否适合处理
		for(int orderId : listOrderId){
			if(! ((Order)MapDB.getMapDB().get("order"+orderId)).getState().equals(OrderState.waitCheck)){
				return;
			}
		}
		
		//转调业务系统完成功能处理
		orderService.valid(listOrderId);
	}

	@Override
	public void inValid(int... listOrderId) {
		//1：检查输入数据是否正确
		//2：循环处理每个订单
		//2.1：检查状态是否适合处理
		orderService.inValid(listOrderId);
	}

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {
		//1：检查输入数据是否正确
		//2：循环处理每个订单
		//2.1：检查状态是否适合处理
		orderService.dispatchOrder(warehouseId, listOrderId);
	}

	@Override
	public void state2WaritOut(int orderId) {
		orderService.state2WaitOut(orderId);
	}

	@Override
	public void back(int orderId) {
		orderService.back(orderId);
	}
}
