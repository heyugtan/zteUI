package com.isme.zteui.activity;

import com.isme.zteui.R;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Title: 评价餐厅页面</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-18</br>
 */
public class EvaluateRestaurantActivity extends Activity {

	private TextView tvTitle;
	
	private EditText etTextDesc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		setContentView(R.layout.activity_evaluate_restaurant);
		
		initializeView();
	}

	/**
	 * Title: 初始化控件 </br><br>
	 * Description:  </br>
	 */
	private void initializeView() {
		tvTitle = (TextView) findViewById(R.id.tv_head_title);
		tvTitle.setText(getResources().getString(R.string.evaluate_restaurant));
		
		etTextDesc = (EditText) findViewById(R.id.et_text_desc);
	}

	public void backStack(View v)
	{
		finish();
	}
	
}
