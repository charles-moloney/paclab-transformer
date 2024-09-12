package com.jy.video;

import com.jy.multi_media.R;
import com.jy.multimedia.MainActivity;

import java.io.File;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends Activity {

	private List<String> VideoList = VideoActivity.VideoList;
	private String db_path = MainActivity.db_path;
	private int position;
	private Intent intent;
	private SQLiteDatabase db;
	private int i = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.video_player);
		intent = getIntent();
		position = intent.getIntExtra("position", 0);
		String path = VideoList.get(position).toString();
		VideoView videoView = (VideoView) findViewById(R.id.videoView);
		MediaController mController = new MediaController(this);
		File video = new File(path);
		if(video.exists())
		{
			videoView.setVideoPath(video.getAbsolutePath());  //①
			// 设置videoView与mController建立关联
			videoView.setMediaController(mController);  //②
			// 设置mController与videoView建立关联
			mController.setMediaPlayer(videoView);  //③
			// 让VideoView获取焦点
			videoView.requestFocus();
		}
		db = SQLiteDatabase.openOrCreateDatabase(db_path, null);
		InsertData(path);
	}
	
	private void InsertData(String history) {
		try
		{
			// 执行insert语句插入数据
			insertData(db, history);
		}
		catch (SQLiteException se)
		{
			// 执行DDL创建数据表
			db.execSQL("create table news_inf(_id integer"
				+ " primary key autoincrement,"
				+ " history varchar(150))");
			// 执行insert语句插入数据
			insertData(db, history);
		}
	}
	
	private void insertData(SQLiteDatabase db, String history) {
		db.execSQL("insert into news_inf values(null , ?)", new String[] {history});
	}
	
	@Override  
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			intent.putExtra("position", position);
			VideoPlayer.this.setResult(0, intent);
			finish();
			return true;
		}
		else
			return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		i++;
		if(i%4 == 1 || i%4 == 2) {
			WindowManager.LayoutParams params = getWindow().getAttributes();  
			params.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;  
			getWindow().setAttributes(params);  
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);  
		}
		else {
			WindowManager.LayoutParams params = getWindow().getAttributes();  
			params.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);  
			getWindow().setAttributes(params);  
			getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);  
		}
		return true;
	}

}