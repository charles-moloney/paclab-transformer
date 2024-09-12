package com.jy.multimedia;

import com.jy.multi_media.R;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class HistoryActivity extends Activity {

	private String db_path = MainActivity.db_path;
	private ListView listView;
	private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		listView = (ListView) findViewById(R.id.history_list);
		db = SQLiteDatabase.openOrCreateDatabase(db_path, null);
		try {
			Cursor cursor = db.rawQuery("select * from news_inf", null);
			inflateList(cursor);
		}
		catch(SQLiteException se) {
			// 执行DDL创建数据表
			db.execSQL("create table news_inf(_id integer"
				+ " primary key autoincrement,"
				+ " history varchar(150))");
			Cursor cursor = db.rawQuery("select * from news_inf", null);
			inflateList(cursor);
		}
	}
	
	private void inflateList(Cursor cursor)
	{
		// 填充SimpleCursorAdapter
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(
			HistoryActivity.this,
			R.layout.history_cell, cursor,
			new String[] {"history"}
			, new int[] {R.id.history_cell},
			CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER); //③
		// 显示数据
		listView.setAdapter(adapter);
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

}