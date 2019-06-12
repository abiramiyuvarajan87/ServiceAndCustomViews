package vehicledashboard.ford.com.sampleapplicationmvvm.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import vehicledashboard.ford.com.sampleapplicationmvvm.R;

public class ActivityLifecycleSecondActivity extends AppCompatActivity {

    private static final String SECOND_ACTIVITY_TAG_NAME = ActivityLifecycleSecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_second);
        printLog("Activity created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        printLog("Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        printLog("Activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        printLog("Activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        printLog("Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        printLog("Activity destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        printLog("Activity restarted");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        printLog("Activity post created");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        printLog("Activity post resumed");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        printLog("Activity on back pressed");
    }

    public void finishActivity(View view) {
        finish();
    }

    private void printLog(String description) {
        Log.e(SECOND_ACTIVITY_TAG_NAME, description);
    }
}
