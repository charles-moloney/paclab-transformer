package com.jy.music;

import com.jy.multi_media.R;
import com.jy.multimedia.MainActivity;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MusicPlayer extends Activity {

	// 定义播放声音的MediaPlayer
	private MediaPlayer mediaPlayer;
	private List<String> MusicList = MusicActivity.MusicList;
	private String db_path = MainActivity.db_path;
	private int position;
	private Intent intent;
	private SQLiteDatabase db;
	private int i = 0;
	private Button control;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_player);
		intent = getIntent();
		position = intent.getIntExtra("position", 0);
		String path = MusicList.get(position).toString();
		mediaPlayer = new MediaPlayer();
		control = (Button) findViewById(R.id.control);
		play(path);
		db = SQLiteDatabase.openOrCreateDatabase(db_path, null);
		InsertData(path);
	}
	
	private void play(String path) {
		try {
			mediaPlayer.reset();
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepare();
			mediaPlayer.start();
			i = 0;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void stop(View v) {
		mediaPlayer.stop();
		control.setText("暂停");
		i = 0;
	}
	
	public void previous(View v) {
		if(position > 0) {
			position--;
			String path = MusicList.get(position);
			play(path);
			InsertData(path);
		}
		else {
			String path = MusicList.get(0);
			play(path);
			InsertData(path);
		}
		control.setText("暂停");
		i = 0;
	}
	
	public void pause(View v) {
		i++;
		if(i % 2 == 1) {
			mediaPlayer.pause();
			control.setText("开始");
		}
		else {
			mediaPlayer.start();
			control.setText("暂停");
		}
	}
	
	public void next(View v) {
		if(position < MusicList.toArray().length - 1) {
			position++;
			String path = MusicList.get(position);
			play(path);
			InsertData(path);
		}
		else {
			String path = MusicList.get(MusicList.toArray().length - 1);
			play(path);
			InsertData(path);
		}
		control.setText("暂停");
		i = 0;
	}
	
	@Override  
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			intent.putExtra("position", position);
			MusicPlayer.this.setResult(0, intent);
			mediaPlayer.stop();
			finish();
			return true;
		}
		else
			return super.onKeyDown(keyCode, event);
	}

}