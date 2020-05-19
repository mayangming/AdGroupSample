package com.ad.libary.compat;

import android.app.Activity;
import android.content.Context;

import com.ad.libary.AdSdkManager;
import com.ad.libary.kind.AdRewardVideoIpc;
import com.ad.libary.kind.GDTRewardVideoAd;
import com.ad.libary.kind.TTRewardVideoAd;
import com.ad.libary.simple_iml.RewardVideoListenerIpc;
import com.ad.libary.type.AdType;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/**
 * 激励广告的包装类，主要是整合不同广告的来源，并对外提供统一的接口
 */
public class RewardVideoAdCompat implements AdRewardCompatIpc {
    public static int VERTICAL = TTAdConstant.VERTICAL;
    public static int HORIZONTAL = TTAdConstant.HORIZONTAL;
    private Context context;
    private AdType adType = AdType.AD_TT;
    private AdRewardVideoIpc adRewardVideoIpc;
    public RewardVideoAdCompat(Context context) {
        this.context = context;
        this.adType = AdSdkManager.getInstance(context).getAdType();
        switch (adType){
            case AD_TT:
                adRewardVideoIpc = new TTRewardVideoAd(context);
                break;
            case AD_GDT:
                adRewardVideoIpc = new GDTRewardVideoAd(context);
                break;
        }
    }

    @Override
    public void loadAd(String codeId, int orientation, RewardVideoListenerIpc rewardVideoListenerIpc) {
        adRewardVideoIpc.loadAd(codeId,orientation,rewardVideoListenerIpc);
    }

    @Override
    public void showAd(Activity activity) {
        adRewardVideoIpc.showAd(activity);
    }

    @Override
    public void destroy() {
        adRewardVideoIpc.destroy();
    }
}