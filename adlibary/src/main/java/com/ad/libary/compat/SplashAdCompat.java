package com.ad.libary.compat;

import android.app.Activity;
import android.view.ViewGroup;

import com.ad.libary.AdSdkManager;
import com.ad.libary.kind.AdSplashIpc;
import com.ad.libary.kind.GDTSplashAd;
import com.ad.libary.kind.TTSplashAd;
import com.ad.libary.simple_iml.SdkSplashIpc;
import com.ad.libary.type.AdType;


/**
 * 开屏广告包装类
 */
public class SplashAdCompat implements AdSplashCompatIpc{
    private AdType adType = AdType.AD_TT;
    private AdSplashIpc adSplashIpc;
    public SplashAdCompat(Activity context) {
        this.adType = AdSdkManager.getInstance(context).getAdType();
        switch (adType){
            case AD_GDT:
                adSplashIpc = new GDTSplashAd(context);
                break;
            case AD_TT:
                adSplashIpc = new TTSplashAd(context);
                break;
        }
    }

    @Override
    public void loadSplash(String adCode, int timeOut, SdkSplashIpc splashAdListener) {
        adSplashIpc.loadSplash(adCode,timeOut,splashAdListener);
    }

    @Override
    public void loadSplash(String adCode, SdkSplashIpc splashAdListener) {
        adSplashIpc.loadSplash(adCode,splashAdListener);
    }

    @Override
    public void showSplashAd(ViewGroup container) {
        adSplashIpc.showSplashAd(container);
    }
}