package com.dreammotors.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {
	private int boardIndex;
	private String boardTitle;
	private int boardIsNotice;
	private int boardIsPrivate;
	private String boardContext;
	private String boardRegName;
	private String boardRegPW;
	private String boardTell;
	private int boardViewCnt;
	private String boardImgUrl;
	private String boardRegDatetime;
	private String boardModifyDatetime;
	
	private String memId;
	private String memName;
	
	private String bTypeId;
	private String bTypeName;
	public int getBoardIndex() {
		return boardIndex;
	}
	public void setBoardIndex(int boardIndex) {
		this.boardIndex = boardIndex;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public int getBoardIsNotice() {
		return boardIsNotice;
	}
	public void setBoardIsNotice(int boardIsNotice) {
		this.boardIsNotice = boardIsNotice;
	}
	public int getBoardIsPrivate() {
		return boardIsPrivate;
	}
	public void setBoardIsPrivate(int boardIsPrivate) {
		this.boardIsPrivate = boardIsPrivate;
	}
	public String getBoardContext() {
		return boardContext;
	}
	public void setBoardContext(String boardContext) {
		this.boardContext = boardContext;
	}
	public String getBoardRegName() {
		return boardRegName;
	}
	public void setBoardRegName(String boardRegName) {
		this.boardRegName = boardRegName;
	}
	public String getBoardRegPW() {
		return boardRegPW;
	}
	public void setBoardRegPW(String boardRegPW) {
		this.boardRegPW = boardRegPW;
	}
	public String getBoardTell() {
		return boardTell;
	}
	public void setBoardTell(String boardTell) {
		this.boardTell = boardTell;
	}
	public int getBoardViewCnt() {
		return boardViewCnt;
	}
	public void setBoardViewCnt(int boardViewCnt) {
		this.boardViewCnt = boardViewCnt;
	}
	public String getBoardImgUrl() {
		return boardImgUrl;
	}
	public void setBoardImgUrl(String boardImgUrl) {
		this.boardImgUrl = boardImgUrl;
	}
	public String getBoardRegDatetime() {
		return boardRegDatetime;
	}
	public void setBoardRegDatetime(Date boardRegDatetime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.boardRegDatetime = format.format(boardRegDatetime);
	}
	public String getBoardModifyDatetime() {
		return boardModifyDatetime;
	}
	public void setBoardModifyDatetime(Date boardModifyDatetime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.boardModifyDatetime = format.format(boardModifyDatetime);
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getbTypeId() {
		return bTypeId;
	}
	public void setbTypeId(String bTypeId) {
		this.bTypeId = bTypeId;
	}
	public String getbTypeName() {
		return bTypeName;
	}
	public void setbTypeName(String bTypeName) {
		this.bTypeName = bTypeName;
	}
	@Override
	public String toString() {
		return "BoardVO [boardIndex=" + boardIndex + ", boardTitle=" + boardTitle + ", boardIsNotice=" + boardIsNotice
				+ ", boardIsPrivate=" + boardIsPrivate + ", boardContext=" + boardContext + ", boardRegName="
				+ boardRegName + ", boardRegPW=" + boardRegPW + ", boardTell=" + boardTell + ", boardViewCnt="
				+ boardViewCnt + ", boardImgUrl=" + boardImgUrl + ", boardRegDatetime=" + boardRegDatetime
				+ ", boardModifyDatetime=" + boardModifyDatetime + ", memId=" + memId + ", memName=" + memName
				+ ", bTypeId=" + bTypeId + ", bTypeName=" + bTypeName + "]";
	}
}
