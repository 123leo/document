package com.sishuok.fd1.warehouse;

public class WareHouseService implements IWareHouse{

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {
		//1：循环为每个订单创建对应的出库单
		//2：出库单的初始状态为 待备货
	}

	@Override
	public void prepareOver(int outId) {
		//1：修改出库单的状态为 waitOut
		//2：反过去修改订单的状态 也为 waitOut
	}
}
