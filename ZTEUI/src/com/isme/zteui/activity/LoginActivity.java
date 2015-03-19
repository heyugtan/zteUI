package com.isme.zteui.activity;

import com.isme.zteui.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Title: 登录界面</br><br>
 * Description:  </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * @author and</br><br>
 * @version 1 </br><br>
 * data: 2015-3-17</br>
 */
public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
	}
	
}
