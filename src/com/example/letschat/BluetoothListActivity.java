package com.example.letschat;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class BluetoothListActivity extends Activity {

	BluetoothAdapter mBluetoothAdapter;
	TextView stateBluetooth;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        
        CheckBluetoothState();

    }
        
        private void CheckBluetoothState(){
        	if(mBluetoothAdapter==null){
        		stateBluetooth.setText("Bluetooth NOT supported");
        	}
        	else{
        		if(mBluetoothAdapter.isEnabled()){
						Intent i5=new Intent(getApplicationContext(),BluetoothSearchActivity.class);
		        		startActivity(i5);	
        		}
        		else{
        			Intent i4=new Intent(getApplicationContext(),BluetoothBackActivity.class);
        			startActivity(i4);
        		}
        	}
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bluetooth_list, menu);
        return true;
    }
}
