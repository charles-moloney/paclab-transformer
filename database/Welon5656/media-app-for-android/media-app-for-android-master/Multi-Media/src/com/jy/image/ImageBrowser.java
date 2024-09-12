package com.jy.image;

import com.jy.multi_media.R;
import com.jy.multimedia.MainActivity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.widget.ImageView;

public class ImageBrowser extends Activity implements OnGestureListener {
	
	private List<String> ImageList = ImageActivity.ImageList;
	private String db_path = MainActivity.db_path;
	private int position;
	private Intent intent;
	private ImageView img;
	private SQLiteDatabase db;
	final int FLIP_DISTANCE = 50;
	GestureDetector detector;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_brower);
		intent = getIntent();
		position = intent.getIntExtra("position", 0);
		img = (ImageView) findViewById(R.id.imageView);
		String path = ImageList.get(position);
		img.setImageBitmap(BitmapFactory.decodeFile(path));
		db = SQLiteDatabase.openOrCreateDatabase(db_path, null);
		InsertData(path);
		detector = new GestureDetector(this, this);
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
			ImageBrowser.this.setResult(0, intent);
			finish();
			return true;
		}
		else
			return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		// 退出程序时关闭SQLiteDatabase
		if (db != null && db.isOpen())
		{
			db.close();
		}
	}
	
	@Override
	public boolean onFling(MotionEvent event1, MotionEvent event2,
		float velocityX, float velocityY)
	{
		// 如果第一个触点事件的X座标大于第二个触点事件的X座标超过FLIP_DISTANCE
		// 也就是手势从右向左滑。
		if (event2.getX() - event1.getX() > FLIP_DISTANCE) {
			if(position > 0) {
				position--;
				String path = ImageList.get(position);
				img.setImageBitmap(BitmapFactory.decodeFile(path));
				InsertData(path);
			}
			return true;
		}
		else if (event1.getX() - event2.getX() > FLIP_DISTANCE) {
			if(position < ImageList.toArray().length-1) {
				position++;
				String path = ImageList.get(position);
				img.setImageBitmap(BitmapFactory.decodeFile(path));
				InsertData(path);
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// 将该Activity上的触碰事件交给GestureDetector处理
		return detector.onTouchEvent(event);
	}
	
	public void up(View v){
		if(position > 0) {
			position--;
			String path = ImageList.get(position);
			img.setImageBitmap(BitmapFactory.decodeFile(path));
			InsertData(path);
		}
	}
	
	public void down(View v){
		if(position < ImageList.toArray().length-1) {
			position++;
			String path = ImageList.get(position);
			img.setImageBitmap(BitmapFactory.decodeFile(path));
			InsertData(path);
		}
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}