package com.kiss.util;

import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kiss.domain.Info;


public class JsonUtil {
	
	public static List<Info> getNewsList(String json)
	{
		List list = new ArrayList<Info>();
		Gson gson = new Gson();
		TypeToken <List<Info>> tt = new TypeToken <List<Info>>(){};
		List<Info> infos;
		try {
			infos = gson.fromJson(new String(json.getBytes(),"UTF-8"),tt.getType());
			//System.out.println(info);
			for(Info info : infos)
			{
				System.out.println(info.getTitle());
				System.out.println(info.getDescription());
				System.out.println(info.getImglink());
				System.out.println(info.getLink());
				list.add(info);
				System.out.println("--------------添加此新闻成功----------------");
				
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	
		
	
}
}
