package com.sishuok;

import java.util.Map;

import com.sishuok.fd2.warehouse.CountMondy;
import com.sishuok.fd2.warehouse.Grid;
import com.sishuok.fd2.warehouse.Visitor;
import com.sishuok.fd2.warehouse.WareHouse;

public class Client {
	public static void main(String[] args) {
		//创建 仓库、库区、堆位的对象，然后把这些数据组合成  一个组合对象
		WareHouse wh1 = new WareHouse();
		wh1.setId(1);
		wh1.setName("仓库1");
		wh1.setpId(-1);
		wh1.setType(1);		
		
		WareHouse a1 = new WareHouse();
		a1.setId(11);
		a1.setName("库区1");
		a1.setpId(1);
		a1.setType(1);
		
		WareHouse a2 = new WareHouse();
		a2.setId(12);
		a2.setName("库区2");
		a2.setpId(1);
		a2.setType(1);
		
		WareHouse a3 = new WareHouse();
		a3.setId(13);
		a3.setName("库区3");
		a3.setpId(11);
		a3.setType(1);
		Grid g1 = new Grid();
		g1.setId(21);
		g1.setDesc("格子1");
		g1.setpId(11);
		
		Grid g2 = new Grid();
		g2.setId(22);
		g2.setDesc("格子2");
		g2.setpId(13);
		
		Grid g3 = new Grid();
		g3.setId(23);
		g3.setDesc("格子3");
		g3.setpId(13);
		g3.setUseState(1);
		
		Grid g4 = new Grid();
		g4.setId(24);
		g4.setDesc("格子4");
		g4.setpId(12);
		
		Grid g5 = new Grid();
		g5.setId(25);
		g5.setDesc("格子5");
		g5.setpId(12);
		g5.setUseState(1);
		
		//1
		//  11
		//      13
		//           22
		//           23
		//      21
		//  12
		//      24
		//      25		
		
		a3.addChild(g2);
		a3.addChild(g3);
		
		a1.addChild(g1);
		a1.addChild(a3);
		
		a2.addChild(g4);
		a2.addChild(g5);
		
		wh1.addChild(a1);
		wh1.addChild(a2);
		
//		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//		map = wh1.allUseGrids(map);
//		printMap("now test",map);
		
		
		Visitor v = new CountMondy();
		Object obj = wh1.accept(v);
		System.out.println("obj==="+obj);
		
	}
	
	private static void printMap(String str,Map map){
		System.out.println(str+"================================");
		for(Object key : map.keySet()){
			System.err.println("key="+key+" , value="+map.get(key));
		}
	}
}
