package com.ad.libary.simple_iml;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;

/**
 * 开屏广告加载监听
 */
public abstract class SdkSplashIpc {
    TTAdNative.SplashAdListener ttAdListener;
    DefaultTTSplashAd defaultTTSplashAd;
    SplashADListener gdtADListener;
    long millisUntilFinished = 0;
    public abstract void splashOnError(int i, String s);
    public abstract void splashOnTimeout();
    /**
     * 加载完成
     */
    public abstract void splashComplete();

    /**
     * 跳过
     */
    public abstract void OnAdSkip();
    /**
     * 倒计时结束
     */
    public abstract void OnAdTimeOver();

    public SdkSplashIpc() {
        ttAdListener = new TTAdNative.SplashAdListener(){
            @Override
            public void onError(int i, String s) {
                splashOnError(i,s);
            }

            @Override
            public void onTimeout() {
                splashOnTimeout();
            }

            @Override
            public void onSplashAdLoad(final TTSplashAd ttSplashAd) {
                defaultTTSplashAd = new DefaultTTSplashAd(){
                    @NonNull
                    @Override
                    public View getSplashView() {
                        Log.e("YM","getSplashView");
                        return ttSplashAd.getSplashView();
                    }
                };
                ttSplashAd.setSplashInteractionListener(new TTSplashAd.AdInteractionListener(){
                    @Override
                    public void onAdClicked(View view, int i) {

                    }

                    @Override
                    public void onAdShow(View view, int i) {
                        Log.e("YM","onAdShow");
                    }

                    @Override
                    public void onAdSkip() {
                        Log.e("YM","onAdSkip");
                        OnAdSkip();
                    }

                    @Override
                    public void onAdTimeOver() {
                        Log.e("YM","onAdTimeOver");
                        OnAdTimeOver();
                    }
                });
//                splashSplashView(defaultTTSplashAd);
//                splashBuild.container.removeAllViews();
//                splashBuild.container.addView(ttSplashAd.getSplashView());
                splashComplete();
            }
        };


        gdtADListener = new SplashADListener() {
            @Override
            public void onADDismissed() {
                Log.e("YM","onADDismissed");
                if (500 >= millisUntilFinished){//小于等于500的时候是时间到期了,因为时间计算不会精确到0
                    OnAdTimeOver();
                }else {//时间不为0时候是点击跳过的操作
                    OnAdSkip();
                }
                millisUntilFinished = 0;
            }

            @Override
            public void onNoAD(AdError adError) {
                Log.e("YM","onNoAD:"+adError.getErrorCode()+"---message:"+adError.getErrorMsg());
                splashOnError(adError.getErrorCode(),adError.getErrorMsg());
            }

            @Override
            public void onADPresent() {
                Log.e("YM","onADPresent");
            }

            @Override
            public void onADClicked() {
                Log.e("YM","onADClicked");
            }

            @Override
            public void onADTick(long l) {
                Log.e("YM","onADTick:"+l);
                millisUntilFinished = l;
            }

            @Override
            public void onADExposure() {
                Log.e("YM","onADExposure");
            }

            @Override
            public void onADLoaded(long l) {
                Log.e("YM","onADLoaded");
//                splashSplashView(defaultTTSplashAd);
                splashComplete();
            }
        };
    }

    public TTAdNative.SplashAdListener getTtAdListener() {
        return ttAdListener;
    }

    public SplashADListener getGDTAdListener() {
        return gdtADListener;
    }

    public DefaultTTSplashAd getDefaultTTSplashAd() {
        return defaultTTSplashAd;
    }
}