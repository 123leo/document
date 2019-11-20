package com.sishuok.fd6.mes.business.chain;

import com.sishuok.fd6.mes.business.vo.MsgVO;

public class FM005Handler extends MsgExecuteHandler{

	public FM005Handler(MsgExecuteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public String handlerRequest(MsgVO vo) {
		
		return null;
	}
}
