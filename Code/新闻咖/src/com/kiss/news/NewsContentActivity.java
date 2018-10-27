package com.kiss.news;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsContentActivity extends Activity{

	public static String url;
	private WebView webview;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().requestFeature(Window.FEATURE_PROGRESS);  
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_content);
		
		url = getIntent().getExtras().getString("newsLink");
		System.out.println("url:--------------"+url);
		webview = (WebView) findViewById(R.id.webview); 
        //设置WebView属性，能够执行Javascript脚本 
        webview.getSettings().setJavaScriptEnabled(true); 
        //加载需要显示的网页 
        webview.loadUrl(url); 
        //设置Web视图 
        webview.setWebViewClient(new HelloWebViewClient ()); 
    } 
     
	
    //Web视图 
    private class HelloWebViewClient extends WebViewClient { 
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            view.loadUrl(url); 
            return true; 
        } 
    
		
	}
    
}

