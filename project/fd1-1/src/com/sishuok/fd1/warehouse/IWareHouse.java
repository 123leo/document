package com.sishuok.fd1.warehouse;

public interface IWareHouse {
	public void dispatchOrder(int warehouseId, int... listOrderId);
	
	public void prepareOver(int outId);
}
