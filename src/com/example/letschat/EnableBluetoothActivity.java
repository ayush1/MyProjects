package com.example.letschat;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EnableBluetoothActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        BluetoothAdapter mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter==null){
        	System.out.println("\nBluetooth Not Supported,Aborting.");
        	return;
        }
        if(!mBluetoothAdapter.isEnabled()){
        	mBluetoothAdapter.enable();
        }  
        
        ImageView EnableBluetoothImageView=new ImageView(this);
        EnableBluetoothImageView.setImageResource(R.drawable.inner1);
        
        setContentView(EnableBluetoothImageView);
        setContentView(R.layout.activity_enable_bluetooth);
        
        Button button5=(Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i3=new Intent(getApplicationContext(),BluetoothLayoutActivity.class);
				startActivity(i3);		
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_enable_bluetooth, menu);
        return true;
    }
}
