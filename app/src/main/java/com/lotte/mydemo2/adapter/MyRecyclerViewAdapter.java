package com.lotte.mydemo2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beanu.arad.support.recyclerview.adapter.BaseLoadMoreAdapter;
import com.lotte.mydemo2.R;
import com.lotte.mydemo2.model.bean.School;
import com.lotte.mydemo2.ui.recyclerview.RecyclerViewActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class MyRecyclerViewAdapter extends BaseLoadMoreAdapter<School, RecyclerView.ViewHolder> {

    public MyRecyclerViewAdapter(Context context, List<School> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent) {
        MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.item_my_recyclerview, parent, false));
        return holder;
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.tv_name.setText(list.get(position).getName());

        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RecyclerViewActivity) context).postEventBus(list.get(position).getName());
                ((RecyclerViewActivity) context).startNewActivity();
            }
        });
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
