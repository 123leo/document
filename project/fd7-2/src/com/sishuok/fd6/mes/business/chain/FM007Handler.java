package com.sishuok.fd6.mes.business.chain;

import com.sishuok.fd6.mes.business.vo.MsgVO;

public class FM007Handler extends MsgExecuteHandler{

	public FM007Handler(MsgExecuteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public String handlerRequest(MsgVO vo) {
		
		return null;
	}
}
