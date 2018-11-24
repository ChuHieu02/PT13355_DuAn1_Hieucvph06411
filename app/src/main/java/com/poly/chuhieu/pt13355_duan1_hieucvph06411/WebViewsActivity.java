package com.poly.chuhieu.pt13355_duan1_hieucvph06411;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewsActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_views);

        //lien ket webview
        String urlfb = " https://www.facebook.com/mum0202 ";
        webView= (WebView) this.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(urlfb);
    }
}
