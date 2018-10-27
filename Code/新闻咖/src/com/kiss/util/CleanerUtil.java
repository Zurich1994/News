package com.kiss.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;


import java.nio.charset.Charset;
import java.util.List;

public class CleanerUtil {
    /*
     * @author shengjian
     * @function ���� ��Ѷ��������
     */
	
	public static void HandleNews(String urladd, String charset)
	{
		/*
		 //*[@id="listZone"]/div[1] //*[@id="listZone"]/div[1]/div/em/a //*[@id="listZone"]/div[1]/div/p
		  * //*[@id="listZone"]/div[1]/div/a/img
		  * //*[@id="listZone"]/div[4]/div/a/img
		  * //*[@id="listZone"]/div[1]/div/em/a
		  * //*[@id="listZone"]/div[2]/div/p
		  */
		 
		HtmlCleaner cleaner = new HtmlCleaner();
		try {
			URL url = new URL(urladd);
			TagNode node = cleaner.clean(url, charset);
			Object[] child = null;
			
			Object[] tagnodes = node.evaluateXPath("//*[@id='listZone']/div");
			for (Object tagNode : tagnodes){  
				
                //System.out.println(((TagNode)tagNode).getText());  
                //System.out.println(((TagNode)tagNode).getAttributeByName("src"));  
				child = ((TagNode)tagNode).evaluateXPath("//div/a/img");
				for (Object childNode : child)
				{
					//System.out.println(((TagNode)tagNode).getText());  
					System.out.println("ͼƬ��ַ:  "+((TagNode)childNode).getAttributeByName("src"));  
				}
				child = ((TagNode)tagNode).evaluateXPath("//div/em/a");
				for (Object childNode : child)
				{
					System.out.println(((TagNode)childNode).getText());  
					System.out.println("��ת��ַ:  "+"http://news.qq.com"+((TagNode)childNode).getAttributeByName("href"));  
				}
				child = ((TagNode)tagNode).evaluateXPath("//div/p");
				for (Object childNode : child)
				{
					System.out.println(((TagNode)childNode).getText());  
					//System.out.println(((TagNode)childNode).getAttributeByName("href"));  
				}
				System.out.println("------------------��������-----------------------");
				
				
			}  
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPatherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
