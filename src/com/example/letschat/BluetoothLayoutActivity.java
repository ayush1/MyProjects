package com.example.letschat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class BluetoothLayoutActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bluetooth_layout, menu);
        return true;
    }
}
