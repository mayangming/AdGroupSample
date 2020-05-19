package com.ad.libary.compat;

import android.view.ViewGroup;

import com.ad.libary.simple_iml.BannerAdIpc;


/**
 * Banner广告包装接口
 */
public interface AdBannerCompatIpc {
    /**
     * 加载广告
     * @param codeId 广告ID
     * @param bannerAdIpc 广告加载监听
     */
    void loadAd(String codeId, BannerAdIpc bannerAdIpc);

    /**
     * 显示广告
     * @param viewGroup
     */
    void showBannerAd(ViewGroup viewGroup);
}
