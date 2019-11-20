package com.sishuok.fd6.mes.business.chain;

import com.sishuok.fd6.mes.business.vo.MsgVO;

public abstract class MsgExecuteHandler {
	private MsgExecuteHandler nextHandler;
	public MsgExecuteHandler(MsgExecuteHandler nextHandler){
		this.nextHandler = nextHandler;
	}
	
	public abstract String handlerRequest(MsgVO vo);
}
