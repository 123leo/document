package com.sishuok.fd1.order;

public enum OrderState {
	waitCheck("待处理"),waitDispatch("待分单"),inValid("无效"),
	waitPrepare("待备货"),waitOut("待出库"),transport("运输中"),
	waitSend("待送货"),signed("已签收"),waitFinance("待对帐"),over("处理完成")
	;
	
	private String state;
	private OrderState(String state){
		this.state = state;
	}
	
	public String getState(){
		return this.state;
	}
	
}
