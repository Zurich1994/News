package com.kiss.domain;

public class Page {
	public int page = 1;
	public int contentMutiPages;
	public boolean contentFirstPage = true;
	
	public void setPageStart(){
		page = 1;
	}
	public void setPage(int num){
		page = num;
	}
	public int getCurrentPage(){
		return page;
	}
	public  void addPage(){
		page ++;
	}
	
	
}
