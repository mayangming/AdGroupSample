package com.ad.libary.type;

/**
 * 广告类型
 */
public enum AdType {
    AD_TT(1),//穿山甲
    AD_GDT(2)//广点通
    ;
    int type;

    AdType(int type) {
        this.type = type;
    }


    public static AdType getAdTypeForValue(int value){
        AdType adType = AD_TT;
        for (AdType type: values()) {
            if (value == type.type){
                adType = type;
            }
            break;
        }
        return adType;
    }

}