package com.lotte.mydemo2.ui.content1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.beanu.arad.Arad;
import com.beanu.arad.base.ToolBarActivity;
import com.lotte.mydemo2.R;
import com.lotte.mydemo2.model.EventModel;
import com.lotte.mydemo2.ui.recyclerview.RecyclerViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Content1Activity extends ToolBarActivity {

    @BindView(R.id.btn_press)
    Button btnPress;
    @BindView(R.id.btn_recyclerviw)
    Button btnRecyclerviw;
    @BindView(R.id.activity_content1)
    RelativeLayout activityContent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content1);
        ButterKnife.bind(this);

        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventModel.Event1 event1 = new EventModel.Event1("呵呵呵......");
                event1.setEventCode(17010999);
                Arad.bus.post(event1);
            }
        });

        btnRecyclerviw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Content1Activity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
