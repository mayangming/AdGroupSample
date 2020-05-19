package com.ad.libary.simple_iml;

import android.util.Log;
import android.view.View;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.comm.util.AdError;

/**
 * Banner广告监听
 */
public abstract class BannerAdIpc {
    private TTAdNative.BannerAdListener bannerAdListener;//穿山甲Banner广告加载监听
    private UnifiedBannerADListener unifiedBannerADListener;//广点通Banner广告加载监听
    private View bannerView;
    public BannerAdIpc(){
        initTTListener();
        initGDTListener();
    }

    /**
     * 初始化穿山甲广告监听
     */
    private void initTTListener(){
        bannerAdListener = new TTAdNative.BannerAdListener(){
            @Override
            public void onError(int i, String s) {
                adOnError(i, s);
            }

            @Override
            public void onBannerAdLoad(TTBannerAd ttBannerAd) {
                bannerView = ttBannerAd.getBannerView();
                if (bannerView == null) {
                    adOnError(-1,"获取的View为null");
                    return;
                }
                //设置轮播的时间间隔  间隔在30s到120秒之间的值，不设置默认不轮播
                ttBannerAd.setSlideIntervalTime(30 * 1000);
                loadComplete();
            }
        };
    }

    private void initGDTListener(){
        unifiedBannerADListener = new UnifiedBannerADListener(){
            @Override
            public void onNoAD(AdError adError) {
                Log.e("YM","广告错误码:"+adError+"----->广告错误信息:"+adError.getErrorMsg());
                adOnError(adError.getErrorCode(),adError.getErrorMsg());
            }

            @Override
            public void onADReceive() {
                Log.e("YM","onADReceive");
                loadComplete();
            }

            @Override
            public void onADExposure() {
                Log.e("YM","onADExposure");
            }

            @Override
            public void onADClosed() {
                Log.e("YM","onADClosed");
                onClose();
            }

            @Override
            public void onADClicked() {
                Log.e("YM","onADClicked");
            }

            @Override
            public void onADLeftApplication() {
                Log.e("YM","onADLeftApplication");
            }

            @Override
            public void onADOpenOverlay() {
                Log.e("YM","onADOpenOverlay");
            }

            @Override
            public void onADCloseOverlay() {
                Log.e("YM","onADCloseOverlay");
            }
        };
    }

    public abstract void adOnError(int i, String s);

    /**
     * 广告加载完毕
     */
    public abstract void loadComplete();

    /**
     * 广告加载完毕
     */
    public abstract void onClose();

    public TTAdNative.BannerAdListener getBannerAdListener() {
        return bannerAdListener;
    }

    public UnifiedBannerADListener getUnifiedBannerADListener() {
        return unifiedBannerADListener;
    }

    public View getBannerView() {
        return bannerView;
    }
}