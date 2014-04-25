package com.example.letschat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BluetoothBackActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ImageView BluetoothBackImageView=new ImageView(this);
        BluetoothBackImageView.setImageResource(R.drawable.inner1);
        
        setContentView(BluetoothBackImageView);
        setContentView(R.layout.activity_bluetooth_back);
        
        Button button7=(Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i5=new Intent(getApplicationContext(),BluetoothTypeActivity.class);
				startActivity(i5);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bluetooth_back, menu);
        return true;
    }
}
