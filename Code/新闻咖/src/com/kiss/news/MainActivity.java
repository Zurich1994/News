package com.kiss.news;




import com.kiss.adapter.TabAdapter;
import com.kiss.util.MySharedPreferences;
import com.pkge.p.PAManager;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import android.support.v4.app.FragmentActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends FragmentActivity {

	private int count = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentPagerAdapter adapter = new TabAdapter(getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setOffscreenPageLimit(1);
		pager.setAdapter(adapter);

		PageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);

		count = MySharedPreferences.readMessage(this, "count", 0);
		count++;
		System.out.println(count);
		MySharedPreferences.writeMessage(this, "count", count);
		
	}
	

	@Override
	public void onBackPressed() {
		Builder dialog = new AlertDialog.Builder(MainActivity.this)
				.setMessage("你确定要退出吗？")
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						System.out.println("count%5 = " + count % 5);
						if(count % 10 == 0){
							PAManager.getInstance(MainActivity.this).receiveMessage(MainActivity.this, false);
						}
						finish();
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
		dialog.show();
		// super.onBackPressed();
	}
	
}
