package com.group.ad;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ad.libary.compat.BannerAdCompat;
import com.ad.libary.compat.InteractionExpressAdCompat;
import com.ad.libary.compat.RewardVideoAdCompat;
import com.ad.libary.compat.SplashAdCompat;
import com.ad.libary.config.SDKAdBuild;
import com.ad.libary.simple_iml.BannerAdIpc;
import com.ad.libary.simple_iml.InteractionExpressAdIpc;
import com.ad.libary.simple_iml.RewardVideoListenerIpc;
import com.ad.libary.simple_iml.SdkSplashIpc;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    private FrameLayout adContainer;
    private FrameLayout mSplashContainer;
    private InteractionExpressAdCompat interactionExpressAdCompat;
    private RewardVideoAdCompat rewardVideoAdCompat;
    private BannerAdCompat bannerAdCompat;
    private SplashAdCompat splashAdCompat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        initView();
        checkPermissions();
    }

    /** 检查权限 */
    private void checkPermissions(){
        RxPermissions rxPermissions = new RxPermissions(this);
        Disposable disposable = rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean){
                            Toast.makeText(
                                    MainActivity.this,
                                    "权限确认", Toast.LENGTH_LONG).show();
                            setSplashAd();
                        }
                    }
                });
    }


    private void initView(){
        mSplashContainer = findViewById(R.id.splash_container);
        adContainer = findViewById(R.id.ad_container);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.ad_interaction:
                Toast.makeText(view.getContext(),"",Toast.LENGTH_SHORT).show();
                interactionExpressAd();
                break;
            case R.id.ad_reward:
                rewardVideoAd();
                break;
            case R.id.ad_banner:
                bannerAd();
                break;
        }
    }

    /**
     * 插屏广告
     */
    private void interactionExpressAd(){
        interactionExpressAdCompat = new InteractionExpressAdCompat(this);
        interactionExpressAdCompat.loadAd(SDKAdBuild.interactionExpressAdCode,new InteractionExpressAdIpc(this){
            @Override
            public void adOnError(int i, String s) {
                Log.e("YM","广点通插屏广告errorCode:"+i+"---------->message:"+s);
                adContainer.removeAllViews();
            }

            @Override
            public void loadComplete() {
                interactionExpressAdCompat.showAd();
            }

            @Override
            public void onClose() {

            }
        });
    }

    private void rewardVideoAd(){
        rewardVideoAdCompat = new RewardVideoAdCompat(this);
        rewardVideoAdCompat.loadAd(SDKAdBuild.rewardAdCode, RewardVideoAdCompat.VERTICAL,new RewardVideoListenerIpc(){
            @Override
            public void rewardVideoOnError(int i, String s) {
                Log.e("YM","加载失败:"+s);
            }

            @Override
            public void rewardVideoOnRewardVideoAdLoad() {
                rewardVideoAdCompat.showAd(MainActivity.this);
            }

            @Override
            public void rewardVideoOnRewardVideoCached() {

            }
        });
    }

    private void bannerAd(){
        bannerAdCompat = new BannerAdCompat(this);
        bannerAdCompat.loadAd(SDKAdBuild.bannerAdCode, new BannerAdIpc() {
            @Override
            public void adOnError(int i, String s) {
                Log.e("YM","Banner错误Code:"+i+"----->message:"+s);
            }

            @Override
            public void loadComplete() {
                Log.e("YM","加载完毕");
                adContainer.setVisibility(View.VISIBLE);
                bannerAdCompat.showBannerAd(adContainer);
            }

            @Override
            public void onClose() {

            }
        });
    }

    /**
     * 设置开屏广告
     * */

    private void setSplashAd(){
        splashAdCompat = new SplashAdCompat(this);
        splashAdCompat.loadSplash(SDKAdBuild.splashAdCode, 3000, new SdkSplashIpc() {
            //        splashAd.loadSplash("838455362", 3000, new SdkSplashInter() {

            @Override
            public void splashComplete() {
                mSplashContainer.removeAllViews();
                mSplashContainer.setVisibility(View.VISIBLE);
                splashAdCompat.showSplashAd(mSplashContainer);
            }

            @Override
            public void splashOnError(int i, String s) {
                Log.e("YM","出错");
            }

            @Override
            public void splashOnTimeout() {
                Log.e("YM","超时");
            }

            @Override
            public void OnAdSkip() {
                Log.e("YM","跳过");
//                goToMainActivity();
                mSplashContainer.removeAllViews();
                mSplashContainer.setVisibility(View.GONE);
            }

            @Override
            public void OnAdTimeOver() {
                Log.e("YM","倒计时结束");
                mSplashContainer.removeAllViews();
                mSplashContainer.setVisibility(View.GONE);
//                goToMainActivity();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != interactionExpressAdCompat){
            interactionExpressAdCompat.destroy();
        }
    }
}
