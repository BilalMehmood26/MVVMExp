package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.Model.NicePlace;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceAdapter extends RecyclerView.Adapter<NicePlaceAdapter.ViewHolder> {

    private List<NicePlace> nicePlaceList = new ArrayList<>();
    private Context context;

    public NicePlaceAdapter(List<NicePlace> nicePlaceList, Context context) {
        this.nicePlaceList = nicePlaceList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(holder.itemView.getContext()).
                setDefaultRequestOptions(requestOptions)
                .load(nicePlaceList.get(position).getmImageUrl())
                .into(holder.mImage);
        holder.mTitle.setText(nicePlaceList.get(position).getmTitle());
    }

    @Override
    public int getItemCount() {

        if(nicePlaceList!= null){
            return nicePlaceList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        ImageView mImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.title_tv);
            mImage = itemView.findViewById(R.id.image_view);
        }
    }
}
