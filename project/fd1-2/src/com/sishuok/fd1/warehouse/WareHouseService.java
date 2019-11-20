package com.sishuok.fd1.warehouse;

import com.sishuok.db.MapDB;
import com.sishuok.fd1.Maditor;
import com.sishuok.fd1.order.OrderFactory;

public class WareHouseService implements IWareHouse{

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {
		//1��ѭ��Ϊÿ������������Ӧ�ĳ��ⵥ
		int count = 1;
		for(int orderId : listOrderId){
			Out out = new Out();
			out.setId(count++);
			out.setOrderId(orderId);
			out.setWhId(warehouseId);
			//2�����ⵥ�ĳ�ʼ״̬Ϊ ������
			out.setState(WareHouseState.waitPrePare);
			
			MapDB.getMapDB().put("out"+out.getId(),out);
		}
	}

	@Override
	public void prepareOver(int outId) {
		//1���޸ĳ��ⵥ��״̬Ϊ waitOut
		Out out = (Out)MapDB.getMapDB().get("out"+outId);
		out.setState(WareHouseState.waitOut);
		
		MapDB.getMapDB().put("out"+out.getId(),out);
		//2������ȥ�޸Ķ�����״̬ ҲΪ waitOut		
		Maditor.getInstance().state2WaritOut(out.getOrderId());
	}

	@Override
	public void backOrder(int warehouseId, int orderId) {
		
	}
}
