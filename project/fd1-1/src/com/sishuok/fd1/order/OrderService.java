package com.sishuok.fd1.order;

public class OrderService implements IOrder{

	@Override
	public void valid(int... listOrderId) {
		//1：检查输入数据是否正确
		//2：循环处理每个订单
		//2.1：检查状态是否适合处理
		//2.2：把订单的状态修改为  待分单
	}

	@Override
	public void inValid(int... listOrderId) {
		//1：检查输入数据是否正确
		//2：循环处理每个订单
		//2.1：检查状态是否适合处理
		//2.2：把订单的状态修改为  无效
	}

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {
		//1：检查输入数据是否正确
		//2：循环处理每个订单
		//2.1：检查状态是否适合处理
		//3：把符合要求的订单传入WareHouse进行处理
		//3.1：调用 IWareHouse.dispatchOrder
		//4：修改订单的状态为 waitPrepare
	}
}
