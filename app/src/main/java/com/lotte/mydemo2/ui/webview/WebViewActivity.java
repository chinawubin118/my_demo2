package com.lotte.mydemo2.ui.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.beanu.arad.base.ToolBarActivity;
import com.lotte.mydemo2.MyToast;
import com.lotte.mydemo2.R;
import com.lotte.mydemo2.util.PhotoCheckActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends ToolBarActivity implements View.OnClickListener {

    @BindView(R.id.webView)
    WebView webview;
    @BindView(R.id.tvAndroidButton)
    TextView tvAndroidButton;
    @BindView(R.id.tv_stop)
    TextView tvStop;
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        url = "file:///android_asset/www/test_1.html";

        contentLoading();

        setWebView();
        setOnClickListener();
    }

    private void setOnClickListener() {
        tvAndroidButton.setOnClickListener(this);
        tvStart.setOnClickListener(this);
        tvStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvAndroidButton) {//点击按钮调用js中方法
            webview.loadUrl("javascript:functionInjs()");
//                Toast.makeText(getApplicationContext(), "调用javascript:funFromjs()", Toast.LENGTH_LONG).show();
        }
        if (v == tvStop) {
            webview.loadUrl("javascript:stop()");
        }
        if (v == tvStart) {
            webview.loadUrl("javascript:startTimer()");
        }
    }

    //设置webView
    private void setWebView() {

        WebSettings settings = webview.getSettings();

        //设置支持js
        settings.setJavaScriptEnabled(true);
        //设置编码
        settings.setDefaultTextEncodingName("utf-8");
        //自适应屏幕
//        settings.setUseWideViewPort(true);//關鍵點
//        settings.setLoadWithOverviewMode(true);
//        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        //设置本地调用对象及其接口
        webview.addJavascriptInterface(new JavaScriptObject(this), "androidObj");

        webview.setWebViewClient(new WebViewClient() { //调用自身，不调用系统浏览器
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }
        });

        webview.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.i("wubin", "onReceivedTitle()...title = " + title);
                getmTitle().setText(title);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                Log.i("wubin", "onJsAlert()...");
                return super.onJsAlert(view, url, message, result);
            }
        });
        webview.loadUrl(url);
    }

    @Override
    public String setupToolBarTitle() {
        return "正在加载页面...";
    }

    //里面的方法供js使用
    public class JavaScriptObject {
        Context mContxt;

        public JavaScriptObject(Context mContxt) {
            this.mContxt = mContxt;
        }

        //sdk17版本以上加上注解
        @JavascriptInterface
        public void finishByJs() {
            finish();
        }

        public void fun2(String name) {
            Toast.makeText(mContxt, "调用fun2:" + name, Toast.LENGTH_SHORT).show();
        }

        //sdk17版本以上加上注解
        @JavascriptInterface
        public void fun_check_image(String imgPath) {
            MyToast.showShortToast(mContxt, "js调安卓中的方法..." + imgPath);
        }

        //sdk17版本以上加上注解
        @JavascriptInterface
        public void show_a_toast_by_js(String str) {
            MyToast.showShortToast(mContxt, str);
        }

        //sdk17版本以上加上注解
        @JavascriptInterface
        public void getImgName(int imgIndex) {
            MyToast.showShortToast(mContxt, "图片的index = " + imgIndex);
//            LotteUtil.loadDataFromAsset();
            Intent intent = new Intent(WebViewActivity.this, PhotoCheckActivity.class);

            ArrayList<String> list = new ArrayList();

            for (int i = 1; i <= 4; i++) {
                String path = "file:///android_asset/www/img/" + i + ".png";
                list.add(path);
            }

            intent.putExtra("list", list);
            intent.putExtra("position", imgIndex);
            startActivity(intent);
        }
    }
}
