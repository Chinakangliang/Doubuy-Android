package com.tv.doubuy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.tv.doubuy.R;

/**
 * Created by apple on 2017/6/9.
 */

public class ActionSheetDialog {

    private Context context;
    private Dialog dialog;
    private Display display;

    private RelativeLayout rela_pictures;
    private RelativeLayout rela_album;
    private RelativeLayout rela_clean;

    private OnSheetItemClickListener itemClickListener;

    public ActionSheetDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public ActionSheetDialog builder() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(
                R.layout.dialog_actionsheet, null);

        // 设置Dialog最小宽度为屏幕宽度
        view.setMinimumWidth(display.getWidth());

        // 获取自定义Dialog布局中的控件

        rela_pictures = (RelativeLayout) view.findViewById(R.id.rela_pictures);
        rela_album = (RelativeLayout) view.findViewById(R.id.rela_album);
        rela_clean = (RelativeLayout) view.findViewById(R.id.rela_clean);

        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        dialog.setContentView(view);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = 0;
        lp.y = 0;
        dialogWindow.setAttributes(lp);


        setListener();

        return this;
    }

    public void dialogshow() {

        dialog.show();
    }

    public void setListener() {


        rela_pictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (itemClickListener != null) {
                    itemClickListener.onPicturesClick();
                }
            }
        });

        rela_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (itemClickListener != null) {
                    itemClickListener.onAlbumClick();
                }
            }
        });

        rela_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }


    public interface OnSheetItemClickListener {
        void onPicturesClick();

        void onAlbumClick();
    }

    public ActionSheetDialog onClickSheetItem(OnSheetItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;

        return this;

    }

}
