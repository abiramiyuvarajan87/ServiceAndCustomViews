package vehicledashboard.ford.com.sampleapplicationmvvm.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

import vehicledashboard.ford.com.sampleapplicationmvvm.R;

public class CustomLinearLayout extends LinearLayout {

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.custom_view_linear_layout, this, true);

        String title;
        String subTitle;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomLinearLayout, 0, 0);

        try{
            title = a.getString(R.styleable.CustomLinearLayout_customViewTitle);
            subTitle = a.getString(R.styleable.CustomLinearLayout_customViewText);
        } finally {
            a.recycle();
        }

        //Throws an exception if required attributes are not set
        if(title == null) {
            throw new RuntimeException("No title provided");
        }
        if (subTitle == null) {
            throw new RuntimeException("No Subtitle provided");
        }

        init(title, subTitle);
    }

    private void init (String title, String subTitle) {
        TextView title_textview = (TextView) findViewById(R.id.custom_view_title);
        TextView subtitle_textview = (TextView) findViewById(R.id.custom_view_text);

        title_textview.setText(title);
        subtitle_textview.setText(subTitle);
    }
}
