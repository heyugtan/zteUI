package com.isme.zteui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.isme.zteui.R;

public class RegisterActivity extends Activity {

	private TextView tvTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);
		
		initializeView();
	}
	
	
	private void initializeView() {
		tvTitle = (TextView) findViewById(R.id.tv_head_title);
		tvTitle.setText(getResources().getString(R.string.register_info));
	}


	public void backStack(View v){
		finish();
	}
	
}
