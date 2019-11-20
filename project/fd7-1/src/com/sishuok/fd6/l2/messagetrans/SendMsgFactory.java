package com.sishuok.fd6.l2.messagetrans;

import com.sishuok.fd6.l2.messagetrans.client.SendMsgProxy;

public class SendMsgFactory {
	private SendMsgFactory(){}
	
	public static ISendMsg createISendMsg(){
		return new SendMsgProxy();
	}

}
