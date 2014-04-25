package com.example.letschat;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LetsChatActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ImageView LetsChatImageView=new ImageView(this);
        LetsChatImageView.setImageResource(R.drawable.chat1);
        
        setContentView(LetsChatImageView);
        setContentView(R.layout.activity_lets_chat);
    
    	Button button1=(Button) findViewById(R.id.button1);
    	button1.setOnClickListener(new View.OnClickListener(){

    		@Override
    		public void onClick(View v) {
    			Intent i=new Intent(getApplicationContext(),BluetoothTypeActivity.class);
    			startActivity(i);
    		}
    	
    	});
    	
    }
		 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_lets_chat, menu);
        return true;
    }
    
    
}
