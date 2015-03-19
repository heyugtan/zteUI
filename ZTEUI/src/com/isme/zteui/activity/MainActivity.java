package com.isme.zteui.activity;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import com.isme.zteui.R;
import com.isme.zteui.adapter.PagerAdapterAd;

/**
 * Title: zte 主页</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-17</br>
 */
public class MainActivity extends Activity implements OnPageChangeListener,
		OnClickListener {

	private static final String TAG = MainActivity.class.getSimpleName();

	// 滚动广告
	private ViewPager viewPagerAd;
	private LinearLayout layoutDots;

	// 图片
	private int[] imgId;;
	private List<ImageView> imageList;
	// 小点
	private List<View> dotsList;
	private Runnable runnableAd;
	// 自动播放时间间隔
	private int autoChangeTime = 1500;

	// 广告adapter
	private PagerAdapterAd adapterAd;

	private ImageView imgReserve;
	private ImageView imgOrders;
	private ImageView imgRecommend;

	/**
	 * 控制 ad 图片滚动
	 */
	@SuppressLint("HandlerLeak")
	private Handler handlerAd = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			setCurrentPager(msg.what);
			viewPagerAd.setCurrentItem(msg.what);
			Log.i(TAG, "play-"+msg.what);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		findView();
		initializeAdData();

		// 播放放到Activity onResume()里面
		// adPaly();
	}

	/**
	 * 滚动广告线程 开始
	 */
	private void adPaly() {
		runnableAd = new Runnable() {

			@Override
			public void run() {
				int next = viewPagerAd.getCurrentItem() + 1;
				if (next >= adapterAd.getCount()) {
					next = 0;
				}
				handlerAd.sendEmptyMessage(next);
			}
		};
		handlerAd.postDelayed(runnableAd, autoChangeTime);
	}

	/**
	 * 初始化滚动广告 数据
	 */
	private void initializeAdData() {
		initImage();
		initDots();

		adapterAd = new PagerAdapterAd(imageList);
		viewPagerAd.setAdapter(adapterAd);
	}

	/**
	 * 初始化滚动小点
	 */
	private void initDots() {
		dotsList = new ArrayList<View>();
		View dot = null;

		LinearLayout.LayoutParams dotParam = new LinearLayout.LayoutParams(12,
				6);
		dotParam.setMargins(5, 0, 5, 0);

		for (int i = 0; i < imgId.length; i++) {
			dot = new View(this);
			dot.setLayoutParams(dotParam);
			if (0 == i) {
				dot.setBackgroundResource(R.drawable.dot_focus);
			} else {
				dot.setBackgroundResource(R.drawable.dot_normal);
			}

			dotsList.add(dot);
			layoutDots.addView(dotsList.get(i));
		}
	}

	/**
	 * 初始化广告图片
	 */
	private void initImage() {
		imgId = new int[] { R.drawable.ad1, R.drawable.ad2, R.drawable.ad3,
				R.drawable.ad4 };
		imageList = new ArrayList<ImageView>();
		for (int i = 0; i < imgId.length; i++) {
			ImageView img = new ImageView(this);
			// 设置属性缩放
			img.setScaleType(ScaleType.CENTER_CROP);
			// 点击事件
			img.setImageResource(imgId[i]);
			img.setId(i);
			img.setOnClickListener(new AdClickListener());
			imageList.add(img);
		}
	}

	/**
	 * 控件 赋值
	 */
	private void findView() {
		viewPagerAd = (ViewPager) findViewById(R.id.vp_home_ad);
		layoutDots = (LinearLayout) findViewById(R.id.layout_ad_dots);

		imgReserve = (ImageView) findViewById(R.id.img_home_reserve);
		imgOrders = (ImageView) findViewById(R.id.img_home_orders);
		imgRecommend = (ImageView) findViewById(R.id.img_home_recommend);

		viewPagerAd.setOnPageChangeListener(this);

		imgReserve.setOnClickListener(this);
		imgOrders.setOnClickListener(this);
		imgRecommend.setOnClickListener(this);
	}

	// ------------------ ad滚动监听 ------------------
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int position) {
		setCurrentPager(position);

		// 重新开始 播放
		handlerAd.removeCallbacks(runnableAd);
		handlerAd.postDelayed(runnableAd, autoChangeTime);
	}

	/**
	 * 设置当前页面
	 * 
	 * @param position
	 */
	private void setCurrentPager(int position) {
		for (int i = 0; i < imgId.length; i++) {
			if (position == i) {
				dotsList.get(i).setBackgroundResource(R.drawable.dot_focus);
			} else {
				dotsList.get(i).setBackgroundResource(R.drawable.dot_normal);
			}
		}
	}

	/**
	 * 
	 * @author Administrator
	 * 
	 */
	class AdClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			for (int i = 0; i < imgId.length; i++) {
				if (i == v.getId()) {
					Intent intentAd = new Intent(MainActivity.this,
							AdDetailActivity.class);
					intentAd.putExtra("ad_id", i);
					startActivity(intentAd);
				}
			}

		}
	}

	@Override
	protected void onResume() {
		super.onResume();

		if (runnableAd != null) {
			handlerAd.removeCallbacks(runnableAd);
			handlerAd.postDelayed(runnableAd, autoChangeTime);
		} else {
			// 重新开始 播放
			adPaly();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		handlerAd.removeCallbacks(runnableAd);
	}

	@Override
	protected void onDestroy() {
		if (runnableAd != null) {
			handlerAd.removeCallbacks(runnableAd);
		}
		super.onDestroy();
	}

	/**
	 * 点击事件开始
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// TODO
		case R.id.img_home_reserve:
			// 预定
			startActivity(new Intent(this, RestauQualifyActivity.class));
			break;
		case R.id.img_home_orders:
			// 订单
			startActivity(new Intent(this, LoginActivity.class));
			break;
		case R.id.img_home_recommend:
			// 推荐
			startActivity(new Intent(this, ConfirmOrderActivity.class));
			break;

		default:
			break;
		}
	};

}
