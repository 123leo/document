package com.sishuok.fd1.order;

import java.util.List;

public interface IOrder {
	//…Ÿº¥ «∂‡
//	public void validCheck(int orderId,int type);
//	
//	public void validCheck(List<Integer> listOrderId,int type);
//	
//	public void validCheck(int type,int ...listOrderId);

	public void valid(int ...listOrderId);
	
	public void inValid(int ...listOrderId);

	public void dispatchOrder(int warehouseId,int ... listOrderId);
	
	
}
