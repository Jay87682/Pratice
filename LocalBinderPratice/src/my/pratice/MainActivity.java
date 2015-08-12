package my.pratice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import my.pratice.LocalService;
import my.pratice.LocalService.LocalBinder;



public class MainActivity extends Activity {

	final static String TAG = "LocalBinderDemo";
	LocalService mService;
	//Button mButGetRanNum;
	//boolean mBound = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//mButGetRanNum = (Button)findViewById(R.id.getRandomBut);
		
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		Intent intent = new Intent(this, LocalService.class);
		bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
	}
	
	@Override
	protected void onStop(){
		super.onStop();
		unbindService(mConnection);
	}
	
	
	public void onButtonClick(View v){
		int num = mService.getRandomInt();
		Log.d(TAG, "Get number is " + num);
	}
	
	private ServiceConnection mConnection = new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.d(TAG, "LocalService connection");
			LocalBinder binder = (LocalBinder)service;
			mService = binder.getService();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.d(TAG, "LocalService disconnection");
		}
		
	};
}
