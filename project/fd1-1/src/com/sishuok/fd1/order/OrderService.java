package com.sishuok.fd1.order;

public class OrderService implements IOrder{

	@Override
	public void valid(int... listOrderId) {
		//1��������������Ƿ���ȷ
		//2��ѭ������ÿ������
		//2.1�����״̬�Ƿ��ʺϴ���
		//2.2���Ѷ�����״̬�޸�Ϊ  ���ֵ�
	}

	@Override
	public void inValid(int... listOrderId) {
		//1��������������Ƿ���ȷ
		//2��ѭ������ÿ������
		//2.1�����״̬�Ƿ��ʺϴ���
		//2.2���Ѷ�����״̬�޸�Ϊ  ��Ч
	}

	@Override
	public void dispatchOrder(int warehouseId, int... listOrderId) {
		//1��������������Ƿ���ȷ
		//2��ѭ������ÿ������
		//2.1�����״̬�Ƿ��ʺϴ���
		//3���ѷ���Ҫ��Ķ�������WareHouse���д���
		//3.1������ IWareHouse.dispatchOrder
		//4���޸Ķ�����״̬Ϊ waitPrepare
	}
}