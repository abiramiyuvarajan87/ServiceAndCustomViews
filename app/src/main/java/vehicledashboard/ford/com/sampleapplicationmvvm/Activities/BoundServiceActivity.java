package vehicledashboard.ford.com.sampleapplicationmvvm.Activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vehicledashboard.ford.com.sampleapplicationmvvm.R;
import vehicledashboard.ford.com.sampleapplicationmvvm.Services.BoundService;
import vehicledashboard.ford.com.sampleapplicationmvvm.Services.BoundService.MyBinder;

public class BoundServiceActivity extends AppCompatActivity {

    @BindView(R.id.timestamp_textview)
    TextView timeStamp;
    BoundService mBoundService;
    boolean mServiceBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }

    public void printTimestamp(View view) {
        timeStamp.setText(mBoundService.getTimestamp());
    }

    public void stopService(View view) {
        if(mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }

        Intent intent = new Intent(BoundServiceActivity.this, BoundService.class);
        stopService(intent);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBinder myBinder = (MyBinder) iBinder;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mServiceBound = false;
        }
    };
}
