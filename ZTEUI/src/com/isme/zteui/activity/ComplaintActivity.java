package com.isme.zteui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.isme.zteui.R;

/**
 * Title: 投诉餐厅页面</br><br>
 * Description:  </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * @author and</br><br>
 * @version 1 </br><br>
 * data: 2015-3-18</br>
 */
public class ComplaintActivity extends Activity {

	private TextView tvTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_complaint);
		
		initializeView();
	}

	private void initializeView() {
		tvTitle = (TextView) findViewById(R.id.tv_head_title);
		tvTitle.setText(getResources().getString(R.string.complaint_restaurant));
	}
	
	public void backStack(View v)
	{
		finish();
	}
	
}
