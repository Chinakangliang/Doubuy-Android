package com.tv.doubuy.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.tv.doubuy.R;
import com.tv.doubuy.utils.PopupWindowUtil;

/**
 * Created by apple on 2017/6/19.
 */

public class ModifyPopWindow extends PopupWindow implements View.OnClickListener {


    private Context mcontext;

    private PopupWindow popupWindow;

    private View mviews;


    private LinearLayout liner_share;
    private LinearLayout liner_outof;
    private LinearLayout liner_edit;
    private LinearLayout liner_detele;

    private onPopwindwCallback callback;

    public ModifyPopWindow(Context context, View view) {

        this.mcontext = context;
        this.mviews = view;
    }

    public ModifyPopWindow builder() {
        final View contentView = LayoutInflater.from(mcontext).inflate(
                R.layout.layout_modify_window, null);

        liner_share = (LinearLayout) contentView.findViewById(R.id.liner_share);
        liner_outof = (LinearLayout) contentView.findViewById(R.id.liner_outof);
        liner_edit = (LinearLayout) contentView.findViewById(R.id.liner_edit);
        liner_detele = (LinearLayout) contentView.findViewById(R.id.liner_detele);

        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);
        showPopupWindow(contentView);
        onListener();

        return this;
    }


    public void onListener() {
        liner_share.setOnClickListener(this);
        liner_outof.setOnClickListener(this);
        liner_edit.setOnClickListener(this);
        liner_detele.setOnClickListener(this);

    }


    private void showPopupWindow(View contentView) {
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        int windowPos[] = PopupWindowUtil.itemCenter(mviews, contentView);
        popupWindow.showAtLocation(mviews, Gravity.LEFT | Gravity.TOP, windowPos[0], windowPos[1]);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.liner_share:
                if (callback != null) {

                    callback.onItemPopWinowShare();
                }
                break;
            case R.id.liner_outof:
                if (callback != null) {

                    callback.onItemPopWindowOutof();
                }
                break;
            case R.id.liner_edit:
                if (callback != null) {

                    callback.onItemPopWindowEdit();
                }
                break;
            case R.id.liner_detele:
                if (callback != null) {
                    callback.onItemPopWinowDetele();
                }
                break;
        }

    }

    public ModifyPopWindow setOnPopWindowClick(ModifyPopWindow.onPopwindwCallback callback) {

        this.callback = callback;

        return this;
    }

    public interface onPopwindwCallback {

        void onItemPopWinowShare();

        void onItemPopWindowOutof();

        void onItemPopWindowEdit();

        void onItemPopWinowDetele();


    }

    public void popwindwDetele() {
        if (popupWindow != null && popupWindow.isShowing()) {

            popupWindow.dismiss();
            popupWindow = null;
        }
    }
}
