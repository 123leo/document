package com.sishuok.fd1.order;

import java.util.List;

public interface IOrder {
	//�ټ��Ƕ�
//	public void validCheck(int orderId,int type);
//	
//	public void validCheck(List<Integer> listOrderId,int type);
//	
//	public void validCheck(int type,int ...listOrderId);

	/**
	 * 
	 * @param listOrderId
	 */
	public void valid(int... listOrderId);
	
	public void inValid(int... listOrderId);

	public void dispatchOrder(int warehouseId, int... listOrderId);
	
	public void state2WaritOut(int orderId);
	
	public void back(int orderId);
}
