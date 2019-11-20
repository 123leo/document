package com.sishuok.fd2.warehouse;

import java.util.Map;

public interface IWareHouse {
//	public int useGrids(int id);
//	public int unUseGrids(int id);
	//key-WareHouse的id ， value-该WareHouse下所有已经使用的grid的数量
	public Map<Integer,Integer> allUseGrids(int id);
	
	public Map<Integer,Integer> allUnUseGrids(int id);
}
