package com.isme.zteui.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Title: 主页滚动广告的adapter</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-17</br>
 */
public class PagerAdapterAd extends PagerAdapter {

	private List<ImageView> imageList;

	public PagerAdapterAd(List<ImageView> imageList) {
		super();
		this.imageList = imageList;
	}

	@Override
	public int getCount() {
		return imageList.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(imageList.get(position));
		return imageList.get(position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(imageList.get(position));
	}
}
