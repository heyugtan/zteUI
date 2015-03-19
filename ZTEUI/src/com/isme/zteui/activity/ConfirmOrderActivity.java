package com.isme.zteui.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.isme.zteui.R;
import com.isme.zteui.adapter.ConfirmOrderFoodAdapter;
import com.isme.zteui.utils.DensityUtil;

/**
 * Title: 确认定单页面</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-17</br>
 */
public class ConfirmOrderActivity extends Activity implements OnClickListener {

	private TextView tvTitle;

	private ListView lvFood;
	private ConfirmOrderFoodAdapter mAdapter;
	private List<Map<String, String>> foodList;

	private Button btnCommitOrder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_confirm_order);

		initializeView();
		initializeData();
	}

	/**
	 * Title: 初始化数据 </br><br>
	 * Description: </br>
	 */
	private void initializeData() {
		foodList = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 6; i++) {
			Map<String, String> food = new HashMap<String, String>();
			food.put("name", "红烧鱼");
			food.put("price", "99");
			food.put("priceMark", "100");
			food.put("number", "1");
			food.put("subtotal", "99");
			foodList.add(food);
		}

		mAdapter = new ConfirmOrderFoodAdapter(foodList, this);

		lvFood.setAdapter(mAdapter);
		// 计算高度
		setListViewHeightBasedOnChildren(lvFood);
	}

	/**
	 * Title: 初始化控件 </br><br>
	 * Description: </br>
	 */
	private void initializeView() {
		tvTitle = (TextView) findViewById(R.id.tv_head_title);
		tvTitle.setText(getResources().getString(R.string.confirm_order));

		lvFood = (ListView) findViewById(R.id.lv_order_food);
		lvFood.setSelector(R.color.white);

		btnCommitOrder = (Button) findViewById(R.id.btn_commit_order);
		btnCommitOrder.setOnClickListener(this);
	}

	/**
	 * Title: 返回 </br><br>
	 * Description: </br>
	 * 
	 * @param v
	 */
	public void backStack(View v) {
		finish();
	}

	/**
	 * Title: 计算ListView的高度的 </br><br>
	 * Description: </br>
	 * 
	 * @param listView
	 */
	public void setListViewHeightBasedOnChildren(ListView listView) {

		// 获取listview的适配器
		ListAdapter listAdapter = listView.getAdapter(); // item的高度

		if (listAdapter == null) {

			return;
		}

		int totalHeight = 0;

		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = mAdapter.getView(i, null, listView);

			listItem.measure(0, 0); // 计算子项View 的宽高 //统计所有子项的总高度
			totalHeight += DensityUtil.dip2px(getApplicationContext(),
					listItem.getMeasuredHeight())
					+ listView.getDividerHeight() + 4;
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();

		params.height = totalHeight;
		listView.setLayoutParams(params);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		/**
		 * 提交订单
		 */
		case R.id.btn_commit_order:
			// TODO
			startActivity(new Intent(this, OnlinePayActivity.class));
			break;

		default:
			break;
		}
	}
}
