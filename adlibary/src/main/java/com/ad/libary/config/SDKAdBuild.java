package com.ad.libary.config;


import com.ad.libary.type.AdType;

/**
 * 广告配置类
 * */
public class SDKAdBuild{
    //    public String mGDTAppId = "1110071026";// 必选参数，设置应用的AppId
//    public String mAppId = "1110071026";//广点通的APPID， 必选参数，设置应用的AppId
        public String mAppId = "5001121";//穿山甲的appId， 必选参数，设置应用的AppId
    public String mAppName = "APP测试媒体";// 必选参数，设置应用名称

    public AdType type = AdType.AD_TT;//广告类型

    //插屏广告
//    public static final String rewardAdCode = "945087494";//线上环境
//    public static final String rewardAdCode = "901121593";//测试环境
//   穿山甲插屏广告
//    public static final String interactionExpressAdCode = "945179313";//测试环境
    public static final String interactionExpressAdCode = "901121133";//测试环境

    //    广点通插屏广告
//    public static final String interactionExpressAdCode = "7021811287184079";//测试环境

    //穿山甲激励视频
    public static final String rewardAdCode = "901121365";//测试环境

    //广点通激励视频
//    public static final String rewardAdCode = "3091616226721647";//测试环境

    //穿山甲开屏广告
    public static final String splashAdCode = "801121648";//测试环境
    //广点通开屏广告
//    public static final String splashAdCode = "5081012267319394";//测试环境

    //穿山甲Banner广告
    public static final String bannerAdCode = "901121895";//Banner广告Id,下载
//   广点通Banner广告
//    public static final String bannerAdCode = "4081919278805485";//Banner广告Id,下载

//        intent.putExtra("horizontal_rit","901121184");
//        intent.putExtra("vertical_rit","901121375");

//    //激励视频代码位id
//        intent.putExtra("horizontal_rit","901121430");
//        intent.putExtra("vertical_rit","901121365");
//    //全屏模板视频代码位id
//        intent.putExtra("horizontal_rit","901121516");
//        intent.putExtra("vertical_rit","901121073");
//    //激励模板视频代码位id
//        intent.putExtra("horizontal_rit","901121543");
//        intent.putExtra("vertical_rit","901121593");

}