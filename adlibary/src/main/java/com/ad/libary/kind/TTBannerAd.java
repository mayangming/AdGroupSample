package com.ad.libary.kind;

import android.app.Activity;
import android.view.ViewGroup;

import com.ad.libary.TTAdManagerHolder;
import com.ad.libary.simple_iml.BannerAdIpc;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;

/**
 * 穿山甲Banner广告
 */
public class TTBannerAd extends AdBannerIpc{
    private TTAdNative mTTAdNative;
    private BannerAdIpc bannerAdIpc;
    public TTBannerAd(Activity activity) {
        super(activity);
        mTTAdNative = TTAdManagerHolder.get().createAdNative(activity);
    }

    public void loadAd(String codeId, BannerAdIpc bannerAdIpc){
        this.bannerAdIpc = bannerAdIpc;
        //设置广告参数
        AdSlot adSlot = new AdSlot.Builder()
                .setCodeId(codeId) //广告位id
                .setSupportDeepLink(true)
                .setAdCount(1) //请求广告数量为1到3条
                .setExpressViewAcceptedSize(1080,1920) //期望个性化模板广告view的size,单位dp
                .setImageAcceptedSize(640,320 )//这个参数设置即可，不影响个性化模板广告的size
                .build();
        mTTAdNative.loadBannerAd(adSlot,bannerAdIpc.getBannerAdListener());
    }

    public void showBannerAd(ViewGroup viewGroup){
        viewGroup.removeAllViews();
        viewGroup.addView(bannerAdIpc.getBannerView());
    }

}