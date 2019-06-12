package vehicledashboard.ford.com.sampleapplicationmvvm.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import vehicledashboard.ford.com.sampleapplicationmvvm.R;

public class ManualFirstFragment extends Fragment {

    View view;

    @BindView(R.id.first_fragment)
    Button firstFragmentButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(view, container);
        firstFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "First Fragment", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
