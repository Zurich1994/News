package com.kiss.util;

import java.util.ArrayList;
import java.util.List;

import com.kiss.domain.Info;

public class SuperServer {

	public static List<Info> getNewsList(int page, int category)
	{
		List<Info> list = null;
		list = new ArrayList<Info>();
		String json = HttpService.getJson(page, category);
		list = JsonUtil.getNewsList(json);
		
		
		return list;
	}
}
