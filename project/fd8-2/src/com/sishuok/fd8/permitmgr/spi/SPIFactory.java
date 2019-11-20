package com.sishuok.fd8.permitmgr.spi;

import com.sishuok.fd8.permitmgr.sishuokspiimpl.SishuokSPIAbstractFactory;

public class SPIFactory<M> {
	public SPIAbstractFactory<M> createSPIAbstractFactory(){
		return new SishuokSPIAbstractFactory<M>();
	}
}
