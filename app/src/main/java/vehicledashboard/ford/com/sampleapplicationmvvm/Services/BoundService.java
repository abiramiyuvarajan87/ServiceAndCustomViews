package vehicledashboard.ford.com.sampleapplicationmvvm.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

public class BoundService extends Service {
    private static final String TAG = "BoundService";
    private IBinder mBinder = new MyBinder();
    private Chronometer mChronometer;

    public BoundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "In OnCreate");
        mChronometer = new Chronometer(this);
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "In OnBind");
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG, "In onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "In onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "In onDestroy");
        mChronometer.stop();
    }

    public String getTimestamp() {
        long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
        int hours = (int) (elapsedMillis / 3600000);
        int minutes = (int) (elapsedMillis - hours * 3600000) / 60000;
        int seconds = (int) (elapsedMillis - hours * 3600000 - minutes * 60000) / 1000;
        int millis = (int) (elapsedMillis - hours * 3600000 - minutes * 60000 - seconds * 1000);
        return hours + ":" + minutes + ":" + seconds + ":" + millis;
    }

    public class MyBinder extends Binder {
        public BoundService getService() {
            return BoundService.this;
        }
    }
}
