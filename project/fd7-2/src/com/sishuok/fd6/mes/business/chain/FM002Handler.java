package com.sishuok.fd6.mes.business.chain;

import com.sishuok.fd6.l2.business.Constant;
import com.sishuok.fd6.mes.business.vo.MsgVO;

public class FM002Handler extends MsgExecuteHandler{

	public FM002Handler(MsgExecuteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public String handlerRequest(MsgVO vo) {
		if(Constant.FM2.equals(vo.getMsgType())){
			//¥¶¿Ì
			System.out.println("now in FM002Handler==="+vo);
			
			return "Heart beat success";
		}
		return super.nextHandler(vo);
	}
}
