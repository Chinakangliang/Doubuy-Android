package com.tv.doubuy.utils;

import android.net.Uri;
import android.os.Environment;
import android.widget.LinearLayout;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;

import java.io.File;

/**
 * Created by apple on 2017/6/9.
 */

public class CustomHelper {
    //是否支持裁剪
    private boolean isCrop = true;
    //
    private boolean isCropTool = true;
    //尺寸比例选取类型   0 宽x高; 1宽/高
    private int sizeType = 0;
    //是否压缩
    private boolean isCompress = true;
    //是否显示压缩进度条
    private boolean isShowProgress = true;
    //最大选取数量
    private int maxSelectCount = 1;
    //是否从相册选取  (相册、文件)
    private boolean isAlbum = true;
    private static CustomHelper customHelper;

    public static CustomHelper getInstace() {
        if (customHelper == null) {
            customHelper = new CustomHelper();
        }
        return customHelper;
    }

    //拍照
    public void onPhotoGraph(TakePhoto takePhoto) {
        File file = new File(Environment.getExternalStorageDirectory(),
                "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        //是否裁剪
        if (isCrop) {
            takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions());
        } else {
            takePhoto.onPickFromCapture(imageUri);
        }
    }

    public void onPhotoGraph(TakePhoto takePhoto, boolean isCrop) {
        File file = new File(Environment.getExternalStorageDirectory(),
                "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        //是否裁剪
        if (isCrop) {
            takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions());
        } else {
            takePhoto.onPickFromCapture(imageUri);
        }
    }

    public void onAlbumChoice(TakePhoto takePhoto) {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        if (maxSelectCount > 1) {
            if (isCrop) {
                takePhoto.onPickMultipleWithCrop(maxSelectCount, getCropOptions());
            } else {
                takePhoto.onPickMultiple(maxSelectCount);
            }
            return;
        }
        if (isAlbum) {
            if (isCompress) {
                takePhoto.onPickFromGalleryWithCrop(imageUri, getCropOptions());
            } else {
                takePhoto.onPickFromGallery();
            }
            return;
        } else {
            if (isCompress) {
                takePhoto.onPickFromDocumentsWithCrop(imageUri, getCropOptions());
            } else {
                takePhoto.onPickFromDocuments();
            }
        }
    }


    public void onAlbumChoice(TakePhoto takePhoto, boolean isCrop) {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        if (isCrop) {
            takePhoto.onPickMultipleWithCrop(maxSelectCount, getCropOptions());
        } else {
            takePhoto.onPickMultiple(maxSelectCount);
            return;
        }
    }

    private void configCompress(TakePhoto takePhoto) {
        if (isCompress) {
            takePhoto.onEnableCompress(null, false);
            return;
        }
        int maxSize = 102400;
        int maxPixel = 800;
        CompressConfig config = new CompressConfig.Builder().setMaxSize(maxSize)
                .setMaxPixel(maxPixel).create();
        takePhoto.onEnableCompress(config, isShowProgress);
    }


    private CropOptions getCropOptions() {
//        //if (isCrop) return null;
//        int height = 800;
//        int width = 800;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean withWonCrop = sizeType == 0 ? true : false;
        CropOptions.Builder builder = new CropOptions.Builder();
        if (sizeType == 1) {
            builder.setAspectX(width).setAspectY(height);
        } else {
            builder.setOutputX(width).setOutputY(height);
        }
        builder.setWithOwnCrop(withWonCrop);
        return builder.create();
    }

    public void setMaxSelectCount(int maxSelectCount) {
        this.maxSelectCount = maxSelectCount;
    }
}

