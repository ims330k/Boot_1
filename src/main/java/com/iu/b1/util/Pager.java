package com.iu.b1.util;

import org.springframework.beans.factory.annotation.Value;

public class Pager {

	private Integer start;
	private Integer per;
	private String kind;
	private String search;
	
	private Integer startNum; //시작 번호
	private Integer lastNum; //끝 번호
	private Integer curBlock; //현재 블럭 번호
	private Integer totalBlock; //전체 블럭 갯수
	
	private Integer startRow;//시작 rownum
	private Integer lastRow;//시작 rownum
		
public void makePage(int totalCount) {
		
		//2.전체 페이지 수 구하지
		int totalPage = totalCount / this.getPer();
		if(totalCount%this.getPer() != 0)
			totalPage++;
		
		//3.전체 블럭 수 구하기
		int perBlock = 5;
		totalBlock = totalPage / perBlock;
		if(totalPage%perBlock != 0 )
			totalBlock++;
		
		//4.curPage로 curBlock 구하기
		curBlock = this.getCurBlock() / perBlock;
		if(this.getCurBlock() % perBlock != 0) {
			curBlock++;
		}
		//5. curBlock으로 startNum, lastNum
		
		startNum = (curBlock-1)*perBlock +1;
		lastNum = curBlock*perBlock;
		
		if(curBlock == totalBlock)
			lastNum = totalPage;
	}
	
	
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getLastRow() {
		return lastRow;
	}
	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}
	
	public Integer getStart() {
		if(start==null) {
			start=0;
		}
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getPer() {
		if(per==null || per==0) {
			per=10;
		}
		return per;
	}
	public void setPer(Integer per) {
		this.per = per;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getLastNum() {
		return lastNum;
	}
	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}
	public Integer getCurBlock() {
		if(curBlock==null || curBlock==0) {
			curBlock=1;
		}
		return curBlock;
	}
	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
	
	
	
	
	
}
