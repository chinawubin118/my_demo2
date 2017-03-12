package com.lotte.mydemo2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lotte.mydemo2.R;
import com.lotte.mydemo2.model.bean.MultiTypeBean;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by Administrator on 2017/2/8.
 */

public class MultiTypeProvider extends ItemViewProvider<MultiTypeBean, MultiTypeProvider.MultiTypeViewHolder> {

    @NonNull
    @Override
    protected MultiTypeViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_multi_type, parent, false);
        return new MultiTypeViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull MultiTypeViewHolder holder, @NonNull MultiTypeBean multiTypeBean) {
        if (null != multiTypeBean && !TextUtils.isEmpty(multiTypeBean.getName())) {
            holder.tvName.setText(multiTypeBean.getName());
        } else {
            holder.tvName.setText("数据为空.....");
        }
    }

    static class MultiTypeViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public MultiTypeViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
