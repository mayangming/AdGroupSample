package com.ad.libary.compat;

import android.app.Activity;

import com.ad.libary.AdSdkManager;
import com.ad.libary.kind.AdInteractionExpressIpc;
import com.ad.libary.kind.GDTInteractionExpressAd;
import com.ad.libary.kind.TTInteractionExpressAd;
import com.ad.libary.simple_iml.InteractionExpressAdIpc;
import com.ad.libary.type.AdType;


/**
 * 插屏广告包装类
 */
public class InteractionExpressAdCompat implements AdInteractionExpressCompatIpc{
    private AdType adType = AdType.AD_TT;
    private Activity activity;
    private AdInteractionExpressIpc adInteractionExpressIpc;
    public InteractionExpressAdCompat(Activity activity) {
        this.activity = activity;
        this.adType = AdSdkManager.getInstance(activity).getAdType();
        switch (adType){
            case AD_GDT:
                adInteractionExpressIpc = new GDTInteractionExpressAd(activity);
                break;
            case AD_TT:
                adInteractionExpressIpc = new TTInteractionExpressAd(activity);
                break;
        }
    }

    @Override
    public void loadAd(String codeId, InteractionExpressAdIpc interactionExpressAdIpc) {
        adInteractionExpressIpc.loadAd(codeId,interactionExpressAdIpc);
    }

    @Override
    public void showAd() {
        adInteractionExpressIpc.showAd();
    }

    @Override
    public void destroy() {
        adInteractionExpressIpc.destroy();
    }
}