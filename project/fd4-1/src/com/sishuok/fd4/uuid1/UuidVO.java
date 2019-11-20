package com.sishuok.fd4.uuid1;

public class UuidVO {
	private String businessType;
	private int uuid;
	
	
	public UuidVO(String businessType, int uuid) {
		super();
		this.businessType = businessType;
		this.uuid = uuid;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((businessType == null) ? 0 : businessType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UuidVO other = (UuidVO) obj;
		if (businessType == null) {
			if (other.businessType != null)
				return false;
		} else if (!businessType.equals(other.businessType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UuidVO [businessType=" + businessType + ", uuid=" + uuid + "]";
	}
	
	
}
