package com.sishuok.fd2.warehouse;

import java.util.Map;

public interface IWareHouse {
//	public int useGrids(int id);
//	public int unUseGrids(int id);
	//key-WareHouse��id �� value-��WareHouse�������Ѿ�ʹ�õ�grid������
	public Map<Integer,Integer> allUseGrids(int id);
	
	public Map<Integer,Integer> allUnUseGrids(int id);
}
