package com.group.ad;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.ad.libary.AdSdkManager;
import com.ad.libary.config.SDKAdBuild;
import com.ad.libary.type.AdType;

public class AdApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SDKAdBuild sdkAdBuild = new SDKAdBuild();
        sdkAdBuild.mAppName = "斗圈";
        sdkAdBuild.type = AdType.AD_TT;
        AdSdkManager.getInstance(this).initSDKAd(sdkAdBuild);
    }
}
