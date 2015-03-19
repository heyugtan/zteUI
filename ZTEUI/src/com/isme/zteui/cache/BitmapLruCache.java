package com.isme.zteui.cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

/**
 * Title: Volley 的缓存类</br><br>
 * Description:  </br><br>
 * Copyright: Copyright(c)2003</br><br>
 * Company: ihalma </br><br>
 * @author and</br><br>
 * @version 1 </br><br>
 * data: 2015-3-17</br>
 */
public class BitmapLruCache implements ImageCache {

	private LruCache<String, Bitmap> mCache;
	
	/**
	 * 最大缓存 10 M
	 */
	public BitmapLruCache() {
		int maxSize = 1024 * 1024 * 10; //最大缓存10M
		mCache = new LruCache<String, Bitmap>(maxSize){
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getRowBytes() * value.getHeight();
			}
		};
	}

	@Override
	public Bitmap getBitmap(String url) {
		return mCache.get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		mCache.put(url, bitmap);
	}

}
