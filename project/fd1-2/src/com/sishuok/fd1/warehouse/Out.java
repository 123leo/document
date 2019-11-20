package com.sishuok.fd1.warehouse;

public class Out {
	private int id;
	private int whId;
	public int getWhId() {
		return whId;
	}
	public void setWhId(int whId) {
		this.whId = whId;
	}
	private int orderId;
	private WareHouseState state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public WareHouseState getState() {
		return state;
	}
	public void setState(WareHouseState state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Out [id=" + id + ", whId=" + whId + ", orderId=" + orderId
				+ ", state=" + state + "]";
	}
}
