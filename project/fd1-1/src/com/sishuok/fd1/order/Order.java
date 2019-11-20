package com.sishuok.fd1.order;

public class Order {
	private int id;
	private OrderState state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OrderState getState() {
		return state;
	}
	public void setState(OrderState state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", state=" + state + "]";
	}
	
}
