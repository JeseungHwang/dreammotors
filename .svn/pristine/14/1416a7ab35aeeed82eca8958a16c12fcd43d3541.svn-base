package com.dreammotors.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardCommentVO {
	private int boardIndex;
	private int bcmtOrder;
	private String memId;
	private String bcmtRegName;
	private String bcmtContext;
	private String bcmtRegDatetime;
	public int getBoardIndex() {
		return boardIndex;
	}
	public void setBoardIndex(int boardIndex) {
		this.boardIndex = boardIndex;
	}
	public int getBcmtOrder() {
		return bcmtOrder;
	}
	public void setBcmtOrder(int bcmtOrder) {
		this.bcmtOrder = bcmtOrder;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getBcmtRegName() {
		return bcmtRegName;
	}
	public void setBcmtRegName(String bcmtRegName) {
		this.bcmtRegName = bcmtRegName;
	}
	public String getBcmtContext() {
		return bcmtContext;
	}
	public void setBcmtContext(String bcmtContext) {
		this.bcmtContext = bcmtContext;
	}
	public String getBcmtRegDatetime() {
		return bcmtRegDatetime;
	}
	public void setBcmtRegDatetime(Date bcmtRegDatetime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.bcmtRegDatetime = format.format(bcmtRegDatetime);
	}
	@Override
	public String toString() {
		return "BoardCommentVO [boardIndex=" + boardIndex + ", bcmtOrder=" + bcmtOrder + ", memId=" + memId
				+ ", bcmtRegName=" + bcmtRegName + ", bcmtContext=" + bcmtContext
				+ ", bcmtRegDatetime=" + bcmtRegDatetime + "]";
	}
}
