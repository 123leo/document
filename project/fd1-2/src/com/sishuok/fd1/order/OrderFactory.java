package com.sishuok.fd1.order;

public class OrderFactory {
	private OrderFactory(){}
	
	public static IOrder createIOrder(){
		return new OrderServiceProxy();
	}
}