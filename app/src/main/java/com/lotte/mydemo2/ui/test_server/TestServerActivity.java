package com.lotte.mydemo2.ui.test_server;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.JsonObject;
import com.lotte.mydemo2.MyToast;
import com.lotte.mydemo2.R;
import com.lotte.mydemo2.model.api.APIRetrofit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class TestServerActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_server);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            String name = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                MyToast.showShortToast(getApplicationContext(), "请数输入用户名或密码");
                return;
            }
            APIRetrofit.getDefault().loginToMyServer(name, password)
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<JsonObject>() {
                        @Override
                        public void onCompleted() {
                            Log.i("okhttp", "请求完成.....");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.i("okhttp", "请求错误.....");
                        }

                        @Override
                        public void onNext(JsonObject jsonObject) {
                            Log.i("okhttp", "请求成功.....");
                        }
                    });
            Log.i("okhttp", "name = " + name + ",password = " + password);
        }
    }
}
