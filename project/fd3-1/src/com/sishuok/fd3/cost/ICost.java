package com.sishuok.fd3.cost;

import java.util.List;

public interface ICost {
	//����ӿ��з��� �ķ�����
	//1������===������Ҫʵ�ֵĹ���
	//2�����ǻ�����ʵ�ַ�ʽ����Ҫ����ȷ������Ĳ���
	//3�������ⲿ�����ߵ���Ҫ����ȷ����������
	public GroupModel calcCost(int groupId,List<String> calcItems);
}
