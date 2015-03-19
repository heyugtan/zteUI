package com.isme.zteui.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.isme.zteui.R;

/**
 * Title: 确认订单页面的 adapter</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-18</br>
 */
public class ConfirmOrderFoodAdapter extends BaseAdapter {

	private List<Map<String, String>> foodList;
	private Context context;
	private ViewHolder viewHolder;

	public ConfirmOrderFoodAdapter(List<Map<String, String>> foodList,
			Context context) {
		this.foodList = foodList;
		this.context = context;
	}

	@Override
	public int getCount() {
		return foodList.size();
	}

	@Override
	public Object getItem(int position) {
		return foodList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.list_confirm_order_list_item, parent, false);
			viewHolder = new ViewHolder();

			viewHolder.tvName = (TextView) convertView
					.findViewById(R.id.tv_food_name);
			viewHolder.tvPrice = (TextView) convertView
					.findViewById(R.id.tv_food_price);
			viewHolder.tvPriceMark = (TextView) convertView
					.findViewById(R.id.tv_food_price_mark);
			viewHolder.tvNumber = (TextView) convertView
					.findViewById(R.id.tv_food_number);
			viewHolder.tvSubtotal = (TextView) convertView
					.findViewById(R.id.tv_food_subtotal);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.tvName.setText(foodList.get(position).get("name"));
		viewHolder.tvPrice.setText(foodList.get(position).get("price"));
		viewHolder.tvPriceMark.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		viewHolder.tvPriceMark.setText(String.format("(%s)",
				foodList.get(position).get("priceMark")));
		viewHolder.tvNumber.setText(foodList.get(position).get("number"));
		viewHolder.tvSubtotal.setText(foodList.get(position).get("subtotal"));

		return convertView;
	}

	class ViewHolder {
		TextView tvName;
		TextView tvPrice;
		TextView tvPriceMark;
		TextView tvNumber;
		TextView tvSubtotal;
	}
}
