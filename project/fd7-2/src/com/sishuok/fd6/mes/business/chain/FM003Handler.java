package com.sishuok.fd6.mes.business.chain;

import com.sishuok.fd6.l2.business.Constant;
import com.sishuok.fd6.mes.business.command.Invoker;
import com.sishuok.fd6.mes.business.command.Invoker.CommandType;
import com.sishuok.fd6.mes.business.vo.MsgVO;

public class FM003Handler extends MsgExecuteHandler{

	public FM003Handler(MsgExecuteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public String handlerRequest(MsgVO vo) {
		//1���ж�����
		//2������psϵͳ�����ܻ�Ƚϸ��ӣ����һ��кܶ�������ϵͳҲ����ps
		//���ֱ��������ʵ�ֵ���ps���Ͳ�̫����
		//������������ģʽ��ֻ�ܷ�������
		//3��
		//4��
		//5��
		
		if(Constant.FM3.equals(vo.getMsgType())){
			//����
			System.out.println("now in FM003Handler==="+vo);
			
			//�������ģʽ
			String ret = new Invoker().runCommand(vo,CommandType.Call_PS_PDIS);
			//
			
			return ret;
		}
		return super.nextHandler(vo);
	}
}