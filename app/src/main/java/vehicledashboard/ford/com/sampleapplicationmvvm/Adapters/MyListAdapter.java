package vehicledashboard.ford.com.sampleapplicationmvvm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import vehicledashboard.ford.com.sampleapplicationmvvm.Models.MyListData;
import vehicledashboard.ford.com.sampleapplicationmvvm.R;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

    private MyListData[] myListDataList;

    public MyListAdapter(MyListData[] myListDataList) {
        this.myListDataList = myListDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyListData myListData = myListDataList[position];
        holder.imageView.setImageResource(myListData.getList_item_image_id());
        holder.textView.setText(myListData.getList_item_text());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "click on item: "+myListData.getList_item_text(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myListDataList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_item_image)
        public ImageView imageView;
        @BindView(R.id.list_item_text)
        public AppCompatTextView textView;
        @BindView(R.id.list_item_layout)
        public RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
