package com.isme.zteui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

import com.isme.zteui.R;

/**
 * Title: 主页 滚动广告点击详情</br><br>
 * Description: 是一个 WebView </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-17</br>
 */
public class AdDetailActivity extends Activity implements OnClickListener {

	private WebView webAd;

	private int adId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ad_detail);

		adId = getIntent().getIntExtra("ad_id", 0);
		String html = "<html> <head><a>空连接" + adId + "</a></head> </html>";

		webAd = (WebView) findViewById(R.id.web_ad);
		webAd.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);

		initializeView();
	}

	/**
	 * 到时删除 TODO
	 */
	private Button btnEualate;
	private Button btnComplaint;
	private Button btnReservation;
	private Button btnOrderItem;
	private Button btnChangePass;
	private Button btnRestauDetail;

	/**
	 * Title: 初始化 </br><br>
	 * Description: </br>
	 */
	private void initializeView() {
		btnEualate = (Button) findViewById(R.id.btn_evaluate_retaurant);
		btnEualate.setOnClickListener(this);

		btnComplaint = (Button) findViewById(R.id.btn_complatint_retaurant);
		btnComplaint.setOnClickListener(this);
		
		btnReservation = (Button) findViewById(R.id.btn_reservation);
		btnReservation.setOnClickListener(this);
		
		btnOrderItem = (Button) findViewById(R.id.btn_order_item);
		btnOrderItem.setOnClickListener(this);
		
		btnChangePass = (Button) findViewById(R.id.btn_change_pass);
		btnChangePass.setOnClickListener(this);
		
		btnRestauDetail = (Button) findViewById(R.id.btn_restaurant_detail);
		btnRestauDetail.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 评价餐厅
		case R.id.btn_evaluate_retaurant:
			startActivity(new Intent(this, EvaluateRestaurantActivity.class));
			break;
		// 投诉餐厅
		case R.id.btn_complatint_retaurant:
			startActivity(new Intent(this, ComplaintActivity.class));
			break;
		// 订座
		case R.id.btn_reservation:
			startActivity(new Intent(this, ReservationActivity.class));
			break;
		// 订单列表 item
		case R.id.btn_order_item:
			startActivity(new Intent(this, Item.class));
			break;
			
		// 修改密码
		case R.id.btn_change_pass:
			startActivity(new Intent(this, ChangePasswdActivity.class));
			break;
			
		// 餐厅详情
		case R.id.btn_restaurant_detail:
			startActivity(new Intent(this, RestaurantDetailActivity.class));
			break;

		default:
			break;
		}
	}

}
