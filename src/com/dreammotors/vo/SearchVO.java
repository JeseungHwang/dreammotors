package com.dreammotors.vo;

public class SearchVO {
	String btype;
	String stype;
	String cntnt;
	int spage;
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getCntnt() {
		return cntnt;
	}
	public void setCntnt(String cntnt) {
		this.cntnt = cntnt;
	}
	public int getSpage() {
		return spage;
	}
	public void setSpage(int spage) {
		this.spage = spage;
	}
	@Override
	public String toString() {
		return "SearchVO [btype=" + btype + ", stype=" + stype + ", cntnt=" + cntnt + ", spage=" + spage + "]";
	}
	
	
}
