package com.example.letschat;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class BluetoothSearchActivity extends Activity {
	
	public static String ID="id";
	
	ArrayAdapter<String> btArrayAdapter;
	BluetoothAdapter mBluetoothAdapter;
	TextView stateBluetooth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ImageView BluetoothSearchImageView=new ImageView(this);
        BluetoothSearchImageView.setImageResource(R.drawable.inner1);
        
        setContentView(BluetoothSearchImageView);
        setContentView(R.layout.activity_bluetooth_search);
        
        mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        
        ListView listDevicesFound=(ListView) findViewById(R.id.myList);
        
        btArrayAdapter=new ArrayAdapter<String> (BluetoothSearchActivity.this,android.R.layout.simple_list_item_single_choice);
        listDevicesFound.setAdapter(btArrayAdapter);
       
        registerReceiver(ActionFoundReceiver,new IntentFilter(BluetoothDevice.ACTION_FOUND));
        
   		 btArrayAdapter.clear();  
 		 mBluetoothAdapter.startDiscovery();  
 		 
 		
 		listDevicesFound.setOnItemClickListener(new OnItemClickListener() {
 			public void onItemClick(AdapterView<?> parent,View view,int position,long id) {
 				Intent i6=new Intent(getApplicationContext(),BluetoothConnetivityActivity.class);
 				i6.putExtra("extra",id);
 				startActivity(i6);
 			}
 		});
    }
    
	private final BroadcastReceiver ActionFoundReceiver=new BroadcastReceiver() {
    	
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String action=intent.getAction();
    		if(BluetoothDevice.ACTION_FOUND.equals(action)) {
    			BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
    			btArrayAdapter.add(device.getName()+"\n"+device.getAddress());
    			btArrayAdapter.notifyDataSetChanged();
    			
    			Log.d("BluetoothSearchActivity",device.getName()+"\n"+device.getAddress());
    		}
		}	
    };

    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	unregisterReceiver(ActionFoundReceiver);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bluetooth_search, menu);
        return true;
    }
}
