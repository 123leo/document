package com.sishuok.fd2.warehouse;

import java.util.Map;

public interface IWareHouse {
//	public int useGrids(int id);
//	public int unUseGrids(int id);
	//key-WareHouse��id �� value-��WareHouse�������Ѿ�ʹ�õ�grid������
	
	public Map<Integer,Integer> allUseGrids(Map<Integer,Integer> map);
	
	public Map<Integer,Integer> allUnUseGrids(Map<Integer,Integer> map);
}