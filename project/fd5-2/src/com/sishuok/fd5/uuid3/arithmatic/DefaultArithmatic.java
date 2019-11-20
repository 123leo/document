package com.sishuok.fd5.uuid3.arithmatic;

import com.sishuok.fd5.uuid3.UuidVO;
import com.sishuok.fd5.uuid3.dao.UuidDAO;
import com.sishuok.fd5.uuid3.dao.UuidDAOFactory;

public class DefaultArithmatic implements IArithmatic {
	private UuidDAO dao = UuidDAOFactory.createUuidDAO();
	
	@Override
	public String genUuid(String businessType,int cacheNum) {
		// 1：按照businessType 去获取对应的 uuid
		Object obj = CacheManager.getInstance().getMapNow().get(businessType);
		int uuid = 0;
		// 2：一种是找到了
		if (obj != null) {
			uuid = updateBusinessTypeUuid(businessType,cacheNum,(Integer)obj);
		} else {
			// 3：找不到
			uuid = createBusinessTypeUuid(businessType,cacheNum);
		}
		return ""+uuid;
	}

	private int createBusinessTypeUuid(String businessType,int cacheNum) {
		// 3.1：那就设置 uuid=1，这就是一个新的数据
		UuidVO vo = new UuidVO(businessType, cacheNum);
		// 3.2：然后把新的uuid 新增回到数据存储中
		dao.createUuid(vo);
		
		//同时向缓存里面加数据
		CacheManager.getInstance().getMapDB().put(businessType, cacheNum);
		CacheManager.getInstance().getMapNow().put(businessType, 1);

		return 1;
	}

	private int updateBusinessTypeUuid(String businessType,int cacheNum,int uuid) {
		// 2.1：就把对应的uuid+1作为新的uuid
		int newUuid = uuid + 1;
		// 2.2：然后就把这个新的uuid修改回到数据存储中
		CacheManager.getInstance().getMapNow().put(businessType, newUuid);
		
//		判断是否需要修改数据存储
		int dbUuid = CacheManager.getInstance().getMapDB().get(businessType);
		
		if(newUuid >= dbUuid){
			UuidVO uuidVo = new UuidVO(businessType,newUuid + cacheNum);
			
			dao.updateUuid(uuidVo);
			//同时更新mapDB
			CacheManager.getInstance().getMapDB().put(businessType, uuidVo.getUuid());
		}
		

		return newUuid;
	}
}
