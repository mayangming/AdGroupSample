package com.ad.libary;

import android.content.Context;

import com.qq.e.comm.managers.GDTADManager;

/**
 * 腾讯广点通广告管理器
 */
public class GDTADManagerHolder {
    /**
     * @param application
     * @param appId 您在腾讯联盟开发者平台的APPID
     */
    public static void get(Context context, String appId){
        GDTADManager.getInstance().initWith(context, appId);
    }
}
