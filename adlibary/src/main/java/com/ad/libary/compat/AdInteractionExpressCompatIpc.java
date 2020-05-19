package com.ad.libary.compat;

import com.ad.libary.simple_iml.InteractionExpressAdIpc;

/**
 * 插屏广告包装类接口
 */
public interface AdInteractionExpressCompatIpc {

    /**
     * 加载广告
     * @param codeId 广告Id
     * @param interactionExpressAdIpc 广告加载监听
     */
    void loadAd(String codeId, InteractionExpressAdIpc interactionExpressAdIpc);

    void showAd();

    /**
     * 销毁
     */
    void destroy();



}