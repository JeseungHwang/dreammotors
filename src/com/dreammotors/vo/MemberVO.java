package com.dreammotors.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVO {
	private String memId;
	private String memPw;
	private String memPermission;
	private String positionName;
	private String memName;
	private String memNick;
	private String memEmail;
	private String memTell;
	private String memAddr;
	private String memRegDateTime;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemPermission() {
		return memPermission;
	}
	public void setMemPermission(String memPermission) {
		this.memPermission = memPermission;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemNick() {
		return memNick;
	}
	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemTell() {
		return memTell;
	}
	public void setMemTell(String memTell) {
		this.memTell = memTell;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public String getMemRegDateTime() {
		return memRegDateTime;
	}
	public void setMemRegDateTime(Date memRegDateTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.memRegDateTime = format.format(memRegDateTime);
	}
		
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPw=" + memPw + ", memPermission=" + memPermission + ", positionName="
				+ positionName + ", memName=" + memName + ", memNick=" + memNick + ", memEmail=" + memEmail
				+ ", memTell=" + memTell + ", memAddr=" + memAddr + ", memRegDateTime=" + memRegDateTime + "]";
	}
	
}
