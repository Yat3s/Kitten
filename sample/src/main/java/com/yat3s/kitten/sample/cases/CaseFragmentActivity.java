package com.yat3s.kitten.sample.cases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yat3s.kitten.KittenLayout;
import com.yat3s.kitten.decoration.KittenLoadingFooterIndicator;
import com.yat3s.kitten.decoration.KittenRefreshHeaderIndicator;
import com.yat3s.kitten.sample.R;

/**
 * Created by Yat3s on 04/07/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public class CaseFragmentActivity extends AppCompatActivity {

    private KittenLayout mKittenLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.case_activity_fragment);

        mKittenLayout = (KittenLayout) findViewById(R.id.kitten_layout);


        // Configure refresh header.
        KittenRefreshHeaderIndicator kittenRefreshHeaderView = new KittenRefreshHeaderIndicator(this, "refresh.json");
        kittenRefreshHeaderView.setScale(0.2f);
        mKittenLayout.setRefreshHeaderIndicator(kittenRefreshHeaderView);
        mKittenLayout.setOnRefreshListener(new KittenLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mKittenLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mKittenLayout.refreshComplete();
                    }
                }, 3000);
            }
        });

        // Configure loading footer.
        KittenLoadingFooterIndicator kittenLoadingFooterView = new KittenLoadingFooterIndicator(this, "Plane.json");
        kittenLoadingFooterView.setScale(0.2f);
        mKittenLayout.setLoadingFooterIndicator(kittenLoadingFooterView);
        mKittenLayout.setOnLoadMoreListener(new KittenLayout.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mKittenLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mKittenLayout.loadMoreComplete();
                    }
                }, 1500);
            }
        });
    }
}