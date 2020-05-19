package com.ad.libary.kind;

import android.app.Activity;
import android.content.Context;

import com.ad.libary.TTAdManagerHolder;
import com.ad.libary.simple_iml.RewardVideoListenerIpc;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;

/**
 * 穿山甲激励视频
 */
public class TTRewardVideoAd extends AdRewardVideoIpc {
    private TTAdNative mTTAdNative;
    private RewardVideoListenerIpc rewardVideoListenerIpc;


    public TTRewardVideoAd(Context context) {
        super(context);
        mTTAdNative = TTAdManagerHolder.get().createAdNative(context);
    }

    public void loadAd(String codeId, int orientation, RewardVideoListenerIpc rewardVideoListenerIpc){
        this.rewardVideoListenerIpc = rewardVideoListenerIpc;
        loadTTRewardVideoAd(codeId,orientation,rewardVideoListenerIpc);
    }

    public void showAd(Activity activity){
        rewardVideoListenerIpc.showRewardAd(activity);
    }

    private void loadTTRewardVideoAd(String codeId, int orientation, RewardVideoListenerIpc rewardVideoListenerIpc){
        AdSlot adSlot = new AdSlot.Builder()
                .setCodeId(codeId)
                .setSupportDeepLink(true)
                .setImageAcceptedSize(1080, 1920)
                .setRewardName("金币") //奖励的名称
                .setRewardAmount(3)  //奖励的数量
                .setUserID("user123")//用户id,必传参数
                .setMediaExtra("media_extra") //附加参数，可选
                .setExpressViewAcceptedSize(400,600)
                .setOrientation(orientation) //必填参数，期望视频的播放方向：TTAdConstant.HORIZONTAL 或 TTAdConstant.VERTICAL
                .build();
        mTTAdNative.loadRewardVideoAd(adSlot, rewardVideoListenerIpc.getRewardVideoAdListener());
    }

    @Override
    public void destroy() {
        rewardVideoListenerIpc.destroy();
    }
}