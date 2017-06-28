package com.tv.doubuy.dialog;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by apple on 2017/6/28.
 */

public class Progresloading {


    private ProgressDialog dialog;

    public Progresloading(Context context) {

        dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//设置进度条样式
        dialog.setMessage("请稍候...");
    }


    public void loadShow() {

        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }


    public void cleanload() {

        if (dialog != null && dialog.isShowing()) {

            dialog.dismiss();
        }
    }
}
