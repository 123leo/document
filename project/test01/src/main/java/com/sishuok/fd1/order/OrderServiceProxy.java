package com.sishuok.fd1.order;

import com.sishuok.db.MapDB;
import com.sishuok.fd1.warehouse.WHFactory;

public class OrderServiceProxy implements IOrder{
	private OrderService orderService = new OrderService();
	
	@Override
	public void valid(int... listOrderId) {
		//1��������������Ƿ���ȷ
		if(listOrderId==null || listOrderId.length==0){
			return;
		}
		//2��ѭ������ÿ������
		//2.1�����״̬�Ƿ��ʺϴ���
		for(int orderId : listOrderId){
			if(! ((Order)MapDB.getMapDB().get("order"+orderId)).getState().equals(OrderState.waitCheck)){
				return;
			}
		}
		
		//ת��ҵ��ϵͳ��ɹ��ܴ���
		orderService.valid(listOrderId);
	}

	@Override
	public void inValid(int... listOrderId) {
		//1��������������Ƿ���ȷ
		//2��ѭ������ÿ������
		//2.1�����״̬�Ƿ��ʺϴ���
		orderService.inValid(listOrderId);
	}

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {
		//1��������������Ƿ���ȷ
		//2��ѭ������ÿ������
		//2.1�����״̬�Ƿ��ʺϴ���
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
