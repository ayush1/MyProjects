package com.example.letschat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

public class BluetoothConnectivity{
	
	private static final String TAG="BluetoothConnectivity";
	private static final boolean D=true;
	
	private static final String Name="BluetoothConnectivity";
	private static final UUID MY_UUID=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
	
	public static final int STATE_NONE=0;
	public static final int STATE_LISTEN=1;
	public static final int STATE_CONNECTING=2;
	public static final int STATE_CONNECTED=3;
	
	BluetoothAdapter mBluetoothAdapter;
	Handler mHandler;
	AcceptThread mAcceptThread;
	ConnectThread mConnectThread;
	ConnectedThread mConnectedThread;
	int mState;

	//Bundle extras=getIntent().getExtras();
	
	//int id=extras.getInt("ID");
	public BluetoothConnectivity(Context context,Handler handler) {
		
		mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
		mState=STATE_NONE;
		mHandler=handler;
	}
	
	private synchronized void setState(int state) {
		mState=state;
	}
	
	public synchronized int getState() {
		return mState;
	}
	
	public synchronized void start() {
		
		setState(STATE_LISTEN);
		
		if(mAcceptThread==null) {
			mAcceptThread=new AcceptThread(true);
			mAcceptThread.start();
		}
	}
	
	public synchronized void connect(BluetoothDevice device,boolean secure) {
		
		if(D) Log.d(TAG, "connect to:"+device);
		
		mConnectThread=new ConnectThread(device,secure);
		mConnectThread.start();
		setState(STATE_CONNECTING);
	}
	
	public synchronized void connected(BluetoothSocket socket,BluetoothDevice device,final String socketType) {
		
		if(D) Log.d(TAG,"connected Socket Type:"+socketType);
		
		mConnectedThread=new ConnectedThread(socket,socketType);
		mConnectedThread.start();
		setState(STATE_CONNECTED);
	}
	
	
	private class ConnectThread extends Thread{
		private final BluetoothSocket mSocket;
		private final BluetoothDevice mDevice;
		private String mSocketType;
		
		public ConnectThread(BluetoothDevice device,boolean secure){
			
			String ACTION_PAIRING_REQUEST="android.bluetooth.device.action.PAIRING_REQUEST";
			Intent i7=new Intent(ACTION_PAIRING_REQUEST);
			
			String EXTRA_DEVICE="android.bluetooth.device.extra.DEVICE";
			i7.putExtra(EXTRA_DEVICE,device);
			
			String EXTRA_PAIRING_VARIANT="android.bluetooth.device.extra.PAIRING_VARIANT";
			int PAIRING_VARIANT_PIN=1234;
			i7.putExtra(EXTRA_PAIRING_VARIANT, PAIRING_VARIANT_PIN);
			
			mDevice=device;
			BluetoothSocket temp=null;
			
			try{
				temp=device.createRfcommSocketToServiceRecord(MY_UUID);
			}catch(IOException e){
				Log.e(TAG,"Socket Type:"+mSocketType+"create() failed",e);
			}
			
			mSocket=temp;
		}
		
		public void run(){
			Log.i(TAG,"BEGIN mConnectThread SocketType:"+mSocketType);
			setName("Connect Thread"+mSocketType);
			mBluetoothAdapter.cancelDiscovery();
			
			try{
				mSocket.connect();
			}catch(IOException e){
				try{
					mSocket.close();
				}catch(IOException e2){
					Log.e(TAG,"unable to close()"+mSocketType+"socket during connection failure" ,e2);
				}
				
				return;
			}
			
			synchronized(BluetoothConnectivity.this){
				mConnectThread=null;
			}
	
			connected(mSocket,mDevice,mSocketType);
		}
		
		public void cancle(){
			try{
				mSocket.close();
			}catch(IOException e){ }
		
		}	
	}
	
	
	
	private class AcceptThread extends Thread {
		
		private final BluetoothServerSocket mServerSocket;
		private String mSocketType;
		
		public AcceptThread(boolean secure) {
			
			BluetoothServerSocket temp=null;
			
			try{
				temp=mBluetoothAdapter.listenUsingRfcommWithServiceRecord(Name, MY_UUID);
			}catch(IOException e) { }
			mServerSocket=temp;
		}
		
		public void run() {
			
			if(D) Log.d(TAG,"Socket Type:"+mSocketType+"BEGIN mAcceptThread"+this);
			setName("AcceptThread"+mSocketType);
			
			BluetoothSocket socket=null;
			
			while(mState!=STATE_CONNECTED){
				try{
					socket=mServerSocket.accept();
				}catch(IOException e){
					Log.e(TAG,"Socket Type:"+mSocketType+"accept() failed",e);
					break;
				}
				
				if(socket!=null){
					synchronized(BluetoothConnectivity.this){
						switch(mState){
						case STATE_LISTEN:
						case STATE_CONNECTING:
							connected(socket,socket.getRemoteDevice(),mSocketType);
							break;
						case STATE_NONE:
						case STATE_CONNECTED:
							try{
								socket.close();
							}catch(IOException e){ 
								Log.e(TAG,"Could not close unwanted socket",e);
							}
							break;
						}
					}
				}
			}
			if(D) Log.i(TAG,"END mAcceptThread,socketType:"+mSocketType);
		}
		
		public void cancle(){
			try{
				mServerSocket.close();
			}catch(IOException e){ }
		}	
	}
	
	
	
	
	
	private class ConnectedThread extends Thread{
		private final BluetoothSocket mSocket;
		private final InputStream mInputStream;
		private final OutputStream mOutputStream;
		
		public ConnectedThread(BluetoothSocket socket,String socketType){
			
			mSocket=socket;
			InputStream tempIn=null;
			OutputStream tempOut=null;
			
			try{
				tempIn=socket.getInputStream();
				tempOut=socket.getOutputStream();
			}catch(IOException e){ }
			
			mInputStream=tempIn;
			mOutputStream=tempOut;
		}
		
		public void run(){
		
			byte[] buffer=new byte[1024];
			int bytes;
		
			while(true){
				try{
					bytes=mInputStream.read(buffer);
				}catch(IOException e){
					break;
				}
			}
		}
	
		public void cancel(){
			try{
				mSocket.close();
			}catch(IOException e){ }
		}
	}
}
	
