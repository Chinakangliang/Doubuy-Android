package com.tv.doubuy.utils;


import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.text.DecimalFormat;

/**
 * @Module : 工具类
 * @Comments : 字符串工具类
 * @Author : eric.chen
 * @CreateDate : 2016-3-25
 * @ModifiedBy : eric.chen
 * @ModifiedDate: 2016-3-25
 * @Modified :
 */
public class StringUtils {

    /**
     * 保留两位小数
     *
     * @param sum
     * @return
     */
    public static String retainTwo(double sum) {
        return new DecimalFormat("#0.00").format(sum);
    }

    public static boolean isNotEmpty(String str) {
        return str != null && false == str.equals("");
    }

    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    public static String buildTransaction(String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }

    /**
     * 去掉字符串中的数字
     *
     * @param str
     * @return
     */
    public static String removeNumber(String str) {
        return str.replaceAll("\\d+", "");
    }

    /**
     * 字符串部分变色
     */
    public static SpannableString setStrSyles(String str, int start, int end) {
        SpannableString ss = new SpannableString(str);
        ss.setSpan(new ForegroundColorSpan(Color.RED), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }

    /**
     * 复制
     */

    public static ClipboardManager StrCopy(Context context, String str) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(str.trim());

        return cm;
    }
}
