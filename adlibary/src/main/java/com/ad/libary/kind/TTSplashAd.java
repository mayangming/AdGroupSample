package com.ad.libary.kind;

import android.content.Context;
import android.view.ViewGroup;

import com.ad.libary.TTAdManagerHolder;
import com.ad.libary.simple_iml.SdkSplashIpc;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;

/**
 * 穿山甲开屏广告
 * */
public class TTSplashAd extends AdSplashIpc{
//    private Context context;
    private TTAdNative mTTAdNative;
    private SdkSplashIpc sdkSplashIpc;
    public TTSplashAd(Context context){
        super(context);
        mTTAdNative = TTAdManagerHolder.get().createAdNative(context);
    }

    /**
     * @param adCode 广告ID
     */
    public void loadSplash(String adCode, SdkSplashIpc splashAdListener){
        loadSplash(adCode,3000,splashAdListener);
    }
    /**
     * @param adCode 广告ID
     * @param timeOut 广告超时时间，默认3000秒
     */
    public void loadSplash(String adCode, int timeOut, SdkSplashIpc splashAdListener){
        this.sdkSplashIpc = splashAdListener;
        //step3:创建开屏广告请求参数AdSlot,具体参数含义参考文档
        AdSlot adSlot = new AdSlot.Builder()
//                .setCodeId("801121648")
                .setCodeId(adCode)
                .setSupportDeepLink(true)
                .setImageAcceptedSize(1080, 1920)
                .build();
        //step4:请求广告，调用开屏广告异步请求接口，对请求回调的广告作渲染处理
        mTTAdNative.loadSplashAd(adSlot, splashAdListener.getTtAdListener(),timeOut);
    }

    /**
     * 显示广告
     * @param container
     */
    @Override
    public void showSplashAd(ViewGroup container) {
        container.removeAllViews();
        container.addView(sdkSplashIpc.getDefaultTTSplashAd().getSplashView());
    }
}