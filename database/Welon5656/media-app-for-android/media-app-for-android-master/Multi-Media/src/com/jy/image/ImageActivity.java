package com.jy.image;

import com.jy.multi_media.R;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;

public class ImageActivity extends Activity {

	public static List<String> ImageList = new ArrayList<String>();  //��� List 
	GridView grid;
	
	public void GetFiles(String Path, String Extension, boolean IsIterative)  //����Ŀ¼����չ�����Ƿ�������ļ��� 
	{ 
	    File[] files = new File(Path).listFiles(); 
	    for (int i = 0; i < files.length; i++) 
	    { 
	        File f = files[i]; 
	        if (f.isFile()) 
	        { 
	            if (f.getPath().substring(f.getPath().length() - Extension.length()).equals(Extension))  //�ж���չ�� 
	            	ImageList.add(f.getPath()); 
	  
	            if (!IsIterative) 
	                break; 
	        } 
	        else if (f.isDirectory() && f.getPath().indexOf("/.") == -1)  //���Ե��ļ��������ļ�/�ļ��У� 
	            GetFiles(f.getPath(), Extension, IsIterative); 
	    } 
	}
	
	@SuppressLint("SdCardPath")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		File root = new File("/mnt/sdcard/");
		GetFiles(root.getPath(), "gif", true); 
		// ����һ��List����List�����Ԫ����Map
		List<Map<String, Object>> listItems = 
				new ArrayList<Map<String, Object>>();
		for (int i = 0; i < ImageList.toArray().length; i++)
		{
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", BitmapFactory.decodeFile(ImageList.get(i)));
			listItems.add(listItem);
		}
		// ����һ��SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				listItems, R.layout.image_cell, new String[]{"image"},
				new int[] {R.id.image_cell});
		
		simpleAdapter.setViewBinder(new ViewBinder() {
			
			@Override
            public boolean setViewValue(View view, Object data,
            		String textRepresentation) {
				//��֤viewΪimageview������Դλbitmap��ʽ
				if(view instanceof ImageView && data instanceof Bitmap) {
					ImageView i = (ImageView)view;
					i.setScaleType(ImageView.ScaleType.FIT_CENTER);
					i.setImageBitmap((Bitmap) data);
					return true;
				}
				return false;
			}
			
		});
		
		grid = (GridView) findViewById(R.id.image_grid);
		// ΪGridView����Adapter
		grid.setAdapter(simpleAdapter);
		// ����б��ѡ�еļ�����
		/*grid.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});*/
		// ����б�������ļ�����
		grid.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(ImageActivity.this, ImageBrowser.class);
				intent.putExtra("position", position);
				startActivityForResult(intent, 0);
			}
		});
	}
	
	// ��д�÷������÷����Իص��ķ�ʽ����ȡָ��Activity���صĽ��
	@Override
	public void onActivityResult(int requestCode
		, int resultCode, Intent intent)
	{
		// ��requestCode��resultCodeͬʱΪ0��Ҳ���Ǵ����ض��Ľ��
		if (requestCode == 0 && resultCode == 0)
		{
			int return_position = intent.getIntExtra("position", 0);
			grid.smoothScrollToPositionFromTop(return_position, 0);
		}
	}
	
//	@Override  
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//			ImageList.clear();
//			finish();
//			return true;
//		}
//		else
//			return super.onKeyDown(keyCode, event);
//	}
	
	@Override 
	protected void onDestroy() { 
	// TODO Auto-generated method stub
		ImageList.clear();
        super.onDestroy();  
	}

}