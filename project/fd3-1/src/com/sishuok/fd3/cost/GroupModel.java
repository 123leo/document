package com.sishuok.fd3.cost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//领域对象
public class GroupModel {
	private int id;
	
	//返回的计算数据
	//key -- 计算的项，value--该项的成本
	private Map<String,Double> mapCost = new HashMap<String,Double>();
	
	public void calcCost(List<String> calcItems){
		//反射来动态组装
		
	}	
}

//领域对象===〉某一个具体的业务对象
//领域设计是纯粹的面向对象的方式

//pojo==〉属性+getter/setter + 数据存取的实现==〉

//领域设计的基本思想：属性+getter/setter + 数据存取的实现  + 领域对象的业务功能
//=====>就像是一个 业务小模块

//对象较少，当业务越复杂，整体结构会更清晰，业务流程会更容易看懂和实现
//从实现角度，对人员面向对象的思想要求较高，
//处理多个业务对象之间相互有关系的时候，不是很好处理
//不利于分层、不利于工作量的划分

//变化
//vo====〉属性+getter/setter ====〉Entity Object ， DTO  ，TO ， VO
//dao===〉数据存取的实现
//service===> 领域对象的业务功能 ，
//如果说这个功能可以在领域对象内部完成，而不涉及跟其他领域对象交互，那么就实现在领域对象里面，在Service里面直接调用就可以了
//需要涉及跟其他领域对象交互的时候，把这样的功能，放到service里面来实现，这个时候，service类似一个中介者

















