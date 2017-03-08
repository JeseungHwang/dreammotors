package com.dreammotors.vo;

public class FamilyVO {
	private int cmemIndex; 
	private String cmemName;
	private String cmemImgUrl;
	private int positionId;
	private String positionName;
	
	public int getCmcmIndex() {
		return cmemIndex;
	}
	public void setCmcmIndex(int cmemIndex) {
		this.cmemIndex = cmemIndex;
	}
	public String getCmemName() {
		return cmemName;
	}
	public void setCmemName(String cmemName) {
		this.cmemName = cmemName;
	}
	public String getCmemImgUrl() {
		return cmemImgUrl;
	}
	public void setCmemImgUrl(String cmemImgUrl) {
		this.cmemImgUrl = cmemImgUrl;
	}
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	@Override
	public String toString() {
		return "FamilyVO [cmemIndex=" + cmemIndex + ", cmemName=" + cmemName + ", cmemImgUrl=" + cmemImgUrl
				+ ", positionId=" + positionId + ", positionName=" + positionName + "]";
	}
	
}
