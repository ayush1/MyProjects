package com.example.letschat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BluetoothTypeActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ImageView BluetoothTypeImageView=new ImageView(this);
        BluetoothTypeImageView.setImageResource(R.drawable.inner1);
        
        setContentView(BluetoothTypeImageView);
        setContentView(R.layout.activity_bluetooth_type);
        
        Button button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i1=new Intent(getApplicationContext(),BluetoothOnActivity.class);
				startActivity(i1);
				
			}
		});
        
        Button button3=(Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i2=new Intent(getApplicationContext(),BluetoothListActivity.class);
				startActivity(i2);
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bluetooth_type, menu);
        return true;
    }
}
