package com.ad.libary.kind;

import android.app.Activity;

import com.ad.libary.simple_iml.InteractionExpressAdIpc;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;

/**
 * 广点通插屏广告
 */
public class GDTInteractionExpressAd extends AdInteractionExpressIpc{
    private UnifiedInterstitialAD unifiedInterstitialAD;
    private Activity activity;
    public GDTInteractionExpressAd(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    public void loadAd(String codeId, InteractionExpressAdIpc interactionExpressAdIpc) {
        unifiedInterstitialAD = new UnifiedInterstitialAD(activity, codeId, interactionExpressAdIpc.getUnifiedInterstitialADListener());
        unifiedInterstitialAD.loadAD();
    }

    @Override
    public void destroy() {
        unifiedInterstitialAD.destroy();
    }

    public void showAd(){
        unifiedInterstitialAD.show();
    }

}