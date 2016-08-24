package com.example.clipboardsenddata;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

public class OtherActivity extends Activity {
	
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		tv = (TextView) findViewById(R.id.tv);
		ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//		@SuppressWarnings("deprecation")
//		String data = clipboardManager.getText().toString();
//		tv.setText(data);

		@SuppressWarnings("deprecation")
		String mData = clipboardManager.getText().toString();
		byte[] base_byte = Base64.decode(mData, Base64.DEFAULT);
		ByteArrayInputStream baInputStream = new ByteArrayInputStream(base_byte);
		try {
			ObjectInputStream obInputStream = new ObjectInputStream(baInputStream);
			ClipboardData cData = (ClipboardData) obInputStream.readObject();
			tv.setText(cData.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
