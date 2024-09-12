package com.jy.multimedia;

import com.jy.image.ImageActivity;
import com.jy.multi_media.R;
import com.jy.music.MusicActivity;
import com.jy.video.VideoActivity;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	private Intent intent_image, intent_video, intent_music;
	private ImageButton btn_image, btn_video, btn_music;
	public static String db_path;
	
	private void init() {
		intent_image = new Intent(this, ImageActivity.class);
		intent_video = new Intent(this, VideoActivity.class);
		intent_music = new Intent(this, MusicActivity.class);
		btn_image = (ImageButton) findViewById(R.id.btn_image);
		btn_image.setOnClickListener(new ImageButtonClickListener(this, intent_image));
		btn_video = (ImageButton) findViewById(R.id.btn_video);
		btn_video.setOnClickListener(new ImageButtonClickListener(this, intent_video));
		btn_music = (ImageButton) findViewById(R.id.btn_music);
		btn_music.setOnClickListener(new ImageButtonClickListener(this, intent_music));
		db_path = this.getFilesDir().toString() + "/MultiMedia.db3";
	}
	
	private void getOverflowMenu() {
		ViewConfiguration viewConfig = ViewConfiguration.get(this);
		
		try {
			Field overflowMenuField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
			if(null != overflowMenuField) {
				overflowMenuField.setAccessible(true);
				overflowMenuField.setBoolean(viewConfig, false);
			}
		}
		catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getOverflowMenu();
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id) {
		case R.id.scanner:
			System.out.print("ok");
			break;
		case R.id.history:
			startActivity(new Intent(this, HistoryActivity.class));
			break;
		case R.id.exit:
			System.out.print("ok");
			finish();
			break;
		}
		return true;
	}

}
