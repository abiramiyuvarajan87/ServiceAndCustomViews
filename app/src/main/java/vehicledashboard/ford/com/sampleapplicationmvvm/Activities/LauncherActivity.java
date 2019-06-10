package vehicledashboard.ford.com.sampleapplicationmvvm.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import vehicledashboard.ford.com.sampleapplicationmvvm.R;
import vehicledashboard.ford.com.sampleapplicationmvvm.Services.MyIntentService;
import vehicledashboard.ford.com.sampleapplicationmvvm.Services.MyService;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent serviceIntent = new Intent(this, MyIntentService.class);
        startService(serviceIntent);
    }

    public void startService(View view) {
        startService(new Intent(this, MyService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }
}
