package com.yat3s.chopin.indicator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.yat3s.chopin.ChopinLayout;

/**
 * Created by Yat3s on 06/08/2017.
 * Email: hawkoyates@gmail.com
 * GitHub: https://github.com/yat3s
 */
public class LottieIndicator extends LottieAnimationView implements Indicator {
    public LottieIndicator(Context context) {
        super(context);
    }

    public LottieIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LottieIndicator(Context context, String animationFileName) {
        super(context);
        setAnimation(animationFileName);
    }

    public LottieIndicator(Context context, String animationFileName, float scale) {
        this(context, animationFileName);
        setScale(scale);
    }

    public LottieIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onViewMeasured(ChopinLayout chopinLayout, View indicatorView) {
        loop(true);
    }

    @Override
    public void onCancel(ChopinLayout chopinLayout) {
        cancelAnimation();
    }

    @Override
    public void onStart(ChopinLayout chopinLayout) {
        playAnimation();
    }

    @Override
    public void onComplete(ChopinLayout chopinLayout) {
        cancelAnimation();
    }

    @Override
    public void onPositionChange(ChopinLayout chopinLayout, float progress, STATE state, int touchX, int touchY) {
        if ((state == STATE.DRAGGING_DOWN || state == STATE.DRAGGING_UP)
                && progress <= 1f && progress >= 0f) {
            setProgress(progress);
        }
    }
}
