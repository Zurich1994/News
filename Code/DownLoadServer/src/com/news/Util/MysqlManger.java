package com.news.Util;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.news.domain.ImageInfo;
import com.news.domain.Info;
import com.news.domain.PassageInfo;

public class MysqlManger {

	public static void insertNews(List<Info> list,String comTitle,int category) throws UnsupportedEncodingException
	{
		//String lastTitle = getTitle(1);
		if(DatasourceBean.openConn(false)){
			
			for(Info info : list){
				try {
					//int defaultCount = 10;
					//System.out.print("xxx"+info.getTitle());
					String tmp = info.getTitle();
					String tmp2 = info.getDescription();
					
					
		            String title = new String(info.getTitle().getBytes(),"UTF-8");
					//String title = new String(info.getTitle().getBytes(),"UTF-8");
					String imgLink = info.getImglink();
		            String link = info.getLink();
		            //String description = info.getDescription();
		            String description = new String(info.getDescription().getBytes(),"UTF-8");
		            //int category = 1;
		            
		            
		            
//		           /****************************************/
//		            System.out.println("??"+title);
//		            title = new String(tmp.getBytes(),"UTF-16");
//		            title = new String("发士大夫".getBytes(),"UTF-8");
//		            description = new String(tmp2.getBytes(),"UTF-16");
					//title =new String("撒师是电风扇傅".getBytes("UTF-8"),"UTF-8");
		            description = tmp2;
		            title = tmp;
		            
		            //如果已经插入到最后一个了停止插入
		            if(comTitle.equals(title))
		            	break;
		            
		            
		            String sql = "insert into newsinfo(title,description,imagelink,category,link) values ('"+title+"','"+description+"','"+imgLink+"','"+category+"','"+link+"')";
					PreparedStatement pst;
					pst = DatasourceBean.getConnection().prepareStatement(sql);
					//pst.setInt(1, defaultCount);
					pst.executeUpdate();
					
					/*sql = "select * from newsinfo";
					pst = DatasourceBean.getConnection().prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while(rs.next()){
                        Info newinfo = new Info();
                        newinfo.setTitle(rs.getString("title").toString());
                        
                        System.out.println(newinfo.getTitle());
                     }*/
					System.out.println("存入成功");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			DatasourceBean.closeConn();
			
			
	
		}
	}
	
	public static void insertImageNews(List<ImageInfo> list,String comTitle,int category) throws UnsupportedEncodingException
	{
if(DatasourceBean.openConn(false)){
			
			for(ImageInfo info : list){
				try {
					//int defaultCount = 10;
					//System.out.print("xxx"+info.getTitle());
					
					String tmp2 = info.getImgDescription();
					
					
		            
					//String title = new String(info.getTitle().getBytes(),"UTF-8");
					String imgLink = info.getImgLink();
		            String link = info.getLInk();
		            //String description = info.getDescription();
		            String description = new String(info.getImgDescription().getBytes(),"UTF-8");
		            //int category = 1;
		            
		            
		            
//		           /****************************************/
//		            System.out.println("??"+title);
//		            title = new String(tmp.getBytes(),"UTF-16");
//		            title = new String("发士大夫".getBytes(),"UTF-8");
//		            description = new String(tmp2.getBytes(),"UTF-16");
					//title =new String("撒师是电风扇傅".getBytes("UTF-8"),"UTF-8");
		            description = tmp2;
		          
		            //如果已经插入到最后一个了停止插入
		           /* if(comTitle.equals(title))
		            	break;
		            */
		            
		            String sql = "insert into newsinfo(title,description,imagelink,category,link) values ('imgtitle','"+description+"','"+imgLink+"','"+category+"','"+link+"')";
					PreparedStatement pst;
					pst = DatasourceBean.getConnection().prepareStatement(sql);
					//pst.setInt(1, defaultCount);
					pst.executeUpdate();
					
					/*sql = "select * from newsinfo";
					pst = DatasourceBean.getConnection().prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while(rs.next()){
                        Info newinfo = new Info();
                        newinfo.setTitle(rs.getString("title").toString());
                        
                        System.out.println(newinfo.getTitle());
                     }*/
					System.out.println("存入成功");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			DatasourceBean.closeConn();
		}
	}
	
	public static void insertPassageNews(List<PassageInfo> list,String comTitle,int category) throws UnsupportedEncodingException
	{
		//String lastTitle = getTitle(1);
		if(DatasourceBean.openConn(false)){
			
			for(PassageInfo info : list){
				try {
					//int defaultCount = 10;
					//System.out.print("xxx"+info.getTitle());
					String tmp = info.getTitle();
					
					
					
		            String title = new String(info.getTitle().getBytes(),"UTF-8");
					//String title = new String(info.getTitle().getBytes(),"UTF-8");
					
		            String link = info.getLink();
		            //String description = info.getDescription();
		            
		            //int category = 1;
		            
		            
		            
//		           /****************************************/
//		            System.out.println("??"+title);
//		            title = new String(tmp.getBytes(),"UTF-16");
//		            title = new String("发士大夫".getBytes(),"UTF-8");
//		            description = new String(tmp2.getBytes(),"UTF-16");
					//title =new String("撒师是电风扇傅".getBytes("UTF-8"),"UTF-8");
		            
		            title = tmp;
		            
		            //如果已经插入到最后一个了停止插入
		            if(comTitle.equals(title))
		            	break;
		            
		            
		            String sql = "insert into newsinfo(title,description,imagelink,category,link) values ('"+title+"','passageDes','passageImglink','"+category+"','"+link+"')";
					PreparedStatement pst;
					pst = DatasourceBean.getConnection().prepareStatement(sql);
					//pst.setInt(1, defaultCount);
					pst.executeUpdate();
					
					/*sql = "select * from newsinfo";
					pst = DatasourceBean.getConnection().prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while(rs.next()){
                        Info newinfo = new Info();
                        newinfo.setTitle(rs.getString("title").toString());
                        
                        System.out.println(newinfo.getTitle());
                     }*/
					System.out.println("存入成功");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			DatasourceBean.closeConn();
			
			
	
		}
	}
	
}
