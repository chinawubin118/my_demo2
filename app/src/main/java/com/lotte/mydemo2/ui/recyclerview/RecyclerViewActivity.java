package com.lotte.mydemo2.ui.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.beanu.arad.Arad;
import com.beanu.arad.base.ToolBarActivity;
import com.lotte.mydemo2.MyToast;
import com.lotte.mydemo2.R;
import com.lotte.mydemo2.adapter.MyRecyclerViewAdapter;
import com.lotte.mydemo2.model.EventModel;
import com.lotte.mydemo2.mvp.contract.RecyclerViewContract;
import com.lotte.mydemo2.mvp.model.RecyclerViewModelImpl;
import com.lotte.mydemo2.mvp.presenter.RecyclerViewPresenterImpl;
import com.lotte.mydemo2.ui.coordinator.CoordinatorActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class RecyclerViewActivity extends ToolBarActivity<RecyclerViewPresenterImpl, RecyclerViewModelImpl> implements RecyclerViewContract.View {

    @BindView(R.id.rcv_school)
    RecyclerView rcvSchool;
    @BindView(R.id.activity_recycler_view)
    RelativeLayout activityRecyclerView;
    @BindView(R.id.rotate_header_list_view_frame)
    PtrClassicFrameLayout mPtrFrame;

    private MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        mAdapter = new MyRecyclerViewAdapter(this, mPresenter.getSchoolList());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvSchool.setLayoutManager(layoutManager);

        rcvSchool.setAdapter(mAdapter);

        setPtr();

        mPresenter.requestSchoolList("山东省", "");
        showProgress(true);
    }

    private void setPtr() {
        mPtrFrame.setLastUpdateTimeRelateObject(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPresenter.requestJinanList("", "济南");//请求所有的学校
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });

        // the following are default settings
        mPtrFrame.setResistance(1.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
        // default is false
        mPtrFrame.setPullToRefresh(false);
        // default is true
        mPtrFrame.setKeepHeaderWhenRefresh(true);
    }

    @Override
    public String setupToolBarTitle() {
        return "学校列表";
    }

    @Override
    public boolean setupToolBarLeftButton(View leftButton) {
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        return true;
    }

    //EventBus发送事件
    public void postEventBus(String schoolName) {
        EventModel.Event1 event1 = new EventModel.Event1(schoolName);
        event1.setEventCode(17011001);
        Arad.bus.post(event1);
    }

    //启动新的页面
    public void startNewActivity() {
        Intent intent = new Intent(this, CoordinatorActivity.class);
        startActivity(intent);
    }

    //取消刷新
    @Override
    public void cancelRefresh() {
        showProgress(false);
        if (mPtrFrame.isRefreshing()) {
            mPtrFrame.refreshComplete();//取消刷新
        }
    }

    @Override
    public void notifyDataSetChanged() {
        mAdapter.notifyDataSetChanged();
    }

    //下拉的时候执行这里
    @Override
    public void notifyJinanList() {
        MyToast.showShortToast(getApplicationContext(), "刷新完成");
        mAdapter.notifyDataSetChanged();
    }
}