package com.ad.libary.simple_iml;

import android.view.View;

import com.bytedance.sdk.openadsdk.TTSplashAd;

/**
 * Splash交互的接口
 * */
public abstract class DefaultAdInteractionListener{
    private TTSplashAd.AdInteractionListener adInteractionListener;

    public DefaultAdInteractionListener() {
        adInteractionListener = new TTSplashAd.AdInteractionListener() {
            @Override
            public void onAdClicked(View view, int i) {
                //开屏广告点击
                dqOnAdClicked(view, i);
            }

            @Override
            public void onAdShow(View view, int i) {
                //开屏广告展示
                dqOnAdShow(view, i);
            }

            @Override
            public void onAdSkip() {
                  //开屏广告跳过
                dqOnAdSkip();
            }

            @Override
            public void onAdTimeOver() {
                //开屏广告倒计时结束
                dqOnAdTimeOver();
            }
        };
    }

    public abstract void dqOnAdClicked(View view, int i);

    public abstract void dqOnAdShow(View view, int i);

    public abstract void dqOnAdSkip();

    public abstract void dqOnAdTimeOver();

    public TTSplashAd.AdInteractionListener getAdInteractionListener() {
        return adInteractionListener;
    }
}