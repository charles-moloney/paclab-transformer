package com.jy.video;

import com.jy.multi_media.R;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class VideoActivity extends Activity {

	public static List<String> VideoList = new ArrayList<String>();  //结果 List 
	ListView list;
	
	public void GetFiles(String Path, String Extension, boolean IsIterative)  //搜索目录，扩展名，是否进入子文件夹 
	{ 
	    File[] files = new File(Path).listFiles(); 
	    for (int i = 0; i < files.length; i++) 
	    { 
	        File f = files[i]; 
	        if (f.isFile()) 
	        { 
	            if (f.getPath().substring(f.getPath().length() - Extension.length()).equals(Extension))  //判断扩展名 
	            	VideoList.add(f.getPath()); 
	  
	            if (!IsIterative) 
	                break; 
	        } 
	        else if (f.isDirectory() && f.getPath().indexOf("/.") == -1)  //忽略点文件（隐藏文件/文件夹） 
	            GetFiles(f.getPath(), Extension, IsIterative); 
	    } 
	}
	
	@SuppressLint("SdCardPath")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		File root = new File("/mnt/sdcard/");
		GetFiles(root.getPath(), "mp4", true); 
		// 创建一个List对象，List对象的元素是Map
		List<Map<String, Object>> listItems = 
				new ArrayList<Map<String, Object>>();
		for (int i = 0; i < VideoList.toArray().length; i++)
		{
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("video", VideoList.get(i));
			listItems.add(listItem);
		}
		// 创建一个SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				listItems, R.layout.video_cell, new String[]{"video"},
				new int[] {R.id.video_cell});
		list = (ListView) findViewById(R.id.video_list);
		// 为GridView设置Adapter
		list.setAdapter(simpleAdapter);
		// 添加列表项被单击的监听器
		list.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(VideoActivity.this, VideoPlayer.class);
				intent.putExtra("position", position);
				startActivityForResult(intent, 0);
			}
		});
	}
	// 重写该方法，该方法以回调的方式来获取指定Activity返回的结果
	@Override
	public void onActivityResult(int requestCode
		, int resultCode, Intent intent)
	{
		// 当requestCode、resultCode同时为0，也就是处理特定的结果
		if (requestCode == 0 && resultCode == 0)
		{
			int return_position = intent.getIntExtra("position", 0);
			list.smoothScrollToPositionFromTop(return_position, 0);
		}
	}
	
//	@Override  
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//			VideoList.clear();
//			finish();
//			return true;
//		}
//		else
//			return super.onKeyDown(keyCode, event);
//	}
	
	@Override 
	protected void onDestroy() { 
	// TODO Auto-generated method stub
		VideoList.clear();
        super.onDestroy();  
	}

}