package com.sishuok.fd1.warehouse;

public class WareHouseService implements IWareHouse{

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {
		//1��ѭ��Ϊÿ������������Ӧ�ĳ��ⵥ
		//2�����ⵥ�ĳ�ʼ״̬Ϊ ������
	}

	@Override
	public void prepareOver(int outId) {
		//1���޸ĳ��ⵥ��״̬Ϊ waitOut
		//2������ȥ�޸Ķ�����״̬ ҲΪ waitOut
	}
}
