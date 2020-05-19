package com.ad.libary.simple_iml;

import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

/**
 * 穿山甲广告的默认下载实现
 * */
public class DefaultTTAppDownloadListener implements TTAppDownloadListener{
    @Override
    public void onIdle() {

    }

    @Override
    public void onDownloadActive(long l, long l1, String s, String s1) {
        //下载中
    }

    @Override
    public void onDownloadPaused(long l, long l1, String s, String s1) {
        //下载暂停
    }

    @Override
    public void onDownloadFailed(long l, long l1, String s, String s1) {
        //下载失败
    }

    @Override
    public void onDownloadFinished(long l, String s, String s1) {

    }

    @Override
    public void onInstalled(String s, String s1) {

    }
}