package com.lujunwu.mvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by lujunwu on 2018/3/6.
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecViewHolder> {
    Context context;
    List<Beauty.ResultsBean> resultsBeans;

    public RecAdapter(Context context, List<Beauty.ResultsBean> resultsBeans) {
        this.context = context;
        this.resultsBeans = resultsBeans;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {
        Glide.with(context).load(resultsBeans.get(position).getUrl()).into(holder.mIvBeauty);
    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIvBeauty;

        public RecViewHolder(View itemView) {
            super(itemView);
            mIvBeauty = (ImageView) itemView.findViewById(R.id.beauty_iv);
        }
    }
}
