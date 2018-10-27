package com.news.Util;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.news.domain.ImageInfo;
import com.news.domain.Info;
import com.news.domain.PassageInfo;

public class DownloadService {

	// comId代表下次起始刷新的ID
	/*
	 * 1 代表国内 2 代表国际 3 代表社会
	 */

	// 取国内新闻
	public static void downloadNewsChina() {
		// 用于比较的title

		String comTitle;
		List<Info> list = null;
		CleanerUtil cleaner = new CleanerUtil();
		comTitle = getTitle(1);
		String url = "http://news.qq.com/c/816guonei_";
		// list = cleaner.HandleNews("http://news.qq.com/c/816guonei_1.htm?",
		// "gb2312");
		for (int i = 1; i <= 3; i++) {
			try {
				String newUrl = url + String.valueOf(i) + ".htm?";
				System.out.println("拼接的url地址----------" + newUrl);
				list = cleaner.HandleNews(newUrl, "gb2312");
				System.out.println("到这了" + list.size());
				for (Info info : list) {
					System.out.println(info.getTitle());
					System.out.println(info.getImglink());
					System.out.println(info.getLink());
					System.out.println(info.getDescription());
				}
				System.out.println("结尾,开始转存 到数据库");
				MysqlManger.insertNews(list, comTitle, 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// cleaner.HandleNews("http://news.qq.com/c/816shehui_1.htm?",
		// "gb2312");
		// DatesourceBean.openConn(false);

	}

	// 取国际新闻
	public static void downloadNewsInternational() {
		// 用于比较的title

		String comTitle;
		List<Info> list = null;
		CleanerUtil cleaner = new CleanerUtil();
		comTitle = getTitle(2);
		String url = "http://news.qq.com/c/816guoji_";
		// list = cleaner.HandleNews("http://news.qq.com/c/816guonei_1.htm?",
		// "gb2312");
		for (int i = 1; i <= 3; i++) {
			try {
				String newUrl = url + String.valueOf(i) + ".htm?";
				System.out.println("国际拼接的url地址----------" + newUrl);
				list = cleaner.HandleNews(newUrl, "gb2312");
				System.out.println("到这了" + list.size());
				for (Info info : list) {
					System.out.println(info.getTitle());
					System.out.println(info.getImglink());
					System.out.println(info.getLink());
					System.out.println(info.getDescription());
				}
				System.out.println("结尾,开始转存 到数据库");
				MysqlManger.insertNews(list, comTitle, 2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// cleaner.HandleNews("http://news.qq.com/c/816shehui_1.htm?",
		// "gb2312");
		// DatesourceBean.openConn(false);

	}

	// 取社会新闻
	public static void downloadNewsSociety() {
		// 用于比较的title

		String comTitle;
		List<Info> list = null;
		CleanerUtil cleaner = new CleanerUtil();
		comTitle = getTitle(3);
		String url = "http://news.qq.com/c/816shehui_";
		// list = cleaner.HandleNews("http://news.qq.com/c/816shehui_1.htm?",
		// "gb2312");
		for (int i = 1; i <= 3; i++) {
			try {
				String newUrl = url + String.valueOf(i) + ".htm?";
				System.out.println("拼接的url地址----------" + newUrl);
				list = cleaner.HandleNews(newUrl, "gb2312");
				System.out.println("到这了" + list.size());
				for (Info info : list) {
					System.out.println(info.getTitle());
					System.out.println(info.getImglink());
					System.out.println(info.getLink());
					System.out.println(info.getDescription());
				}
				System.out.println("结尾,开始转存 到数据库");
				MysqlManger.insertNews(list, comTitle, 3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// cleaner.HandleNews("http://news.qq.com/c/816shehui_1.htm?",
		// "gb2312");
		// DatesourceBean.openConn(false);

	}

	// 取图说新闻
	public static void downloadImageNews() {
		// 用于比较的title

		String comTitle;
		List<ImageInfo> list = null;
		CleanerUtil cleaner = new CleanerUtil();
		comTitle = getTitle(4);
		String url = "http://news.qq.com/photon/tuhua/";
		// list = cleaner.HandleNews("http://news.qq.com/c/816shehui_1.htm?",
		// "gb2312");
		// http://news.qq.com/photon/tuhua/2.htm
		for (int i = 1; i <= 3; i++) {
			try {
				String newUrl = url + String.valueOf(i) + ".htm";
				if (i == 1)
					newUrl = "http://news.qq.com/photon/tuhua.htm";
				System.out.println("拼接的url地址----------" + newUrl);
				list = cleaner.HandleImages(newUrl, "gb2312");
				System.out.println("到这了" + list.size());
				for (ImageInfo info : list) {
					System.out.println("图片简介地址-------"
							+ info.getImgDescription());
					System.out.println("图片链接地址-------" + info.getImgLink());
					System.out.println("正文地址" + info.getLInk());

				}
				System.out.println("结尾,开始转存 到数据库");
				MysqlManger.insertImageNews(list, comTitle, 4);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// cleaner.HandleNews("http://news.qq.com/c/816shehui_1.htm?",
		// "gb2312");
		// DatesourceBean.openConn(false);

	}

	// 取图说新闻
	//http://view.news.qq.com/l/history_new/dsj/list20130813152200.htm
	//http://view.news.qq.com/l/history_new/dsj/list20130813152200_2.htm
	//http://view.news.qq.com/l/history_new/dsj/list20130813152200_3.htm
	public static void DownloadPassageNews() {
		// 用于比较的title

		String comTitle;
		List<PassageInfo> list = null;
		CleanerUtil cleaner = new CleanerUtil();
		comTitle = getTitle(5);
		String url = "http://view.news.qq.com/l/history_new/dsj/list20130813152200_";
		// list = cleaner.HandleNews("http://news.qq.com/c/816shehui_1.htm?",
		// "gb2312");
		// http://news.qq.com/photon/tuhua/2.htm
		for (int i = 1; i <= 3; i++) {
			try {
				String newUrl = url + String.valueOf(i) + ".htm";
				if (i == 1)
					newUrl = "http://view.news.qq.com/l/history_new/dsj/list20130813152200.htm";
				System.out.println("拼接的url地址----------" + newUrl);
				list = cleaner.HandlePassages(newUrl, "gb2312");
				System.out.println("到这了" + list.size());
				for (PassageInfo info : list) {
					
					System.out.println("标题-------" + info.getTitle());
					System.out.println("正文地址" + info.getLink());

				}
				System.out.println("结尾,开始转存 到数据库");
				MysqlManger.insertPassageNews(list, comTitle, 5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// cleaner.HandleNews("http://news.qq.com/c/816shehui_1.htm?",
		// "gb2312");
		// DatesourceBean.openConn(false);

	}

	/*
	 * 取出数据库特定category 最末尾的标题 目的是为了防止重复重复加新闻到数据库
	 */
	public static String getTitle(int category) {
		String title = "";
		if (DatasourceBean.openConn(false)) {

			try {
				String sql = "select * from newsinfo where category = "
						+ category;
				PreparedStatement pst;
				pst = DatasourceBean.getConnection().prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					if (rs.isFirst()) {
						title = rs.getString("title");
						System.out.println("最开始的标题----------" + title);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("找标题出现错误");
				e.printStackTrace();
			}
			DatasourceBean.closeConn();
		}
		return title;

	}
}
