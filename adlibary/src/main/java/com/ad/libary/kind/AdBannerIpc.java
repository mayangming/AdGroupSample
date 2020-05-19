package com.ad.libary.kind;

import android.app.Activity;

import com.ad.libary.compat.AdBannerCompatIpc;


/**
 * Banner广告基础类
 */
public abstract class AdBannerIpc implements AdBannerCompatIpc {
    public Activity activity;

    public AdBannerIpc(Activity activity) {
        this.activity = activity;
    }
}