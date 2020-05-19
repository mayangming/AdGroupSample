package com.ad.libary.kind;

import android.app.Activity;

import com.ad.libary.TTAdManagerHolder;
import com.ad.libary.simple_iml.InteractionExpressAdIpc;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;

/**
 * 穿山甲插屏广告
 */
public class TTInteractionExpressAd extends AdInteractionExpressIpc{
    private TTAdNative mTTAdNative;
    private InteractionExpressAdIpc interactionExpressAdIpc;
    private Activity activity;
    public TTInteractionExpressAd(Activity activity){
        super(activity);
        this.activity = activity;
        mTTAdNative = TTAdManagerHolder.get().createAdNative(activity);
    }

    public void loadAd(String codeId, InteractionExpressAdIpc interactionExpressAdIpc){
        this.interactionExpressAdIpc = interactionExpressAdIpc;
        //step4:创建广告请求参数AdSlot,具体参数含义参考文档
        AdSlot adSlot = new AdSlot.Builder()
                .setCodeId(codeId) //广告位id
                .setSupportDeepLink(true)
                .setAdCount(1) //请求广告数量为1到3条
                .setExpressViewAcceptedSize(1080,1920) //期望个性化模板广告view的size,单位dp
                .setImageAcceptedSize(640,320 )//这个参数设置即可，不影响个性化模板广告的size
                .build();
        mTTAdNative.loadInteractionExpressAd(adSlot, interactionExpressAdIpc.getNativeExpressAdListener());
    }

    @Override
    public void showAd() {
        interactionExpressAdIpc.getTtNativeExpressAd().showInteractionExpressAd(activity);
    }

    public void destroy(){
        interactionExpressAdIpc.destroy();
    }

}