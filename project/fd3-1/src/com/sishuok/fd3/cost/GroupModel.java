package com.sishuok.fd3.cost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//�������
public class GroupModel {
	private int id;
	
	//���صļ�������
	//key -- ������value--����ĳɱ�
	private Map<String,Double> mapCost = new HashMap<String,Double>();
	
	public void calcCost(List<String> calcItems){
		//��������̬��װ
		
	}	
}

//�������===��ĳһ�������ҵ�����
//��������Ǵ�����������ķ�ʽ

//pojo==������+getter/setter + ���ݴ�ȡ��ʵ��==��

//������ƵĻ���˼�룺����+getter/setter + ���ݴ�ȡ��ʵ��  + ��������ҵ����
//=====>������һ�� ҵ��Сģ��

//������٣���ҵ��Խ���ӣ�����ṹ���������ҵ�����̻�����׿�����ʵ��
//��ʵ�ֽǶȣ�����Ա��������˼��Ҫ��ϸߣ�
//������ҵ�����֮���໥�й�ϵ��ʱ�򣬲��Ǻܺô���
//�����ڷֲ㡢�����ڹ������Ļ���

//�仯
//vo====������+getter/setter ====��Entity Object �� DTO  ��TO �� VO
//dao===�����ݴ�ȡ��ʵ��
//service===> ��������ҵ���� ��
//���˵������ܿ�������������ڲ���ɣ������漰������������󽻻�����ô��ʵ��������������棬��Service����ֱ�ӵ��þͿ�����
//��Ҫ�漰������������󽻻���ʱ�򣬰������Ĺ��ܣ��ŵ�service������ʵ�֣����ʱ��service����һ���н���

















