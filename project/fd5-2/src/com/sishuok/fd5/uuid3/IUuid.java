package com.sishuok.fd5.uuid3;

import com.sishuok.fd5.uuid3.arithmatic.IArithmatic;

public interface IUuid {
	public String genUuid(String businessType,
			boolean needFormat,String formatStr,String c,int len,
			boolean needArithmatic,IArithmatic ia,
			int cacheNum
			);
	
	//字第001 号
	//20
}


//比如：1s  系统处理一个流水号生成需要10ms  ==100个
//提高运行的处理速度和时间， 如果提高程序的 效率， 处理一个流水号生成需要1ms， ===1000个
//并发===〉同一时刻来做有竞争的事情===〉做一件事强的时间越长，并发几率就越高

//高并发处理策略
//降低请求数===〉分流
//提高程序运行的处理速度===〉缓存、读写分离、页面静态化、异步操作......


