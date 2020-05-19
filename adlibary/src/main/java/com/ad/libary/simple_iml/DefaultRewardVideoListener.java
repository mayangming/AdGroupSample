package com.ad.libary.simple_iml;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/**
 * 激励视频默认监听
 */
public class DefaultRewardVideoListener implements TTAdNative.RewardVideoAdListener{
    @Override
    public void onError(int i, String s) {

    }

    @Override
    public void onRewardVideoAdLoad(TTRewardVideoAd ttRewardVideoAd) {

    }

    @Override
    public void onRewardVideoCached() {

    }
}