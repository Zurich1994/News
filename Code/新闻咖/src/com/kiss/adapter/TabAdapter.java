package com.kiss.adapter;



import com.kiss.news.NewsFrag;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter{

	
	private static final String[] CONTENT = new String[] {"国内", "国际", "社会","图说","历史"};
	public TabAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		switch(position){
    	case 0:
    		break;
    	default:
    		break;
    	}
        return new NewsFrag(position + 1);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		
		return CONTENT[position % CONTENT.length].toUpperCase();
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return CONTENT.length;
	}

}
