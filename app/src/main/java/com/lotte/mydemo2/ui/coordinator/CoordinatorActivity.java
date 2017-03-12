package com.lotte.mydemo2.ui.coordinator;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.lotte.mydemo2.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoordinatorActivity extends AppCompatActivity {

    @BindView(R.id.main_backdrop)
    ImageView backdrop;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.floating_action_button)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.floating_action_button_2)
    FloatingActionButton floatingActionButton2;

    private String TAG = "wubin";

    private int coordinatorLayoutHeight = 1;
    private int appBarLayoutHeight = 1;
    private int collapsingToolbarLayoutHeight = 1;
    private int toolbarHeight = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        ButterKnife.bind(this);

//        toolbar.setTitle("我的主页");
        collapsingToolbarLayout.setTitle("我的主页");
        collapsingToolbarLayout.setContentScrimResource(R.drawable.spinner_0);
        collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.transparent));

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //侧边栏的按钮
        toolbar.setNavigationIcon(R.drawable.back);
        //取代原本的actionbar
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //app_bar_layout
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float alpha = Math.abs(verticalOffset) * 1.0f / (appBarLayoutHeight - toolbarHeight);
//                Log.i(TAG, "**********alpha = " + alpha + "**********");
//                Log.i(TAG, "**********verticalOffset = " + verticalOffset + "**********");

                toolbar.setAlpha(alpha);
//                StatusBarUtil.setColor(CoordinatorActivity.this, toolbar.getSolidColor());
            }
        });

        //fab..floating_1ction_button
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "呵呵...", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            coordinatorLayoutHeight = coordinatorLayout.getMeasuredHeight();
            appBarLayoutHeight = appBarLayout.getMeasuredHeight();
            collapsingToolbarLayoutHeight = collapsingToolbarLayout.getMeasuredHeight();
            toolbarHeight = toolbar.getMeasuredHeight();

//            Log.i(TAG, "onWindowFocusChanged: coordinatorLayoutHeight = " + coordinatorLayoutHeight);
//            Log.i(TAG, "onWindowFocusChanged: appBarLayoutHeight = " + appBarLayoutHeight);
//            Log.i(TAG, "onWindowFocusChanged: collapsingToolbarLayoutHeight = " + collapsingToolbarLayoutHeight);
//            Log.i(TAG, "onWindowFocusChanged: toolbarHeight = " + toolbarHeight);
        }
    }
}
