package com.kiss.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatasourceBean {

	//private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
    //protected static  final String url = "jdbc:mysql://127.0.0.1:3306/lecture";
       protected static  final String url = "jdbc:mysql://127.0.0.1:3306/news?characterEncoding=utf8";
    protected static final String  username = "root";
    protected static final String password = "";
    protected static Connection conn;
    static {
   	 try{
   		Class.forName("com.mysql.jdbc.Driver");
   		System.out.println("加载数据库驱动...");
   	 }catch(ClassNotFoundException e){
   		 e.printStackTrace();
   	 }
    }
    public static Connection getConnection(){
   	 try {
			if(!conn.isClosed()){
                           
				 return conn;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 return null;
    }
    public static  boolean openConn(boolean autoCommit){
   	 boolean isOpen = true;
   	 try {
			conn = DriverManager.getConnection(url, username, password);
			if(!autoCommit){conn.setAutoCommit(false);}
                       System.out.println("打开数据库...");
		} catch (SQLException e) {
			isOpen = false;
                       //非auto commit时出现异常要处理回滚
                       if(!autoCommit){
                               if(conn!=null){  
                                   try {  
                                       conn.rollback();  
                                   } catch (SQLException e1) {  
                                       e1.printStackTrace();  
                                   }  
                               }  
                       }
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 return isOpen;
    }
    
    public static boolean closeConn(){
   	 boolean isCommit = true;
   	 try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				conn.close();
                                System.out.println("关闭数据库...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   	 return isCommit;
    }
    
    public static int genRondom(int max,int min){
     return (int)Math.round(Math.random()*(max-min)+min);
    }
}
