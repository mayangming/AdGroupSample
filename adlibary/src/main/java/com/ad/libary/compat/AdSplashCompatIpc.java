package com.ad.libary.compat;

import android.view.ViewGroup;

import com.ad.libary.simple_iml.SdkSplashIpc;


public interface AdSplashCompatIpc {
    /**
     * 加载开屏广告
     * @param adCode 广告位ID
     * @param timeOut 超时时间
     * @param splashAdListener 加载监听
     */
    void loadSplash(String adCode, int timeOut, SdkSplashIpc splashAdListener);

    /**
     * 加载开屏广告
     * @param adCode 广告位ID
     * @param splashAdListener 加载监听
     */
    void loadSplash(String adCode, SdkSplashIpc splashAdListener);

    /**
     * 显示开屏引导页的广告
     * @param container
     */
    void showSplashAd(ViewGroup container);
}
