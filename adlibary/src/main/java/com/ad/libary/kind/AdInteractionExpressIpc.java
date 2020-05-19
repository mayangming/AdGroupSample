package com.ad.libary.kind;

import android.content.Context;

import com.ad.libary.compat.AdInteractionExpressCompatIpc;

/**
 * 插屏广告基础类
 */
public abstract class AdInteractionExpressIpc implements AdInteractionExpressCompatIpc {
    private Context context;

    public AdInteractionExpressIpc(Context context) {
        this.context = context;
    }
}