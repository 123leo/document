package com.sishuok.fd4.uuid2.arithmatic;

import com.sishuok.fd4.uuid1.UuidVO;
import com.sishuok.fd4.uuid1.dao.UuidDAO;
import com.sishuok.fd4.uuid1.dao.UuidDAOFactory;

public class DefaultArithmatic implements IArithmatic {
	private UuidDAO dao = UuidDAOFactory.createUuidDAO();
	@Override
	public String genUuid(String businessType) {
		// 1������businessType ȥ��ȡ��Ӧ�� uuid
		UuidVO uuidVo = dao.getByBusinessType(businessType);
		int uuid = 0;
		// 2��һ�����ҵ���
		if (uuidVo != null) {
			uuid = updateBusinessTypeUuid(uuidVo);
		} else {
			// 3���Ҳ���
			uuid = createBusinessTypeUuid(businessType);
		}
		return ""+uuid;
	}

	private int createBusinessTypeUuid(String businessType) {
		// 3.1���Ǿ����� uuid=1�������һ���µ�����
		UuidVO vo = new UuidVO(businessType, 1);
		// 3.2��Ȼ����µ�uuid �����ص����ݴ洢��
		dao.createUuid(vo);

		return vo.getUuid();
	}

	private int updateBusinessTypeUuid(UuidVO uuidVo) {
		// 2.1���ͰѶ�Ӧ��uuid+1��Ϊ�µ�uuid
		uuidVo.setUuid(uuidVo.getUuid() + 1);
		// 2.2��Ȼ��Ͱ�����µ�uuid�޸Ļص����ݴ洢��
		dao.updateUuid(uuidVo);

		return uuidVo.getUuid();
	}
}
