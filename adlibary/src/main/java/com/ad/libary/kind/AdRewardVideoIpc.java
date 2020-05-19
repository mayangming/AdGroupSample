package com.ad.libary.kind;

import android.content.Context;

import com.ad.libary.compat.AdRewardCompatIpc;


/**
 * 激励视频基础接口
 */
public abstract class AdRewardVideoIpc implements AdRewardCompatIpc {
    Context context;
    public AdRewardVideoIpc(Context context) {
        this.context = context;
    }
}