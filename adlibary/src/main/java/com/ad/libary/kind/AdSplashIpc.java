package com.ad.libary.kind;

import android.content.Context;

import com.ad.libary.compat.AdSplashCompatIpc;


/**
 * 开屏广告基础类
 */
public abstract class AdSplashIpc implements AdSplashCompatIpc {
    private Context context;

    public AdSplashIpc(Context context) {
        this.context = context;
    }
}