package com.news.Util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;


public class NetUtil {
	public String Xmltext = null;
	
	public static InputStream getNewsXml()
	{
		
		//String Xmltext = null;
		
		String path = "http://news.baidu.com/n?cmd=1&class=civilnews&tn=rss";
		try {
							
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			//conn.setDoOutput(true);
			conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			//conn.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
			int code = conn.getResponseCode();
			if(code==200)
			{
					System.out.println("code:  "+code);
					//Xmltext = StreamUtil.getText(conn.getInputStream());
					//System.out.println("Xmltext:  "+Xmltext);
					System.out.println("请求成功");
					//return Xmltext;			
					return conn.getInputStream();
			}else{
						 System.out.println("code:  "+code+"--------请求失败");
						 return null;
							}
							
					} catch (Exception e) {
						// TODO Auto-generated catch block
							e.printStackTrace();
							return null;
						}
						
					}
				
				
		
		
	}

