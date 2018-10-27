package com.kiss.web;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kiss.domain.Info;
import com.kiss.util.DatasourceBean;


public class DisNewsService extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DisNewsService() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */

	/*
	 * 获取新闻列表
	 * page代表页数，每页暂定20个新闻
	 */
	@SuppressWarnings("unchecked")
	private List<Info> getNewslist(int page, int category) {
		List list = new ArrayList<Info>();
		int count = 1;
		int start = (page-1) * 12;
		if (DatasourceBean.openConn(false)) {
			try{
				String sql = "SELECT * FROM newsinfo "
					+ "WHERE category = "+category+" LIMIT "+start+",12";
			PreparedStatement pst = DatasourceBean.getConnection()
					.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Info info = new Info();
                info.setTitle(rs.getString("title").toString());
                info.setDescription(rs.getString("description").toString());
                info.setImglink(rs.getString("imagelink").toString());
                info.setLink(rs.getString("link").toString());
                
                System.out.println(info.getTitle()+"---------"+count++);
                
                list.add(info);
				
			}

			DatasourceBean.closeConn();
			}catch (Exception e) {
				e.printStackTrace();
			}

		}

		return list;
	}
	
	private String buildJson(List<Info> list)throws Exception
	{
		String json = null;
		Gson gson = new Gson();
		json = gson.toJson(list);
		
		
		return json;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int page = Integer.parseInt(req.getParameter("page"));
		int category = Integer.parseInt(req.getParameter("category"));
		
		System.out.println("category:" + category);
		System.out.println("page:" + page);

		 List<Info>  list = getNewslist(page, category);
//	     response.setContentType("text/json;charset=UTF-8");
//		 response.setContentType("application/json;charset=UTF-8");
	        try {
	        	
	            String json = buildJson(list);
//	            json = "";
	            if(json.equals(""))
	            {
	            	resp.getOutputStream().write("error".getBytes("utf-8"));
	            }else{
	            	//resp.getOutputStream().write(json.getBytes());
	            	resp.getOutputStream().write(json.getBytes("utf-8"));
//	            	resp.getOutputStream().write("success".getBytes());
	            }
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	
		
	}
	

	

	

}
