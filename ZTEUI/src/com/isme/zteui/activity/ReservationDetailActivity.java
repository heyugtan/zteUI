package com.isme.zteui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.isme.zteui.R;

/**
 * Title: 订座详情 页面</br><br>
 * Description: 需要加入分享接口 </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-19</br>
 */
public class ReservationDetailActivity extends Activity implements
		OnClickListener {

	private TextView tvTitle;
	private Button btnBookGo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_reservation_detail);

		initializView();
	}

	private void initializView() {
		tvTitle = (TextView) findViewById(R.id.tv_detail_title);
		tvTitle.setText(getResources().getString(R.string.reservation_detail));
		
		btnBookGo = (Button) findViewById(R.id.btn_reservation_detail_go);

		btnBookGo.setOnClickListener(this);
	}

	public void backStack(View v) {
		finish();
	}

	/**
	 * Title: 分享内容 </br><br>
	 * Description: </br>
	 * 
	 * @param v
	 */
	public void shareInfo(View v) {
		// share TODO
		Toast.makeText(this, "TODO-分享", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_reservation_detail_go:
			startActivity(new Intent(this, ReservationSucceActivity.class));
			break;

		default:
			break;
		}

	}

}
