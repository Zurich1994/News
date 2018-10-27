package com.kiss.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class HttpService {

	public static String getJson(int page,int category)
	{
		//ƴװpath
//		String path = "http://192.168.22.1:8080/SuperServer/DisNewsService?category=3&page=2";
		String path = "http://192.168.22.1:8080/SuperServer/DisNewsService?page="+page+"&category="+category;
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			
			int code = conn.getResponseCode();
			if(code==200)
			{
				InputStream is = conn.getInputStream();
				String json = StreamDeal.StreamData(is);
				
				return json;
				
			}else{
				return null;
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return null;
	}
}
