package com.isme.zteui.activity;

import com.isme.zteui.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Title: 餐厅详情页面</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-20</br>
 */
public class RestaurantDetailActivity extends Activity implements OnClickListener{

	private TextView tvTitle;
	
	private LinearLayout layoutOrder;
	private LinearLayout layoutReservation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_restau_detail);

		initializeView();
	}

	private void initializeView() {
		tvTitle = (TextView) findViewById(R.id.tv_detail_title);
		tvTitle.setText(this.getResources().getString(
				R.string.restaurant_detail));
		
		layoutOrder = (LinearLayout) findViewById(R.id.layout_i_order);
		layoutReservation = (LinearLayout) findViewById(R.id.layout_i_reservation);
		
		layoutOrder.setOnClickListener(this);
		layoutReservation.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void backStack(View v) {
		finish();
	}
	
	/**
	 * Title: 分享按钮 </br><br>
	 * Description:  </br>
	 * @param v
	 */
	public void shareInfo(View v){
		//TODO 分享
		Toast.makeText(this, "TODO-share", Toast.LENGTH_SHORT).show();
	}

}
