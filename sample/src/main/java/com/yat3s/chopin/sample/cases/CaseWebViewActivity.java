package com.yat3s.chopin.sample.cases;

import android.webkit.WebView;

import com.yat3s.chopin.sample.R;

/**
 * Created by Yat3s on 06/07/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public class CaseWebViewActivity extends BaseCaseActivity {
    private static final String BLOG_URL = "http://yat3s.com";

    @Override
    protected int getContentLayoutId() {
        return R.layout.case_activity_web_view;
    }

    @Override
    protected void initialize() {
        setupRefreshHeader("refresh.json", 0.2f, 3000);
        setupLoadingFooter("Plane.json", 0.2f, 1500);

        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.loadUrl(BLOG_URL);
    }
}