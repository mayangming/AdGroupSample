package com.ad.libary.kind;

import android.app.Activity;
import android.view.ViewGroup;

import com.ad.libary.simple_iml.BannerAdIpc;
import com.qq.e.ads.banner2.UnifiedBannerView;

/**
 * 广点通Banner广告
 */
public class GDTBannerAd extends AdBannerIpc{
    private UnifiedBannerView bv;
    public GDTBannerAd(Activity activity) {
        super(activity);
    }

    @Override
    public void loadAd(String codeId, BannerAdIpc bannerAdIpc) {
        if (null != bv){
            bv.destroy();
        }
        this.bv = new UnifiedBannerView(activity, codeId, bannerAdIpc.getUnifiedBannerADListener());
        bv.loadAD();
    }

    @Override
    public void showBannerAd(ViewGroup viewGroup) {
        viewGroup.removeAllViews();
        viewGroup.addView(bv);
    }
}