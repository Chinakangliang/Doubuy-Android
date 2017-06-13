package com.tv.doubuy.utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class PicassoHelper {
    private static PicassoHelper picassoHelper;

    public static PicassoHelper getInstance() {
        if (picassoHelper == null) {
            picassoHelper = new PicassoHelper();
        }
        return picassoHelper;
    }

    /**
     * 设置图片
     *
     * @param mContext 上下文
     * @param imgUrl   图片路径
     * @param ivIcon   图片控件
     */
    public void setImage(Context mContext, String imgUrl, ImageView ivIcon) {
        if (imgUrl != null && !"".equals(imgUrl)) {
            String newImgUrl = imgUrl.replace("https", "http");
            Picasso.with(mContext)
                    .load(newImgUrl)
//                    .placeholder(R.mipmap.icon_placeholder)
//                    .error(R.mipmap.icon_placeholder)
                    .config(Bitmap.Config.RGB_565)
                    .priority(Picasso.Priority.HIGH)
                    .fit()
                    .into(ivIcon);
        } else {
//            ivIcon.setImageResource(R.mipmap.icon_placeholder);
        }
    }

    /**
     * 设置加载大图片
     *
     * @param mContext
     * @param imgUrl
     * @param ivIcon
     */
    public void setMaxImage(Context mContext, String imgUrl, ImageView ivIcon) {
        if (imgUrl != null && !"".equals(imgUrl)) {
            String newImgUrl = imgUrl.replace("https", "http");
            Picasso.with(mContext)
                    .load(newImgUrl)
//                    .placeholder(R.mipmap.icon_placeholder2)
//                    .error(R.mipmap.bg_personal)
                    .config(Bitmap.Config.RGB_565)
                    .priority(Picasso.Priority.HIGH)
                    .fit()
                    .into(ivIcon);
        } else {
//            ivIcon.setImageResource(R.mipmap.icon_placeholder);
        }

    }

    /**
     * 设置头像
     *
     * @param mContext 上下文
     * @param imgUrl   图片路径
     * @param ivIcon   图片控件
     */
    public void setAvatar(Context mContext, String imgUrl, ImageView ivIcon) {
        if (imgUrl != null && !"".equals(imgUrl)) {
            String newImgUrl = imgUrl.replace("https", "http");
            Picasso.with(mContext)
                    .load(newImgUrl)
//                    .placeholder(R.mipmap.icon_avatar_default)
//                    .error(R.mipmap.icon_avatar_default)
                    .config(Bitmap.Config.RGB_565)
                    .priority(Picasso.Priority.HIGH)
                    .fit()
                    .into(ivIcon);
        } else {
//            ivIcon.setImageResource(R.mipmap.icon_avatar_default);
        }
    }


    public void setLocalImage(Context mContext, String path, ImageView ivIcon) {
        Picasso.with(mContext)
                .load("file://" + path)
//                    .placeholder(R.mipmap.icon_avatar_default)
//                    .error(R.mipmap.icon_avatar_default)
                .config(Bitmap.Config.RGB_565)
                .priority(Picasso.Priority.HIGH)
                .fit()
//                .transform(new CircleTransform())
                .into(ivIcon);

    }
}
