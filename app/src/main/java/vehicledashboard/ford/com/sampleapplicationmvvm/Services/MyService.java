package vehicledashboard.ford.com.sampleapplicationmvvm.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "Service OnCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "Service onStartCommand " +startId);

        int i=0;
        while (i <3) {
            try{
                Thread.sleep(1000);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.e(TAG, "Service Running");
        }
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "Service onBind");
        throw null;
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "Service onDestroy");
    }
}
