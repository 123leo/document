package com.sishuok.fd3.cost;

import java.util.List;

public interface ICost {
	//定义接口中方法 的方法：
	//1：命名===〉体现要实现的功能
	//2：考虑基本的实现方式的需要，来确定传入的参数
	//3：考虑外部调用者的需要，来确定返回类型
	public GroupModel calcCost(int groupId,List<String> calcItems);
}
