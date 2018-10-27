package com.news.Util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import com.news.domain.ImageInfo;
import com.news.domain.Info;
import com.news.domain.Newsinfo;
import com.news.domain.PassageInfo;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CleanerUtil {
     /*
     * @author shengjian
     * @function ���� ��Ѷ��������
     */
	
	public static List HandleNews(String urladd, String charset)
	{
		/*
		 //*[@id="listZone"]/div[1] //*[@id="listZone"]/div[1]/div/em/a //*[@id="listZone"]/div[1]/div/p
		  * //*[@id="listZone"]/div[1]/div/a/img
		  * //*[@id="listZone"]/div[4]/div/a/img
		  * //*[@id="listZone"]/div[1]/div/em/a
		  * //*[@id="listZone"]/div[2]/div/p
		  */
		List<Info> list = null;
		HtmlCleaner cleaner = new HtmlCleaner();
		try {
			list = new ArrayList<Info>();
			URL url = new URL(urladd);
			TagNode node = cleaner.clean(url, charset);
			Object[] child = null;
			
			Object[] tagnodes = node.evaluateXPath("//*[@id='listZone']/div");
			for (Object tagNode : tagnodes){  
				
				Info info = new Info();
                //System.out.println(((TagNode)tagNode).getText());  
                //System.out.println(((TagNode)tagNode).getAttributeByName("src"));  
				child = ((TagNode)tagNode).evaluateXPath("//div/a/img");
				for (Object childNode : child)
				{
					//System.out.println(((TagNode)tagNode).getText());  
					System.out.println("ͼƬ��ַ:  "+((TagNode)childNode).getAttributeByName("src")); 
					info.setImglink((String)((TagNode)childNode).getAttributeByName("src"));
				}
				child = ((TagNode)tagNode).evaluateXPath("//div/em/a");
				for (Object childNode : child)
				{
					System.out.println(((TagNode)childNode).getText()); 
					info.setTitle((String)((TagNode)childNode).getText().toString().trim());
					System.out.println("��ת��ַ:  "+"http://news.qq.com"+((TagNode)childNode).getAttributeByName("href"));  
					info.setLink("http://news.qq.com"+((TagNode)childNode).getAttributeByName("href"));
				}
				child = ((TagNode)tagNode).evaluateXPath("//div/p");
				for (Object childNode : child)
				{
					System.out.println(((TagNode)childNode).getText());  
					//System.out.println(((TagNode)childNode).getAttributeByName("href")); 
					info.setDescription((String)((TagNode)childNode).getText().toString().trim());
				}
				System.out.println("------------------��������-----------------------");
				list.add(info);
				
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
		return list;

		
	}
	public static List<ImageInfo> HandleImages(String urladd, String charset)
	{
		List<ImageInfo> list = null;
		HtmlCleaner cleaner = new HtmlCleaner();
		try {
			list = new ArrayList<ImageInfo>();
			URL url = new URL(urladd);
			TagNode node = cleaner.clean(url, charset);
			Object[] child = null;
			
			Object[] tagnodes = node.evaluateXPath("//table");
			System.out.println("--------------------Xpath������-------------------"+tagnodes.length);
			for (Object tagNode : tagnodes){  
				//System.out.println("--------------------��-------------------");
				ImageInfo info = new ImageInfo();
                //System.out.println(((TagNode)tagNode).getText());  
                //System.out.println(((TagNode)tagNode).getAttributeByName("src"));  
				child = ((TagNode)tagNode).evaluateXPath("//tbody/tr[1]/td/a/img");
				for (Object childNode : child)
				{
					//System.out.println(((TagNode)tagNode).getText());  
					System.out.println("ͼƬ��ַ:  "+((TagNode)childNode).getAttributeByName("src")); 
					info.setImgLink((String)((TagNode)childNode).getAttributeByName("src"));
				}
				child = ((TagNode)tagNode).evaluateXPath("//tbody/tr[1]/td/a");
				for (Object childNode : child)
				{
					
					System.out.println("��ת��ַ:  "+"http://news.qq.com"+((TagNode)childNode).getAttributeByName("href"));  
					info.setLInk("http://news.qq.com"+((TagNode)childNode).getAttributeByName("href"));
				}
				child = ((TagNode)tagNode).evaluateXPath("//tbody/tr[2]/td/a");
				for (Object childNode : child)
				{
					System.out.println(((TagNode)childNode).getText());  
					//System.out.println(((TagNode)childNode).getAttributeByName("href")); 
					info.setImgDescription((String)((TagNode)childNode).getText().toString().trim());
				}
				System.out.println("------------------��������-----------------------");
				if(info.getLInk()!=null)
					list.add(info);
				
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
		
		
		return list;
	}
	///html/body/div[3]/div[3]/div[1]/ul[1]/li[1]/a
	///html/body/div[3]/div[3]/div[1]/ul[1]/li[2]/a
	
	//html/body/div[3]/div[3]/div[1]/ul[2]/li[1]/a
	//������������
	public static List<PassageInfo> HandlePassages(String urladd, String charset)
	{
		List<PassageInfo> list = null;
		HtmlCleaner cleaner = new HtmlCleaner();
		try {
			list = new ArrayList<PassageInfo>();
			URL url = new URL(urladd);
			TagNode node = cleaner.clean(url, charset);
			Object[] child = null;
			//��ÿһ��С����
			Object[] tagnodes = node.evaluateXPath("//div[3]/div[3]/div[1]/ul");
			for (Object tagNode : tagnodes){  
				
				/*PassageInfo info = new PassageInfo();
                //System.out.println(((TagNode)tagNode).getText());  
                //System.out.println(((TagNode)tagNode).getAttributeByName("src"));  
				
				child = ((TagNode)tagNode).evaluateXPath("//a");
				for (Object childNode : child)
				{
					System.out.println(((TagNode)childNode).getText()); 
					info.setTitle((String)((TagNode)childNode).getText().toString().trim());
					System.out.println("��ת��ַ:  "+((TagNode)childNode).getAttributeByName("href"));  
					info.setLink(((TagNode)childNode).getAttributeByName("href"));
				}
				
				System.out.println("------------------��������-----------------------");
				list.add(info);*/
				Object[] chiletagnodes = ((TagNode)tagNode).evaluateXPath("//li");
				for (Object tagsonNode : chiletagnodes){  
					
	                //System.out.println(((TagNode)tagNode).getText());  
	                //System.out.println(((TagNode)tagNode).getAttributeByName("src"));  
					
					child = ((TagNode)tagsonNode).evaluateXPath("//a");
					for (Object childNode : child)
					{
						PassageInfo info = new PassageInfo();
						System.out.println(((TagNode)childNode).getText()); 
						info.setTitle((String)((TagNode)childNode).getText().toString().trim());
						System.out.println("��ת��ַ:  "+((TagNode)childNode).getAttributeByName("href"));  
						info.setLink(((TagNode)childNode).getAttributeByName("href"));
						list.add(info);
					}
					
					System.out.println("------------------��������-----------------------");
					
				}
				
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
		return list;
	}
	
	
}
