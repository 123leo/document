package com.sishuok.fd1.order;

import com.sishuok.db.MapDB;
import com.sishuok.fd1.Maditor;
import com.sishuok.fd1.warehouse.WHFactory;

public class OrderService{

	
	public void valid(int... listOrderId) {
		//2.2���Ѷ�����״̬�޸�Ϊ  ���ֵ�
		for(int orderId : listOrderId){
			Order o = ((Order)MapDB.getMapDB().get("order"+orderId));
			o.setState(OrderState.waitDispatch);
			MapDB.getMapDB().put("order"+orderId, o);
		}
	}

	
	public void inValid(int... listOrderId) {
		//2.2���Ѷ�����״̬�޸�Ϊ  ��Ч
		for(int orderId : listOrderId){
			Order o = ((Order)MapDB.getMapDB().get("order"+orderId));
			o.setState(OrderState.inValid);
			MapDB.getMapDB().put("order"+orderId, o);
		}
	}

	
	public void dispatchOrder(int warehouseId, int... listOrderId) {
		//3���ѷ���Ҫ��Ķ�������WareHouse���д���
		for(int orderId : listOrderId){
			Order o = ((Order)MapDB.getMapDB().get("order"+orderId));
			o.setWhId(warehouseId);
			o.setState(OrderState.waitPrepare);
			MapDB.getMapDB().put("order"+orderId, o);
		}
		
		//3.1������ IWareHouse.dispatchOrder
		//4���޸Ķ�����״̬Ϊ waitPrepare
		Maditor.getInstance().dispatchOrder(warehouseId, listOrderId);
	}

	
	public void state2WaitOut(int orderId) {
		Order o = ((Order)MapDB.getMapDB().get("order"+orderId));
		o.setState(OrderState.waitOut);
		MapDB.getMapDB().put("order"+orderId, o);
	}
	public void back(int orderId) {
		//����״̬������Ӧ���˻�����
		Order o = ((Order)MapDB.getMapDB().get("order"+orderId));
		if(o.getState().equals(OrderState.waitCheck)
				|| o.getState().equals(OrderState.waitDispatch)
		){
			//�ڶ�������ģ���ڴ����˻�
		}else if(o.getState().equals(OrderState.waitPrepare)
				|| o.getState().equals(OrderState.waitOut)
		){
			//�ڲֿ����ģ���ڴ����˻�
		}
	}
}
