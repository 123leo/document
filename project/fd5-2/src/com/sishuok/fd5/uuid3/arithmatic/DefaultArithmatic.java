package com.sishuok.fd5.uuid3.arithmatic;

import com.sishuok.fd5.uuid3.UuidVO;
import com.sishuok.fd5.uuid3.dao.UuidDAO;
import com.sishuok.fd5.uuid3.dao.UuidDAOFactory;

public class DefaultArithmatic implements IArithmatic {
	private UuidDAO dao = UuidDAOFactory.createUuidDAO();
	
	@Override
	public String genUuid(String businessType,int cacheNum) {
		// 1������businessType ȥ��ȡ��Ӧ�� uuid
		Object obj = CacheManager.getInstance().getMapNow().get(businessType);
		int uuid = 0;
		// 2��һ�����ҵ���
		if (obj != null) {
			uuid = updateBusinessTypeUuid(businessType,cacheNum,(Integer)obj);
		} else {
			// 3���Ҳ���
			uuid = createBusinessTypeUuid(businessType,cacheNum);
		}
		return ""+uuid;
	}

	private int createBusinessTypeUuid(String businessType,int cacheNum) {
		// 3.1���Ǿ����� uuid=1�������һ���µ�����
		UuidVO vo = new UuidVO(businessType, cacheNum);
		// 3.2��Ȼ����µ�uuid �����ص����ݴ洢��
		dao.createUuid(vo);
		
		//ͬʱ�򻺴����������
		CacheManager.getInstance().getMapDB().put(businessType, cacheNum);
		CacheManager.getInstance().getMapNow().put(businessType, 1);

		return 1;
	}

	private int updateBusinessTypeUuid(String businessType,int cacheNum,int uuid) {
		// 2.1���ͰѶ�Ӧ��uuid+1��Ϊ�µ�uuid
		int newUuid = uuid + 1;
		// 2.2��Ȼ��Ͱ�����µ�uuid�޸Ļص����ݴ洢��
		CacheManager.getInstance().getMapNow().put(businessType, newUuid);
		
//		�ж��Ƿ���Ҫ�޸����ݴ洢
		int dbUuid = CacheManager.getInstance().getMapDB().get(businessType);
		
		if(newUuid >= dbUuid){
			UuidVO uuidVo = new UuidVO(businessType,newUuid + cacheNum);
			
			dao.updateUuid(uuidVo);
			//ͬʱ����mapDB
			CacheManager.getInstance().getMapDB().put(businessType, uuidVo.getUuid());
		}
		

		return newUuid;
	}
}
