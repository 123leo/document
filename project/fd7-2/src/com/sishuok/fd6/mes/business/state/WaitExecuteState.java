package com.sishuok.fd6.mes.business.state;

import com.sishuok.fd6.mes.business.chain.FM001Handler;
import com.sishuok.fd6.mes.business.chain.FM002Handler;
import com.sishuok.fd6.mes.business.chain.FM003Handler;
import com.sishuok.fd6.mes.business.chain.FM004Handler;
import com.sishuok.fd6.mes.business.chain.FM005Handler;
import com.sishuok.fd6.mes.business.chain.FM006Handler;
import com.sishuok.fd6.mes.business.chain.FM007Handler;
import com.sishuok.fd6.mes.business.chain.MsgExecuteHandler;

public class WaitExecuteState implements State {

	@Override
	public void handler(Context ctx) {
		// �������⣺��֪��������ʲô��Ϣ��Ҳ��֪��Ӧ����δ����� Stateֻ���������ƻ���������
		// ����Ϣ�������� �ӵ�һ��ְ�������棬��ְ��������Ķ����Լ�ȥ�Ժ�������������Ӧ��ҵ����
		// 1��Ҫ��װ��
		// 2��Ҫ��һ�����

		MsgExecuteHandler handler = new FM001Handler(new FM002Handler(
				new FM003Handler(new FM004Handler(new FM005Handler(
						new FM006Handler(new FM007Handler(null)))))));
		
		String ret = handler.handlerRequest(ctx.getMsgVO());
		
		ctx.setRetMsg(ret);
		
		ctx.executeState(new WaitPrepareReturnMsgState());		
	}

}