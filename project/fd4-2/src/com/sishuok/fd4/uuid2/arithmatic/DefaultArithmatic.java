package com.sishuok.fd4.uuid2.arithmatic;

import com.sishuok.fd4.uuid1.UuidVO;
import com.sishuok.fd4.uuid1.dao.UuidDAO;
import com.sishuok.fd4.uuid1.dao.UuidDAOFactory;

public class DefaultArithmatic implements IArithmatic {
	private UuidDAO dao = UuidDAOFactory.createUuidDAO();
	@Override
	public String genUuid(String businessType) {
		// 1：按照businessType 去获取对应的 uuid
		UuidVO uuidVo = dao.getByBusinessType(businessType);
		int uuid = 0;
		// 2：一种是找到了
		if (uuidVo != null) {
			uuid = updateBusinessTypeUuid(uuidVo);
		} else {
			// 3：找不到
			uuid = createBusinessTypeUuid(businessType);
		}
		return ""+uuid;
	}

	private int createBusinessTypeUuid(String businessType) {
		// 3.1：那就设置 uuid=1，这就是一个新的数据
		UuidVO vo = new UuidVO(businessType, 1);
		// 3.2：然后把新的uuid 新增回到数据存储中
		dao.createUuid(vo);

		return vo.getUuid();
	}

	private int updateBusinessTypeUuid(UuidVO uuidVo) {
		// 2.1：就把对应的uuid+1作为新的uuid
		uuidVo.setUuid(uuidVo.getUuid() + 1);
		// 2.2：然后就把这个新的uuid修改回到数据存储中
		dao.updateUuid(uuidVo);

		return uuidVo.getUuid();
	}
}
