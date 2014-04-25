package com.example.letschat;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class BluetoothOnActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ImageView BluetoothOnImageView=new ImageView(this);
        BluetoothOnImageView.setImageResource(R.drawable.inner1);
        
        setContentView(BluetoothOnImageView);
        setContentView(R.layout.activity_bluetooth_on);
        
        RadioButton radioButton1=(RadioButton) findViewById(R.id.radioButton1);
        radioButton1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i2=new Intent(getApplicationContext(),EnableBluetoothActivity.class);
				startActivity(i2);
			}
		}); 
		
        RadioButton radioButton2=(RadioButton) findViewById(R.id.radioButton2);
        radioButton2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i3=new Intent(getApplicationContext(),DisableBluetoothActivity.class);
				startActivity(i3);
			}
		}); 
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bluetooth_on, menu);
        return true;
    }
}
