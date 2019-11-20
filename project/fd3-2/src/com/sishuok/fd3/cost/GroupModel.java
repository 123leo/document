package com.sishuok.fd3.cost;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//�������
public class GroupModel implements Cloneable{
	private int id;	
	private int personNum = 0;	
	//���صļ�������
	//key -- ������value--����ĳɱ�
	private Map<String,Double> mapCost = new HashMap<String,Double>();
	private double totalMoney = 0.0; 
	
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}


	public void calcCost(List<String> calcItems){
		//��������̬��װ
		CostComponent preD =  new BaseCost();
		for(int i=0;i<calcItems.size();i++){
			CostComponent nowD = this.createCostComponent( 
					ConfManager.getInstance().itemClass(calcItems.get(i))
					, preD);
			preD = nowD;
		}
		//�������м���
		totalMoney = preD.calcCost(this, mapCost);
	}	
	
	private CostComponent createCostComponent(String className,CostComponent c1){
		try {
			Class cls = Class.forName(className);
			
			Constructor c = cls.getConstructor(CostComponent.class);
			
			return (CostComponent)c.newInstance(c1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String toString() {
		return "GroupModel [id=" + id + ", personNum=" + personNum
				+ ", mapCost=" + mapCost + ", totalMoney=" + totalMoney + "]";
	}
	@Override
	public Object clone(){
		GroupModel gm = new GroupModel();
		gm.setId(this.getId());
		gm.setPersonNum(this.getPersonNum());
		return gm;
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

















