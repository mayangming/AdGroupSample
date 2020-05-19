package com.ad.libary;

import android.content.Context;

import androidx.annotation.NonNull;

import com.ad.libary.config.SDKAdBuild;
import com.ad.libary.type.AdType;

public class AdSdkManager {
    private static Context mContext;
    private SDKAdBuild sdkAdBuild;
    private static AdSdkManager adSdkManager;

    private AdSdkManager(Context context) {
        mContext = context;
    }

    public static AdSdkManager getInstance(Context context) {
        if (null == adSdkManager){
            adSdkManager = new AdSdkManager(context);
        }
        return adSdkManager;
    }

    /**
     * 初始化广告SDK
     * 需要在使用之前进行初始化
     * */
    public void initSDKAd(@NonNull SDKAdBuild sdkAdBuild){
        this.sdkAdBuild = sdkAdBuild;
        switch (sdkAdBuild.type){
            case AD_TT:
                TTAdManagerHolder.init(mContext,sdkAdBuild);
                break;
            case AD_GDT:
                GDTADManagerHolder.get(mContext,sdkAdBuild.mAppId);
        }
    }

    public AdType getAdType(){
        return sdkAdBuild.type;
    }
}