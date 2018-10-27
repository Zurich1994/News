package com.kiss.news;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.kiss.adapter.NewsListAdapter;
import com.kiss.domain.Constants;
import com.kiss.domain.Info;
import com.kiss.domain.Page;
import com.kiss.util.JsonUtil;
import com.kiss.util.SuperServer;
import com.kiss.util.UrlUtil;

import me.maxwin.view.IXListViewLoadMore;
import me.maxwin.view.IXListViewRefreshListener;
import me.maxwin.view.XListView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.style.SuperscriptSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class NewsFrag extends Fragment implements IXListViewRefreshListener, IXListViewLoadMore{
	private XListView newsListView;
	private NewsListAdapter adapter;
	private List<Info> list = null; 
	private boolean isLoad = false;
	private int newsType = 1;
	private Page page;
	
	private String refreshDate = "";
	
	//传栏目标记
	public NewsFrag(int newsTyle){
		this.newsType = newsTyle;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		init();
		
	//	newsListView.startRefresh();
		//newsListView.NotRefreshAtBegin();
		
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		initComponent();
		if(isLoad == false){
			isLoad = true;
			refreshDate = getDate();
			newsListView.setRefreshTime(refreshDate);
			//加载数据

			/*------------------------------------------------------------------*/
			list = new ArrayList<Info>();
			Info guonei = new Info();
			guonei.setTitle("故宫院长：20路摄像头全程记录“女模裸拍”");
			guonei.setDescription("今天上午，2015年旅游安全宣传咨询活动在故宫博物院举行。期间，故宫博物院院长单霁翔首次回应“女模裸拍”事件。");
			guonei.setImglink("http://img1.gtimg.com/news/pics/hv1/102/165/1861/121053702.jpg");
			guonei.setLink("http://news.qq.com/a/20150616/025600.htm");
			list.add(guonei);
			/*------------------------------------------------------------------*/
			
			adapter.setList(list);
			adapter.notifyDataSetChanged();
			
			newsListView.startRefresh();
			//newsListView.NotRefreshAtBegin();
		}else{
			newsListView.NotRefreshAtBegin();
		}
		
		System.out.println("onActivityCreate");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println("onCreateView");
		return inflater.inflate(R.layout.xlistview, null);
	}

	private void init(){
//		db = new DB(getActivity());
		adapter = new NewsListAdapter(getActivity()); 
//		PageUtil.setPageStart();
		page = new Page();
		page.setPageStart();
	}
	private void initComponent(){
		newsListView = (XListView) getView().findViewById(R.id.newsListView);
		newsListView.setAdapter(adapter);
		newsListView.setPullRefreshEnable(this);
		newsListView.setPullLoadEnable(this);
		newsListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Info item = (Info)adapter.getItem(arg2-1);
				Intent i = new Intent();
				i.setClass(getActivity(), NewsContentActivity.class);
				i.putExtra("newsLink", item.getLink());
				startActivity(i);
				getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_no);
				System.out.println(arg2);
			}
		});
	}
	private class MainTask extends AsyncTask<String, Void, Integer> {

		@Override
		protected Integer doInBackground(String... params) {
		//	List<Info> list = db.query(newsType);
			
			
			
			
			//List<Info> list = DataUtil.getInfoListYiDong(newsType, temp);
			
			List<Info> list = SuperServer.getNewsList(page.getCurrentPage(), newsType);
			if(list.size() == 0){
				return Constants.DEF_RESULT_CODE.NO_DATA;
			}
			if(params[1].equals("refresh")){
				adapter.setList(list);
				return Constants.DEF_RESULT_CODE.REFRESH;
			} 
			else{
				adapter.addList(list);
				return Constants.DEF_RESULT_CODE.LOAD;
			}
		}

		@Override
		protected void onPostExecute(Integer result) {
			adapter.notifyDataSetChanged();
			switch(result){
			case Constants.DEF_RESULT_CODE.ERROR:
				Toast.makeText(getActivity(), "网络信号不佳", Toast.LENGTH_LONG).show();
				newsListView.stopRefresh(getDate());
				newsListView.stopLoadMore();
				break;
			case Constants.DEF_RESULT_CODE.NO_DATA:
				Toast.makeText(getActivity(), "最后一页啦，看看别的吧", Toast.LENGTH_LONG).show();
				newsListView.stopLoadMore();
				break;
			case Constants.DEF_RESULT_CODE.REFRESH:
				newsListView.stopRefresh(getDate());
				
				System.out.println("insert");
				break;
			case Constants.DEF_RESULT_CODE.LOAD:
				newsListView.stopLoadMore();
//				page.addPage();
				System.out.println("page:--------"+page.getCurrentPage());
				break;
			}
			
			super.onPostExecute(result);
		}
		
		
	}
	@Override
	public void onLoadMore() {
		System.out.println("loadmore");
		page.addPage();
		System.out.println("onloadmore里面page:-------"+page.getCurrentPage());
		new MainTask().execute(UrlUtil.getNewsListURL(newsType, page.getCurrentPage()), "load");
	}
	
	@Override
	public void onRefresh() {
		System.out.println("refresh");
		page.setPageStart();
		new MainTask().execute(UrlUtil.getRefreshNewsListURL(newsType), "refresh");
	}
	public String getDate(){
		SimpleDateFormat sdf=new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA);  
	    return sdf.format(new java.util.Date()); 
	}

}
