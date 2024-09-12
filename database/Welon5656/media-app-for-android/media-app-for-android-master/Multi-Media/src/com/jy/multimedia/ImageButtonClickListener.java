package com.jy.multimedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class ImageButtonClickListener extends Activity implements OnClickListener {
	
	private Context context;
	private Intent intent;
	
	public ImageButtonClickListener(Context context, Intent intent) {
		this.context = context;
		this.intent = intent;
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		context.startActivity(intent);
	}
	
}