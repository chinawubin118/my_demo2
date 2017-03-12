package com.lotte.mydemo2.ui.multi_type;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.beanu.arad.base.ToolBarActivity;
import com.lotte.mydemo2.R;
import com.lotte.mydemo2.adapter.MultiTypeProvider;
import com.lotte.mydemo2.model.bean.MultiTypeBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MultiTypeListActivity extends ToolBarActivity {

    @BindView(R.id.rcv_multi_type)
    RecyclerView rcvMultiType;

    private MultiTypeAdapter adapter;

    /* Items 等同于 ArrayList<Object> */
    private Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type_list);
        ButterKnife.bind(this);

        adapter = new MultiTypeAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvMultiType.setLayoutManager(layoutManager);

        /* 注册类型和 View 的对应关系 */
        adapter.register(MultiTypeBean.class, new MultiTypeProvider());
        rcvMultiType.setAdapter(adapter);

        /* 模拟加载数据，也可以稍后再加载，然后使用
          * adapter.notifyDataSetChanged() 刷新列表 */
        items = new Items();
        for (int i = 0; i < 20; i++) {
            MultiTypeBean multiTypeBean = new MultiTypeBean();
            multiTypeBean.setName("啦啦啦..." + i);
            items.add(multiTypeBean);
        }
        adapter.setItems(items);
//        adapter.notifyDataSetChanged();
    }

    @Override
    public String setupToolBarTitle() {
        return "MultiTypeListActivity";
    }

    @Override
    protected void onResume() {
        super.onResume();
        getmTitle().setText("新标题...");
    }
}
