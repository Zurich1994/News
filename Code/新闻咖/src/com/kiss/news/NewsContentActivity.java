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
        //����WebView���ԣ��ܹ�ִ��Javascript�ű� 
        webview.getSettings().setJavaScriptEnabled(true); 
        //������Ҫ��ʾ����ҳ 
        webview.loadUrl(url); 
        //����Web��ͼ 
        webview.setWebViewClient(new HelloWebViewClient ()); 
    } 
     
	
    //Web��ͼ 
    private class HelloWebViewClient extends WebViewClient { 
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            view.loadUrl(url); 
            return true; 
        } 
    
		
	}
    
}

