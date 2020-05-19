package com.ad.libary.simple_iml;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;

import java.util.List;

/**
 * 插屏广告加载监听
 */
public abstract class InteractionExpressAdIpc {
    private TTAdNative.NativeExpressAdListener nativeExpressAdListener;//穿山甲广告加载监听
    private UnifiedInterstitialADListener unifiedInterstitialADListener;//广点通广告加载监听
    private Activity activity;
    private TTNativeExpressAd ttNativeExpressAd;
    public abstract void adOnError(int i, String s);

    /**
     * 广告加载完毕
     */
    public abstract void loadComplete();

    /**
     * 广告加载完毕
     */
    public abstract void onClose();


    public InteractionExpressAdIpc(Activity activity) {
        this.activity = activity;
        nativeExpressAdListener = new TTAdNative.NativeExpressAdListener() {
            @Override
            public void onError(int code, String message) {
                Log.e("YM","加载错误,"+message);
                adOnError(code,message);
            }

            @Override
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> ads) {
//                startTime = System.currentTimeMillis();
//                mTTAd.render();
                if (ads == null || ads.size() == 0){
                    return;
                }
                ttNativeExpressAd = ads.get(0);
                bindAdListener(ttNativeExpressAd);
//                ttOnNativeExpressAdLoad(ads.get(0));
                ttNativeExpressAd.render();

            }
        };
        unifiedInterstitialADListener = new UnifiedInterstitialADListener() {
            @Override
            public void onADReceive() {
                loadComplete();
            }

            @Override
            public void onVideoCached() {

            }

            @Override
            public void onNoAD(AdError adError) {
                adOnError(adError.getErrorCode(),adError.getErrorMsg());
            }

            @Override
            public void onADOpened() {

            }

            @Override
            public void onADExposure() {

            }

            @Override
            public void onADClicked() {

            }

            @Override
            public void onADLeftApplication() {

            }

            @Override
            public void onADClosed() {
                onClose();
            }
        };
    }

    /**
     * 返回穿山甲插屏广告加载监听
     */
    public TTAdNative.NativeExpressAdListener getNativeExpressAdListener() {
        return nativeExpressAdListener;
    }
    /**
     * 返回广点通插屏广告加载监听
     */
    public UnifiedInterstitialADListener getUnifiedInterstitialADListener() {
        return unifiedInterstitialADListener;
    }

    public TTNativeExpressAd getTtNativeExpressAd() {
        return ttNativeExpressAd;
    }

    /**
     * 绑定广告行为
     * @param ad
     */
    private void bindAdListener(TTNativeExpressAd ad) {
        ad.setExpressInteractionListener(new TTNativeExpressAd.AdInteractionListener() {
            @Override
            public void onAdDismiss() {
//                TToast.show(getContext(), "广告关闭");
                Log.e("YM","广告关闭");
                onClose();
            }

            @Override
            public void onAdClicked(View view, int type) {
//                TToast.show(getContext(), "广告被点击");
                Log.e("YM","广告被点击");
            }

            @Override
            public void onAdShow(View view, int type) {
//                TToast.show(getContext(), "广告展示");
                Log.e("YM","广告展示");
            }

            @Override
            public void onRenderFail(View view, String msg, int code) {
//                TToast.show(getContext(), msg+" code:"+code);
                Log.e("YM","渲染失败"+msg+" code:"+code);
            }

            @Override
            public void onRenderSuccess(View view, float width, float height) {
                //返回view的宽高 单位 dp
                Log.e("YM","渲染成功");
                loadComplete();
            }
        });

        if (ad.getInteractionType() != TTAdConstant.INTERACTION_TYPE_DOWNLOAD){
            return;
        }
        ad.setDownloadListener(new TTAppDownloadListener() {
            @Override
            public void onIdle() {
//                TToast.show(getContext(), "点击开始下载", Toast.LENGTH_LONG);
            }

            @Override
            public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
//                    TToast.show(getContext(), "下载中，点击暂停", Toast.LENGTH_LONG);
            }

            @Override
            public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
//                TToast.show(getContext(), "下载暂停，点击继续", Toast.LENGTH_LONG);
            }

            @Override
            public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
//                TToast.show(getContext(), "下载失败，点击重新下载", Toast.LENGTH_LONG);
            }

            @Override
            public void onInstalled(String fileName, String appName) {
//                TToast.show(getContext(), "安装完成，点击图片打开", Toast.LENGTH_LONG);
            }

            @Override
            public void onDownloadFinished(long totalBytes, String fileName, String appName) {
//                TToast.show(getContext(), "点击安装", Toast.LENGTH_LONG);
            }
        });
    }

    public void destroy(){
        if (null != ttNativeExpressAd){
            ttNativeExpressAd.destroy();
        }
    }

}