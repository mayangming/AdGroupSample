package com.ad.libary.kind;

import android.app.Activity;
import android.content.Context;

import com.ad.libary.simple_iml.RewardVideoListenerIpc;
import com.qq.e.ads.rewardvideo.RewardVideoAD;

/**
 * 广点通的激励视频
 */
public class GDTRewardVideoAd extends AdRewardVideoIpc {
    private RewardVideoAD rewardVideoAD;//广点通
    public GDTRewardVideoAd(Context context) {
        super(context);
    }
    private void loadGDTRewardVideoAd(String codeId, RewardVideoListenerIpc rewardVideoListenerIpc){
        rewardVideoAD = new RewardVideoAD(context, codeId, rewardVideoListenerIpc.getRewardVideoADListener()); // 有声播放
        rewardVideoAD.loadAD();
    }

    @Override
    public void loadAd(String codeId, int orientation, RewardVideoListenerIpc rewardVideoListenerIpc) {
        loadGDTRewardVideoAd(codeId, rewardVideoListenerIpc);
    }

    @Override
    public void showAd(Activity activity) {
        rewardVideoAD.showAD(activity);
    }

    @Override
    public void destroy() {

    }
}