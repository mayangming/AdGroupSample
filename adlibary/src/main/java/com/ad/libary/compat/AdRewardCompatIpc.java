package com.ad.libary.compat;

import android.app.Activity;

import com.ad.libary.simple_iml.RewardVideoListenerIpc;


/**
 * 包装类的接口
 */
public interface AdRewardCompatIpc {
    /**
     * 加载广告
     * @param codeId
     * @param orientation
     * @param rewardVideoListenerIpc
     */
    void loadAd(String codeId, int orientation, RewardVideoListenerIpc rewardVideoListenerIpc);

    /**
     * 显示广告
     * @param activity
     */
    void showAd(Activity activity);

    /**
     * 销毁广告
     */
     void destroy();
}