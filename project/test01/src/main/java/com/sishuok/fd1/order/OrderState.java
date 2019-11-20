package com.sishuok.fd1.order;

public enum OrderState {
	waitCheck("������"),waitDispatch("���ֵ�"),inValid("��Ч"),
	waitPrepare("������"),waitOut("������"),transport("������"),
	waitSend("���ͻ�"),signed("��ǩ��"),waitFinance("������"),over("�������")
	;
	
	private String state;
	private OrderState(String state){
		this.state = state;
	}
	
	public String getState(){
		return this.state;
	}
	
}
