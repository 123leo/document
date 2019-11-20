package com.sishuok.fd5.workload;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class CheckObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		WorkLoadService wls = (WorkLoadService)o;
		Map<String,Integer> mapCount = wls.getMapCount();
		
		for(String key : mapCount.keySet()){
			if(key.equals("Doc")){
				if(mapCount.get(key) > 10){
					System.out.println("需要 检查 Doc 业务是否被攻击");
				}
			}
		}
		
	}

}
