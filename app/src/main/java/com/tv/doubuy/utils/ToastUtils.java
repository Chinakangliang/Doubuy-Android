package com.tv.doubuy.utils;

import android.content.Context;
import android.widget.Toast;


public class ToastUtils {

    private static ToastUtils toastUtlis;
    private Toast mToast;

    public static ToastUtils getInstance() {

        if (toastUtlis == null) {
            toastUtlis = new ToastUtils();
        }
        return toastUtlis;
    }

    public void showToast(Context context, String desc) {
        if (mToast == null) {
            mToast = Toast.makeText(context, desc, Toast.LENGTH_LONG);
        } else {
            mToast.setText(desc);
        }
        mToast.show();
    }
}
