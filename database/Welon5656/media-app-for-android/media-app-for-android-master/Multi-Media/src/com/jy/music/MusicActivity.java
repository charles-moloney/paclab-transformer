package com.jy.music;

import com.jy.multi_media.R;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class MusicActivity extends Activity {

	public static List<String> MusicList = new ArrayList<String>();  //��� List 
	ListView list;
	
	public void GetFiles(String Path, String Extension, boolean IsIterative)  //����Ŀ¼����չ�����Ƿ�������ļ��� 
	{ 
	    File[] files = new File(Path).listFiles(); 
	    for (int i = 0; i < files.length; i++) 
	    { 
	        File f = files[i]; 
	        if (f.isFile()) 
	        { 
	            if (f.getPath().substring(f.getPath().length() - Extension.length()).equals(Extension))  //�ж���չ�� 
	            	MusicList.add(f.getPath()); 
	  
	            if (!IsIterative) 
	                break; 
	        } 
	        else if (f.isDirectory() && f.getPath().indexOf("/.") == -1)  //���Ե��ļ��������ļ�/�ļ��У� 
	            GetFiles(f.getPath(), Extension, IsIterative); 
	    } 
	}
	
	@SuppressLint("SdCardPath")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music);
//		File root = new File("/mnt/sdcard/");
		File root = new File("/storage/sdcard1/");
		GetFiles(root.getPath(), "mp3", true); 
		// ����һ��List����List�����Ԫ����Map
		List<Map<String, Object>> listItems = 
				new ArrayList<Map<String, Object>>();
		for (int i = 0; i < MusicList.toArray().length; i++)
		{
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("music", MusicList.get(i));
			listItems.add(listItem);
		}
		// ����һ��SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				listItems, R.layout.music_cell, new String[]{"music"},
				new int[] {R.id.music_cell});
		list = (ListView) findViewById(R.id.music_list);
		// ΪGridView����Adapter
		list.setAdapter(simpleAdapter);
		// ����б�������ļ�����
		list.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(MusicActivity.this, MusicPlayer.class);
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
			list.smoothScrollToPositionFromTop(return_position, 0);
		}
	}
	
//	@Override  
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//			MusicList.clear();
//			finish();
//			return true;
//		}
//		else
//			return super.onKeyDown(keyCode, event);
//	}
	
	@Override 
	protected void onDestroy() { 
	// TODO Auto-generated method stub
		MusicList.clear();
        super.onDestroy();  
	}
	
}