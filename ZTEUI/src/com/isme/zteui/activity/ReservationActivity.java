package com.isme.zteui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.isme.zteui.R;

/**
 * Title: 订座页面</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-19</br>
 */
public class ReservationActivity extends Activity implements OnClickListener {

	private TextView tvTitle;

	private ImageView ivRoom;
	private ImageView ivForOther;
	private boolean isRoom = false;
	private boolean isForOther = false;
	
	private Button btnConfirm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_reservation);

		initializeView();
	}

	private void initializeView() {
		tvTitle = (TextView) findViewById(R.id.tv_head_title);
		tvTitle.setText(getResources().getString(R.string.reservation));

		ivRoom = (ImageView) findViewById(R.id.iv_switch_room);
		ivForOther = (ImageView) findViewById(R.id.iv_switch_for_other);
		btnConfirm = (Button) findViewById(R.id.btn_reservation_confirm);

		ivRoom.setOnClickListener(this);
		ivForOther.setOnClickListener(this);
		btnConfirm.setOnClickListener(this);
	}

	public void backStack(View v) {
		finish();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 点击包房开关
		case R.id.iv_switch_room:
			setSwitch(ivRoom, isRoom);
			isRoom = isRoom?false:true;
			break;
			
		// 点击为他人订餐开关
		case R.id.iv_switch_for_other:
			setSwitch(ivForOther, isForOther);
			isForOther = isForOther?false:true;
			break;
			
		//确认订座
		case R.id.btn_reservation_confirm:
			startActivity(new Intent(this, ReservationDetailActivity.class));
			break;
			
		default:
			break;
		}
	}

	/**
	 * Title: 设置开关效果 </br><br>
	 * Description: </br>
	 */
	private void setSwitch(ImageView v, boolean b) {
		if (b) {
			v.setImageResource(R.drawable.switch_open_icon);
		} else {
			v.setImageResource(R.drawable.switch_close_icon);
		}
	}

}
