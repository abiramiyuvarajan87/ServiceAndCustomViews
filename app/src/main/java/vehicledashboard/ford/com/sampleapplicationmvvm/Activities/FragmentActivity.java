package vehicledashboard.ford.com.sampleapplicationmvvm.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import vehicledashboard.ford.com.sampleapplicationmvvm.Fragments.FirstFragment;
import vehicledashboard.ford.com.sampleapplicationmvvm.Fragments.ManualFirstFragment;
import vehicledashboard.ford.com.sampleapplicationmvvm.Fragments.ManualSecondFragment;
import vehicledashboard.ford.com.sampleapplicationmvvm.Fragments.SecondFragment;
import vehicledashboard.ford.com.sampleapplicationmvvm.R;

public class FragmentActivity extends AppCompatActivity {

    @BindView(R.id.first_fragment)
    Button firstFragmentButton;

    @BindView(R.id.second_fragment)
    Button secondFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);
    }

    public void loadFirstFragment(View view) {
        loadFragment(new ManualFirstFragment());
    }

    public void loadSecondFragment(View view) {
        loadFragment(new ManualSecondFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
