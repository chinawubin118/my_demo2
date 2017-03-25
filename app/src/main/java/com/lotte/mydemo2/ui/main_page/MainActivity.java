package com.lotte.mydemo2.ui.main_page;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.a26c.android.frame.widget.BaseRecyclerView;
import com.beanu.arad.Arad;
import com.beanu.arad.base.ToolBarActivity;
import com.lotte.mydemo2.MyToast;
import com.lotte.mydemo2.R;
import com.lotte.mydemo2.adapter.TestAdapter;
import com.lotte.mydemo2.model.EventModel;
import com.lotte.mydemo2.model.bean.School;
import com.lotte.mydemo2.mvp.contract.MainPageContract;
import com.lotte.mydemo2.mvp.model.MainPageModelImpl;
import com.lotte.mydemo2.mvp.presenter.MainPagePresenterImpl;
import com.lotte.mydemo2.ui.content1.Content1Activity;
import com.lotte.mydemo2.ui.coordinator.CoordinatorActivity;
import com.lotte.mydemo2.ui.coordinator.FloatingActionButtonActivity;
import com.lotte.mydemo2.ui.multi_type.MultiTypeListActivity;
import com.lotte.mydemo2.ui.test_server.TestServerActivity;
import com.lotte.mydemo2.ui.webview.WebViewActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends ToolBarActivity<MainPagePresenterImpl, MainPageModelImpl> implements MainPageContract.View
        , View.OnClickListener, TextWatcher {
    @BindView(R.id.tv_shortcut)
    TextView tvShortcut;
    @BindView(R.id.tv_shortcut_2)
    TextView tvShortcut2;
    @BindView(R.id.tv_multi_type)
    TextView tv_multi_type;
    @BindView(R.id.tv_web_view)
    TextView tv_web_view;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.text_input_layout)
    TextInputLayout textInputLayout;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    @BindView(R.id.base_recyclerView)
    BaseRecyclerView baseRecyclerView;
    @BindView(R.id.tv_test_server)
    TextView tvTestServer;//测试服务器

    private TextView mTvTest;

    private TestAdapter testAdapter;
    private ArrayList<School> schoolList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTvTest = (TextView) findViewById(R.id.tv_test);

        setListeners();//注册监听

        schoolList = new ArrayList<>();
        testAdapter = new TestAdapter(this, schoolList);

        Arad.bus.register(this);
    }

    private void setListeners() {
        mTvTest.setOnClickListener(this);
        tvShortcut.setOnClickListener(this);
        tvShortcut2.setOnClickListener(this);
        tv_multi_type.setOnClickListener(this);
        tv_web_view.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
        tvTestServer.setOnClickListener(this);

        editText.addTextChangedListener(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void test(EventModel.Event1 event1) {
        if (event1.getEventCode() == 17011001) {//设置学校的事件码
            mTvTest.setText(event1.getEventStr() + ",事件dcode = " + event1.getEventCode());
        } else {
            MyToast.showShortToast(getApplicationContext(), "不生效了...");
        }
    }

    @Override
    public void onClick(View v) {
        if (v == mTvTest) {
            Intent intent = new Intent(this, Content1Activity.class);
            startActivity(intent);
        }
        if (v == tvShortcut) {
            Intent intent = new Intent(this, CoordinatorActivity.class);
            startActivity(intent);
        }
        if (v == tvShortcut2) {
            Intent intent = new Intent(this, FloatingActionButtonActivity.class);
            startActivity(intent);
        }
        if (v == btnConfirm) {
            if (!TextUtils.equals("111", editText.getText().toString().trim())) {
                textInputLayout.setError("密码输入错误");
            } else {
                textInputLayout.setError("密码正确");
            }
        }
        if (v == tv_multi_type) {//多类型item
            Intent intent = new Intent(this, MultiTypeListActivity.class);
            startActivity(intent);
        }
        if (v == tv_web_view) {
            Intent intent = new Intent(this, WebViewActivity.class);
            startActivity(intent);
        }
        if (v == tvTestServer) {
            Intent intent = new Intent(this, TestServerActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //取消注册  EventBus
        if (Arad.bus.isRegistered(this)) {
            Arad.bus.unregister(this);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        textInputLayout.setError("");
    }
}
