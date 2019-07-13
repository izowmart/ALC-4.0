package com.example.alc4phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class AboutALC extends AppCompatActivity {

    private WebView mWebview;
    private ProgressBar mProgress;
    private Toolbar webToolbar;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        webToolbar = findViewById(R.id.toolbar_web);
        webToolbar.setTitle("About ALC");
        setSupportActionBar(webToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mWebview = findViewById(R.id.webview);
        mProgress = findViewById(R.id.progress_bar);
        mWebview.getSettings().setJavaScriptEnabled(true);

        mWebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        mWebview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int progress) {
                mProgress.setProgress(progress);
                if (progress == 100) {
                    mProgress.setVisibility(View.GONE);

                } else {
                    mProgress.setVisibility(View.VISIBLE);
                }
            }
        });

        mWebview.loadUrl("https://andela.com/alc/");

    }
}