package com.lotte.mydemo2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lotte.mydemo2.R;
import com.lotte.mydemo2.model.bean.School;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/10.
 */

public class TestAdapter extends RecyclerView.Adapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<School> schoolList;

    public TestAdapter(Context context, ArrayList<School> schoolList) {
        this.context = context;
        this.schoolList = schoolList;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.item_my_recyclerview, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;

        holder.tv_name.setText(schoolList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return null == schoolList ? 0 : schoolList.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
