package com.example.letschat;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DisableBluetoothActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ImageView BluetoothTypeImageView=new ImageView(this);
        BluetoothTypeImageView.setImageResource(R.drawable.inner1);
        
        setContentView(BluetoothTypeImageView);
        setContentView(R.layout.activity_disable_bluetooth);
        
        Button button6=(Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i4=new Intent(getApplicationContext(),LetsChatActivity.class);
				startActivity(i4);	
			}
		});
        
        BluetoothAdapter mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        if(!mBluetoothAdapter.isEnabled()){
        	
        }
        else{
        	mBluetoothAdapter.disable();
        }
        
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_disable_bluetooth, menu);
        return true;
    }
}
