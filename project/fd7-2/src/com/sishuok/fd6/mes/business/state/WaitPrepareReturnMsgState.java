package com.sishuok.fd6.mes.business.state;

import com.sishuok.fd6.l2.business.Constant;


public class WaitPrepareReturnMsgState implements State {

	@Override
	public void handler(Context ctx) {
		String preStr = "";
		if(Constant.FM1.equals(ctx.getMsgVO().getMsgType())){
			preStr = "MF001:";
		}else if(Constant.FM2.equals(ctx.getMsgVO().getMsgType())){
			preStr = "MF002:";
		}else if(Constant.FM3.equals(ctx.getMsgVO().getMsgType())){
			preStr = "MF003:";
		}else if(Constant.FM4.equals(ctx.getMsgVO().getMsgType())){
			preStr = "MF004:";
		}else if(Constant.FM5.equals(ctx.getMsgVO().getMsgType())){
			preStr = "MF005:";
		} 
		
		ctx.setRetMsg(preStr+ctx.getRetMsg());
	}
}
