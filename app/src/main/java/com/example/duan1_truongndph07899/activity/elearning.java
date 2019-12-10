package com.example.duan1_truongndph07899.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.duan1_truongndph07899.R;

public class elearning extends Activity {

    WebView wb;
    ImageView giupdo, menuchinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elearning);
        giupdo = (ImageView) findViewById(R.id.hinhgiupdo);
        menuchinh = (ImageView) findViewById(R.id.hinhbackmenu);
        wb = (WebView) findViewById(R.id.webView1);
        wb.loadUrl("http://m.youtube.com/results?gl=US&client=mv-google&hl=vi&q=hoc+tieng+anh");
        wb.setWebViewClient(new WebViewClient());
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);


        menuchinh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }

        });
    }
}
