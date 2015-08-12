package my.pratice;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;


public class LocalService extends Service{

	private final IBinder mBinder = new LocalBinder();
	private final Random mGenerator = new Random();
	
	public class LocalBinder extends Binder {
		LocalService getService(){
			return LocalService.this;
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	
	public int getRandomInt(){
		return mGenerator.nextInt(100);
	}
	

}
