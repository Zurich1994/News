package com.kiss.util;

import com.kiss.domain.Constants;

public class UrlUtil {
//	String path = "http://192.168.22.1:8080/SuperServer/DisNewsService?category=3&page=2";
	public static String NEWS_LIST_URL = "http://192.168.22.1:8080/SuperServer/DisNewsService?";
	
	
	
	/*public static String getNewsListURL(String page){
		return NEWS_LIST_URL + "/" + page;
	}
	public static String getRefreshNewsURl(){
		return NEWS_LIST_URL;
	}*/
	
	/*public static String getNewsListURLYiDong(String page){
		return NEWS_LIST_URL_YIDONG + "/" + page;
	}
	public static String getRefreshNewsURLYiDong(){
		return NEWS_LIST_URL_YIDONG + "/1";
	}
	
	public static String getNewsListURLYanFa(String page){
		return NEWS_LIST_URL_YANFA + "/" + page;
	}
	public static String getRefreshNewsURLYanFa(){
		return NEWS_LIST_URL_YANFA + "/1";
	}*/
	
	
	public static String getNewsListURL(int newsType, int page){
		String url = "";
		
		url = NEWS_LIST_URL+"category="+newsType+"&page="+page;
		return url;
	}
	public static String getRefreshNewsListURL(int newsType){
		String url = "";
		url = NEWS_LIST_URL+"category="+newsType+"&page=0";
		return url;
	}
	
	public static String getCommnetListURL(String url, String page){
		return "http://ptcms.csdn.net/comment/comment/newest?url=" + url + "&pageno=" + page + "&pagesize=50";
	}
}
