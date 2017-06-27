package com.tv.doubuy.ui.store.shop.adds;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.tv.doubuy.network.APIService;
import com.tv.doubuy.utils.AliyunUtils;
import com.tv.doubuy.utils.DouBuyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/6/26.
 */

public class ServerUpFile extends Service {

    private List<String> imgUrls;

    private List<String> imgpath = new ArrayList<>();

    private UpFileView upfileview;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        imgUrls = intent.getStringArrayListExtra("imgUrls");
        onUpdata(imgUrls);
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }


    //TODO 这里应该选择阿里多文件上传
    public void onUpdata(List<String> imgUrl) {

        AliyunUtils aliyunUtils = new AliyunUtils();
        for (int i = 0; i < imgUrl.size(); i++) {

            if (imgUrl.get(i).equals("选择")) {
                imgUrls.remove(i);
            } else {
                aliyunUtils.upFile(imgUrls.get(i), this);
                final int finalI = i;
                aliyunUtils.AliyunUploadCal(new AliyunUtils.AliyunUploadCallback() {
                    @Override
                    public void onSuccess(String fileUrl) {
                        imgpath.add(APIService.ALIYUN_OSS_IMAGE_PATH + fileUrl);
                        if (finalI == imgpath.size() - 1) {
//                            upfileview.imagesList(imgpath);
                            DouBuyApplication.getInstance().imagelist(imgpath);
                        }

                    }

                    @Override
                    public void onFailure(Exception e) {
                    }
                });
            }

        }

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        onDestroy();
    }


}
