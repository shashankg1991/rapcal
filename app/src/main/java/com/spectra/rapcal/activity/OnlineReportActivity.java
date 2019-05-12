package com.spectra.rapcal.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.spectra.rapcal.R;
import com.spectra.rapcal.constants.RapCalConstants;
import com.spectra.rapcal.util.StringUtil;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OnlineReportActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_report);
        Intent intentOnlineReportIntent = getIntent();
        webView=findViewById(R.id.activity_online_report_webView);
        if (null != intentOnlineReportIntent) {
            String reportType = intentOnlineReportIntent.getExtras().getString(RapCalConstants.REPORT_TYPE);
            String reportId = intentOnlineReportIntent.getExtras().getString(RapCalConstants.REPORT_ID);
            String url = null;
            switch (reportType) {
                case RapCalConstants.IGI:
                    url = RapCalConstants.URL_IGI + reportId;
                    break;
                case RapCalConstants.GIA:
                    url = RapCalConstants.URL_GIA + reportId;
                    break;
            }
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
