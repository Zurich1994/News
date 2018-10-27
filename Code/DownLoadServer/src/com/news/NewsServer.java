package com.news;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.news.Util.CleanerUtil;
import com.news.Util.DatasourceBean;
import com.news.Util.DownloadService;
import com.news.Util.MysqlManger;
import com.news.Util.NetUtil;
import com.news.Util.XmlUtil;
import com.news.domain.Info;
import com.news.domain.Newsinfo;

public class NewsServer {

	private static InputStream is;
	private static List<Newsinfo> list;
	public static void main(String args[]) throws UnsupportedEncodingException
	{
		/*
		 * http://news.qq.com/c/816guonei_4.htm?0.1666789879091084
		 * */
		/*is = NetUtil.getNewsXml();
		//System.out.println(news);
		//实例化一个xmlutil对象
		XmlUtil xmlutil = new XmlUtil();
		list = xmlutil.getNews(is);
		for(Newsinfo info : list)
		{
			System.out.println(info.toString());
		}
		*/
		
		//cleaner.HandleNews("http://news.qq.com/china_index.shtml", "gb2312");
		//国内
		
		DownloadService.downloadNewsChina();
		DownloadService.downloadNewsInternational();
		DownloadService.downloadNewsSociety();
		DownloadService.downloadImageNews();
		DownloadService.DownloadPassageNews();
		
	}
}
