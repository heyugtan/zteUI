package com.isme.zteui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.isme.zteui.R;

/**
 * Title: 订单在线支付页面</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-18</br>
 */
public class OnlinePayActivity extends Activity implements OnClickListener {
	private static final String TAG = OnlinePayActivity.class.getSimpleName();
	
	private TextView tvTitle;
	private Button btnOnlinePay;
	
	//支付方式
	private LinearLayout layoutPayYinlian;
	private LinearLayout layoutPayWeixin;
	private LinearLayout layoutPayZhifubao;
	private int payMethod = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_online_pay);

		initializeView();
	}

	/**
	 * Title: view </br><br>
	 * Description: </br>
	 */
	private void initializeView() {
		tvTitle = (TextView) findViewById(R.id.tv_head_title);
		tvTitle.setText(getResources().getString(R.string.online_pay));
		
		layoutPayYinlian = (LinearLayout) findViewById(R.id.layout_pay_yinlian);
		layoutPayYinlian.setSelected(true);
		layoutPayWeixin = (LinearLayout) findViewById(R.id.layout_pay_weixin);
		layoutPayZhifubao = (LinearLayout) findViewById(R.id.layout_pay_zhifubao);
		btnOnlinePay = (Button) findViewById(R.id.btn_order_pay);
		
		layoutPayYinlian.setOnClickListener(this);
		layoutPayWeixin.setOnClickListener(this);
		layoutPayZhifubao.setOnClickListener(this);
		btnOnlinePay.setOnClickListener(this);
	}

	/**
	 * Title: 头部返回 </br><br>
	 * Description: </br>
	 */
	public void backStack(View v) {
		finish();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_pay_yinlian:
			setPayFocus(layoutPayYinlian);
			payMethod = 1;
			//TODO
			break;
		case R.id.layout_pay_weixin:
			setPayFocus(layoutPayWeixin);
			payMethod = 2;
			//TODO
			break;
		case R.id.layout_pay_zhifubao:
			setPayFocus(layoutPayZhifubao);
			payMethod = 3;
			//TODO
			break;
			
		//确认支付
		case R.id.btn_order_pay:
			startActivity(new Intent(this, OrderDetailActivity.class));
			break;

		default:
			break;
		}
		Log.i(TAG, String.valueOf(payMethod));
	}

	/**
	 * Title: 设置支付方式的 焦点事件  改变样式 </br><br>
	 * Description:  </br>
	 * @param layoutPayYinlian2
	 */
	private void setPayFocus(LinearLayout layout) {
		layoutPayYinlian.setSelected(false);
		layoutPayWeixin.setSelected(false);
		layoutPayZhifubao.setSelected(false);
		
		layout.setSelected(true);
	}
}
