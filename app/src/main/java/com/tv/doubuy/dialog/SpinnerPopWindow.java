package com.tv.doubuy.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.SpinnerAdapter;
import com.tv.doubuy.utils.PopupWindowUtil;
import com.tv.doubuy.utils.VerificationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/6/19.
 */

public class SpinnerPopWindow extends PopupWindow {


    private Context mcontext;

    private SpinnerAdapter spinnerAdapter;

    private RecyclerView recyler_popwindow;
    private List<String> mlist;

    private OnItemClickListener itemClickListener;

    private PopupWindow popupWindow;

    private ImageView amgeview;

    public SpinnerPopWindow(Context context, ImageView view) {

        this.mcontext = context;
        this.amgeview = view;
    }

    public SpinnerPopWindow builder() {
        final View contentView = LayoutInflater.from(mcontext).inflate(
                R.layout.layout_spinner_window, null);

        recyler_popwindow = (RecyclerView) contentView.findViewById(R.id.recyler_popwindow);

        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, false);

        contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                autoAdjustArrowPos(popupWindow, contentView, amgeview);
                contentView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });

        ;
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        VerificationUtils.backgroundAlpha(0.4f, (Activity) mcontext);

        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);

        popupWindow.setFocusable(false);


        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;   // 这里面拦截不到返回键
            }
        });
        // 如果希望showAsDropDown方法能够在下面空间不足时自动在anchorView的上面弹出
        // 必须在创建PopupWindow的时候指定高度，不能用wrap_content
        popupWindow.showAsDropDown(amgeview);


        popupWindow.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                VerificationUtils.backgroundAlpha(1f, (Activity) mcontext);
                popupWindow.dismiss();
            }
        });


        initviews();

        return this;
    }

    // TODO: 2017/6/20   这里需要重新设置显示的位置 ，未处理
    private void autoAdjustArrowPos(PopupWindow popupWindow, View contentView, View amgeview) {

        popupWindow.setBackgroundDrawable(new ColorDrawable());
        int windowPos[] = PopupWindowUtil.leftUnderther(amgeview, contentView);
        popupWindow.showAtLocation(amgeview, Gravity.NO_GRAVITY, windowPos[0], windowPos[1]);
    }


    public void initviews() {

        mlist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            mlist.add("item" + i);
        }
        recyler_popwindow.setLayoutManager(new LinearLayoutManager(mcontext));
        spinnerAdapter = new SpinnerAdapter(mcontext, mlist);
        recyler_popwindow.setAdapter(spinnerAdapter);
        setListener();
    }


    private void setListener() {
        spinnerAdapter.SpinnerAdapterItemCallBack(new SpinnerAdapter.SpinnerAdapterCallBack() {
            @Override
            public void setItemClik(int position) {

                if (itemClickListener != null) {
                    itemClickListener.onItemClick(position);
                }
            }
        });
    }


    public interface OnItemClickListener {
        void onItemClick(int position);

    }

    public SpinnerPopWindow onClickSheetItem(SpinnerPopWindow.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;

        return this;

    }


}
