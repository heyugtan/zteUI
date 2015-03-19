package com.isme.zteui.activity;

import com.isme.zteui.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Title: 订座成功页面</br><br>
 * Description:  </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * @author and</br><br>
 * @version 1 </br><br>
 * data: 2015-3-19</br>
 */
public class ReservationSucceActivity extends Activity {

	private TextView tvTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_reservation_success);
		
		initializeView();
	}

	private void initializeView() {
		tvTitle = (TextView) findViewById(R.id.tv_head_title);
		tvTitle.setText(getResources().getString(R.string.reservation_success));
	}
	
	public void backStack(View v)
	{
		finish();
	}
	
}
