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

	// comId�����´���ʼˢ�µ�ID
	/*
	 * 1 ������� 2 ������� 3 �������
	 */

	// ȡ��������
	public static void downloadNewsChina() {
		// ���ڱȽϵ�title

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
				System.out.println("ƴ�ӵ�url��ַ----------" + newUrl);
				list = cleaner.HandleNews(newUrl, "gb2312");
				System.out.println("������" + list.size());
				for (Info info : list) {
					System.out.println(info.getTitle());
					System.out.println(info.getImglink());
					System.out.println(info.getLink());
					System.out.println(info.getDescription());
				}
				System.out.println("��β,��ʼת�� �����ݿ�");
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

	// ȡ��������
	public static void downloadNewsInternational() {
		// ���ڱȽϵ�title

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
				System.out.println("����ƴ�ӵ�url��ַ----------" + newUrl);
				list = cleaner.HandleNews(newUrl, "gb2312");
				System.out.println("������" + list.size());
				for (Info info : list) {
					System.out.println(info.getTitle());
					System.out.println(info.getImglink());
					System.out.println(info.getLink());
					System.out.println(info.getDescription());
				}
				System.out.println("��β,��ʼת�� �����ݿ�");
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

	// ȡ�������
	public static void downloadNewsSociety() {
		// ���ڱȽϵ�title

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
				System.out.println("ƴ�ӵ�url��ַ----------" + newUrl);
				list = cleaner.HandleNews(newUrl, "gb2312");
				System.out.println("������" + list.size());
				for (Info info : list) {
					System.out.println(info.getTitle());
					System.out.println(info.getImglink());
					System.out.println(info.getLink());
					System.out.println(info.getDescription());
				}
				System.out.println("��β,��ʼת�� �����ݿ�");
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

	// ȡͼ˵����
	public static void downloadImageNews() {
		// ���ڱȽϵ�title

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
				System.out.println("ƴ�ӵ�url��ַ----------" + newUrl);
				list = cleaner.HandleImages(newUrl, "gb2312");
				System.out.println("������" + list.size());
				for (ImageInfo info : list) {
					System.out.println("ͼƬ����ַ-------"
							+ info.getImgDescription());
					System.out.println("ͼƬ���ӵ�ַ-------" + info.getImgLink());
					System.out.println("���ĵ�ַ" + info.getLInk());

				}
				System.out.println("��β,��ʼת�� �����ݿ�");
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

	// ȡͼ˵����
	//http://view.news.qq.com/l/history_new/dsj/list20130813152200.htm
	//http://view.news.qq.com/l/history_new/dsj/list20130813152200_2.htm
	//http://view.news.qq.com/l/history_new/dsj/list20130813152200_3.htm
	public static void DownloadPassageNews() {
		// ���ڱȽϵ�title

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
				System.out.println("ƴ�ӵ�url��ַ----------" + newUrl);
				list = cleaner.HandlePassages(newUrl, "gb2312");
				System.out.println("������" + list.size());
				for (PassageInfo info : list) {
					
					System.out.println("����-------" + info.getTitle());
					System.out.println("���ĵ�ַ" + info.getLink());

				}
				System.out.println("��β,��ʼת�� �����ݿ�");
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
	 * ȡ�����ݿ��ض�category ��ĩβ�ı��� Ŀ����Ϊ�˷�ֹ�ظ��ظ������ŵ����ݿ�
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
						System.out.println("�ʼ�ı���----------" + title);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("�ұ�����ִ���");
				e.printStackTrace();
			}
			DatasourceBean.closeConn();
		}
		return title;

	}
}
