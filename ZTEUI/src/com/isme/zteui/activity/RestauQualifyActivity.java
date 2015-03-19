package com.isme.zteui.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Request.Method;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.isme.zteui.R;
import com.isme.zteui.cache.BitmapLruCache;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.GridView;

/**
 * Title: 餐厅资质页面</br><br>
 * Description: </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * 
 * @author and</br><br>
 * @version 1 </br><br>
 *          data: 2015-3-17</br>
 */
public class RestauQualifyActivity extends Activity {

	private static final String TAG = RestauQualifyActivity.class.getSimpleName();
	private static final String url = "http://app.nuomi.com/naserver/home/homepage?logpage=Home&cityid=300210000&appid=android&tn=android&terminal_type=android&device=Genymotion+Google+Nexus+S+-+4.1.1+-+API+16+-+480x800&channel=1006900a&v=5.0.2&os=SDK16&location=0&cuid=477AD5CF1A3CC8B6073AD245387DCAA7000000000000000&uuid=ffffffff-bcbf-43b9-9c1c-96300033c587&timestamp=1410866512822&swidth=480&sheight=728&net=wifi&sign=d19662517af1fc33c387f9aa1b6344d1"; 
	
	//网格
	private GridView gvQualifies;
	private RestauQualifiyAdapter adapter;
	
	private RequestQueue mQueue;
	//图片的地址
	private List<String> urlList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_restau_qualify);
		
		initializeView();
		initializeData();
		
	}

	/**
	 * Title: 初始化数据 </br><br>
	 * Description:  </br>
	 */
	private void initializeData() {
		//连接网络  使用Volley
		mQueue = Volley.newRequestQueue(this);
		JsonObjectRequest request = new JsonObjectRequest(Method.GET, url, null, new Response.Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				Log.i(TAG, response.toString());
				urlList = new ArrayList<String>();
				
				//解析
				parseJsonData(response);
				
				adapter = new RestauQualifiyAdapter();
				gvQualifies.setAdapter(adapter);
				
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mQueue.add(request);
	}

	/**
	 * Title: 解析Json数据 </br><br>
	 * Description:  </br>
	 * @param response
	 */
	protected void parseJsonData(JSONObject response) {
		try {
			JSONObject data = response.getJSONObject("data");
			JSONArray array = data.getJSONArray("category");
			JSONObject obj = null;
			if(array.length() > 0)
			{
				for(int i=0; i<array.length(); i++)
				{
					obj = array.getJSONObject(i);
					String urIimg = obj.getString("category_picurl");
					
					//TODO
//					urlList.add(urIimg);
					
				}
				urlList.add("http://cdn00.baidu-img.cn//timg?nuomina&size=w480&imgtype=4&sec=1418745600&di=2b3e1c1e30946460ae881b26a6e3cf37&src=http%3A%2F%2Fhiphotos.baidu.com%2Fbainuo%2Fpic%2Fitem%2F42166d224f4a20a4ffba749594529822720ed038.jpg");
				urlList.add("http://cdn00.baidu-img.cn//timg?nuomina&size=w480&imgtype=4&sec=1418745600&di=2b3e1c1e30946460ae881b26a6e3cf37&src=http%3A%2F%2Fhiphotos.baidu.com%2Fbainuo%2Fpic%2Fitem%2F42166d224f4a20a4ffba749594529822720ed038.jpg");
				urlList.add("http://cdn00.baidu-img.cn//timg?nuomina&size=w480&imgtype=4&sec=1418745600&di=2b3e1c1e30946460ae881b26a6e3cf37&src=http%3A%2F%2Fhiphotos.baidu.com%2Fbainuo%2Fpic%2Fitem%2F42166d224f4a20a4ffba749594529822720ed038.jpg");
				urlList.add("http://cdn00.baidu-img.cn//timg?nuomina&size=w480&imgtype=4&sec=1418745600&di=2b3e1c1e30946460ae881b26a6e3cf37&src=http%3A%2F%2Fhiphotos.baidu.com%2Fbainuo%2Fpic%2Fitem%2F42166d224f4a20a4ffba749594529822720ed038.jpg");
				urlList.add("http://cdn00.baidu-img.cn//timg?nuomina&size=w480&imgtype=4&sec=1418745600&di=2b3e1c1e30946460ae881b26a6e3cf37&src=http%3A%2F%2Fhiphotos.baidu.com%2Fbainuo%2Fpic%2Fitem%2F42166d224f4a20a4ffba749594529822720ed038.jpg");
				urlList.add("http://cdn00.baidu-img.cn//timg?nuomina&size=w480&imgtype=4&sec=1418745600&di=2b3e1c1e30946460ae881b26a6e3cf37&src=http%3A%2F%2Fhiphotos.baidu.com%2Fbainuo%2Fpic%2Fitem%2F42166d224f4a20a4ffba749594529822720ed038.jpg");
				urlList.add("http://cdn00.baidu-img.cn//timg?nuomina&size=w480&imgtype=4&sec=1418745600&di=2b3e1c1e30946460ae881b26a6e3cf37&src=http%3A%2F%2Fhiphotos.baidu.com%2Fbainuo%2Fpic%2Fitem%2F42166d224f4a20a4ffba749594529822720ed038.jpg");
				urlList.add("http://cdn00.baidu-img.cn//timg?nuomina&size=w480&imgtype=4&sec=1418745600&di=2b3e1c1e30946460ae881b26a6e3cf37&src=http%3A%2F%2Fhiphotos.baidu.com%2Fbainuo%2Fpic%2Fitem%2F42166d224f4a20a4ffba749594529822720ed038.jpg");
				urlList.add("http://cdn00.baidu-img.cn//timg?nuomina&size=w480&imgtype=4&sec=1418745600&di=2b3e1c1e30946460ae881b26a6e3cf37&src=http%3A%2F%2Fhiphotos.baidu.com%2Fbainuo%2Fpic%2Fitem%2F42166d224f4a20a4ffba749594529822720ed038.jpg");
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Title: 初始化控件 </br><br>
	 * Description:  </br>
	 */
	private void initializeView() {
		gvQualifies = (GridView) findViewById(R.id.gv_qualifies);
		//去掉默认点击效果
		gvQualifies.setSelector(R.color.white_lucency);
	}

	/**
	 * Title: 餐厅资质 GridView的adapter</br><br>
	 * Description: 主要加载图片 </br><br>
	 * Copyright: Copyright(c)2003</br><br>
	 * Company: ihalma </br><br>
	 * @author and</br><br>
	 * @version 1 </br><br>
	 * data: 2015-3-17</br>
	 */
	class RestauQualifiyAdapter extends BaseAdapter
	{
		private ViewHolder viewHolder;
		private ImageLoader imageLoader;
		
		@Override
		public int getCount() {
			return urlList.size();
		}

		@Override
		public Object getItem(int position) {
			return urlList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			if(convertView == null)
			{
				convertView = LayoutInflater.from(RestauQualifyActivity.this).inflate(R.layout.gridview_restau_qualify_item, parent, false);
				viewHolder = new ViewHolder();
				viewHolder.image = (NetworkImageView) convertView.findViewById(R.id.netimg_qualify);
				convertView.setTag(viewHolder);
			}
			else{
				viewHolder = (ViewHolder) convertView.getTag();
			}
			
			imageLoader = new ImageLoader(mQueue, new BitmapLruCache());
			
			viewHolder.image.setImageUrl(urlList.get(position), imageLoader);
			
			return convertView;
		}
		
		class ViewHolder {
			NetworkImageView image;
		}
	}
	
	/**
	 * 防止Activity已结束， Volley还在请求返回数据
	 */
	@Override
	protected void onPostResume() {
		super.onPostResume();
		if(this == null)
		{
			return;
		}
	}
	
	/**
	 * 取消Volley请求网络  - 取消队列里面的所有请求 避免浪费资源
	 */
	@Override
	protected void onStop() {
		super.onStop();
		mQueue.cancelAll(this);
	}
}
