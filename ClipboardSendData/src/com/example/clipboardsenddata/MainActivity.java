package com.example.clipboardsenddata;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				/**
				 * 传递简单数据
				 */
//				ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//				clipboardManager.setText("剪切板中的数据");
//				Intent intent = new Intent(MainActivity.this,OtherActivity.class);
//				startActivity(intent);
				
				/**
				 * 传递复杂数据
				 */
				String title ="数据传递";
				String content = "剪切板传递复杂数据";
				ClipboardData cData = new ClipboardData(title, content);
				
				ByteArrayOutputStream baOutputStream = new ByteArrayOutputStream();
				String mclipData = "";
				
				try {
					ObjectOutputStream obOutputStream = new ObjectOutputStream(baOutputStream);
					obOutputStream.writeObject(cData);
					mclipData = Base64.encodeToString(baOutputStream.toByteArray(), Base64.DEFAULT);
					baOutputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
				clipboardManager.setText(mclipData);
				Intent intent = new Intent(MainActivity.this,OtherActivity.class);
				startActivity(intent);
			}
		});
 
	}

}
