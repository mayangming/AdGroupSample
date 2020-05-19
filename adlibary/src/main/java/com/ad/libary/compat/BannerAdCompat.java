package com.ad.libary.compat;

import android.app.Activity;
import android.view.ViewGroup;

import com.ad.libary.AdSdkManager;
import com.ad.libary.kind.AdBannerIpc;
import com.ad.libary.kind.GDTBannerAd;
import com.ad.libary.kind.TTBannerAd;
import com.ad.libary.simple_iml.BannerAdIpc;
import com.ad.libary.type.AdType;


/**
 * Banner广告包装类
 */
public class BannerAdCompat implements AdBannerCompatIpc{
    private AdType adType;
    private AdBannerIpc adBannerIpc;
    public BannerAdCompat(Activity activity) {
        this.adType = AdSdkManager.getInstance(activity).getAdType();
        switch (adType){
            case AD_GDT:
                adBannerIpc = new GDTBannerAd(activity);
                break;
            case AD_TT:
                adBannerIpc = new TTBannerAd(activity);
                break;
        }
    }

    @Override
    public void loadAd(String codeId, BannerAdIpc bannerAdIpc) {
        adBannerIpc.loadAd(codeId,bannerAdIpc);
    }

    @Override
    public void showBannerAd(ViewGroup viewGroup) {
        adBannerIpc.showBannerAd(viewGroup);
    }
}