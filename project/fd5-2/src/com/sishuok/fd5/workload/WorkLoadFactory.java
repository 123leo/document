package com.sishuok.fd5.workload;

public class WorkLoadFactory {
	private WorkLoadFactory(){}
	
	public static IWorkLoad createIWorkLoad(){
		
		WorkLoadService wl = WorkLoadService.getInsatance();
		if(wl.countObservers() == 0){
			wl.addObserver(new CheckObserver());
			wl.addObserver(new PauseObserver());
		}
		
		return wl;
	}
}
