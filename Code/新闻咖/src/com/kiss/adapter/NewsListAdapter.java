package com.kiss.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiss.domain.Info;
import com.kiss.news.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class NewsListAdapter extends BaseAdapter {
	private ViewHolder holder;
	private LayoutInflater layoutInflater;
	private Context context;
	
	private List<Info> list;

	private static final int TYPE_COUNT = 3;// item类型的总数
	private static final int TYPE_NEWS = 0;// 普通新闻
	private static final int TYPE_IMAGENEWS = 1;// 图片新闻
	private static final int TYPE_PASSAGENEWS = 2;// 文字新闻

	private ImageLoader imageLoader = ImageLoader.getInstance();
	

	private DisplayImageOptions options;

	// 构造方法
	public NewsListAdapter(Context c) {
		super();
		layoutInflater = (LayoutInflater) LayoutInflater.from(c);
		list = new ArrayList<Info>();

		imageLoader.init(ImageLoaderConfiguration.createDefault(c));
		options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.yujiazai)
				.showImageForEmptyUri(R.drawable.yujiazai)
				.showImageOnFail(R.drawable.yujiazai).cacheInMemory()
				.cacheOnDisc().displayer(new RoundedBitmapDisplayer(20))
				.displayer(new FadeInBitmapDisplayer(300)).build();
	}

	public void setList(List<Info> list) {
		this.list = list;
	}

	public void addList(List<Info> list) {
		this.list.addAll(list);
	}

	public void clearList() {
		this.list.clear();
	}

	public List<Info> getList() {
		return list;
	}

	public void removeItem(int position) {
		if (list.size() > 0) {
			list.remove(position);
		}
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int type = getItemViewType(position);

		if (type == TYPE_NEWS) {
			if (null == convertView) {

				// 装载布局文件
				convertView = layoutInflater.inflate(R.layout.news_item, null);
				holder = new ViewHolder();
				// holder.id = (TextView) convertView.findViewById(R.id.id);
				holder.title = (TextView) convertView.findViewById(R.id.title);
				// holder.date = (TextView) convertView.findViewById(R.id.date);
				holder.content = (TextView) convertView
						.findViewById(R.id.content);
				holder.img = (ImageView) convertView.findViewById(R.id.newsImg);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			Info item = list.get(position); // 获取当前项数据
			if (null != item) {
				// holder.id.setText(position + 1 + "");
				holder.title.setText(item.getTitle());
				holder.content.setText(item.getDescription());
				// holder.date.setText(item.getDate());
				if (item.getImglink() != null) {
					holder.img.setVisibility(View.VISIBLE);
					imageLoader.displayImage(item.getImglink(), holder.img,
							options);
				} else {
					holder.img.setVisibility(View.GONE);
				}

			}
			return convertView;
		} else if (type == TYPE_PASSAGENEWS) {
			if (null == convertView) {

				// 装载布局文件
				convertView = layoutInflater.inflate(
						R.layout.news_item_passage, null);
				holder = new ViewHolder();
				// holder.id = (TextView) convertView.findViewById(R.id.id);
				holder.title = (TextView) convertView.findViewById(R.id.passageTitle);
				// holder.date = (TextView) convertView.findViewById(R.id.date);
				// holder.content = (TextView)
				// convertView.findViewById(R.id.content);
				// holder.img = (ImageView)
				// convertView.findViewById(R.id.newsImg);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			Info item = list.get(position); // 获取当前项数据
			if (null != item) {
				// holder.id.setText(position + 1 + "");
				holder.title.setText(item.getTitle());
				// holder.content.setText(item.getDescription());
				// holder.date.setText(item.getDate());
				/*
				 * if (item.getImglink() != null) { //
				 * holder.img.setVisibility(View.VISIBLE); // imageLoader //
				 * .displayImage(item.getImglink(), holder.img, options); } else
				 * { holder.img.setVisibility(View.GONE); }
				 */
				//holder.img.setVisibility(View.GONE);

			}
			return convertView;

		} else {
			if (null == convertView) {

				// 装载布局文件
				convertView = layoutInflater.inflate(R.layout.news_item_image,
						null);
				holder = new ViewHolder();
				// holder.id = (TextView) convertView.findViewById(R.id.id);
				// holder.title = (TextView)
				// convertView.findViewById(R.id.title);
				// holder.date = (TextView) convertView.findViewById(R.id.date);
				holder.content = (TextView) convertView
						.findViewById(R.id.imgDes);
				holder.img = (ImageView) convertView
						.findViewById(R.id.imgImage);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			Info item = list.get(position); // 获取当前项数据
			if (null != item) {
				// holder.id.setText(position + 1 + "");
				// holder.title.setText(item.getTitle());
				holder.content.setText(item.getDescription());
				// holder.date.setText(item.getDate());
				if (item.getImglink() != null) {
					holder.img.setVisibility(View.VISIBLE);
					imageLoader.displayImage(item.getImglink(), holder.img,
							options);
				} else {
					holder.img.setVisibility(View.GONE);
				}

			}
			return convertView;

		}

	}

	@Override
	public int getViewTypeCount() {

		return TYPE_COUNT;
	}

	@Override
	public int getItemViewType(int position) {

		if ("imgtitle".equals(list.get(position).getTitle())) {

			return TYPE_IMAGENEWS;// 图片新闻
		} else if ("passageDes".equals(list.get(position).getDescription())) {
			return TYPE_PASSAGENEWS; // 文字新闻
		} else {
			return TYPE_NEWS;// 普通新闻
		}

	}

	private class ViewHolder {
		TextView id;
		// TextView date;
		TextView title;
		ImageView img;
		TextView content;
	}
}
