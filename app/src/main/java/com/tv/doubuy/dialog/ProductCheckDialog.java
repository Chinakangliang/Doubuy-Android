package com.tv.doubuy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.view.wheel.OnWheelChangedListener;
import com.tv.doubuy.view.wheel.WheelView;
import com.tv.doubuy.view.wheel.adapters.ArrayWheelAdapter;

import java.util.List;

/**
 * Created by apple on 2017/6/23.
 */

public class ProductCheckDialog extends Dialog implements OnWheelChangedListener, View.OnClickListener {


    private Context mcontext;
    private WheelView wheelView;
    private TextView dialogCancel;
    private TextView dialogConfirm;
    private String[] stringList;
    private ProductChecCallback callBack;

    public ProductCheckDialog(@NonNull Context context) {
        super(context);

        this.mcontext = context;
        setContentView(R.layout.dialog_product_class);
        initViews();
    }

    private void initViews() {

        Window dialogWindow = getWindow();

        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.BOTTOM);
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialogWindow.setAttributes(lp);
        wheelView = (WheelView) findViewById(R.id.id__constenll);
        dialogCancel = (TextView) findViewById(R.id.dialog_cancel);
        dialogConfirm = (TextView) findViewById(R.id.dialog_confirm);
    }


    public void setListData(List<String> listData) {
        stringList = listData.toArray(new String[listData.size()]);
        setData(stringList);
    }


    private void setData(String[] stringList) {
        wheelView.setViewAdapter(new ArrayWheelAdapter<>(mcontext, stringList));
        wheelView.setVisibleItems(6);
        wheelView.addChangingListener(this);
        dialogCancel.setOnClickListener(this);
        dialogConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.dialog_cancel:
                dismiss();
                break;
            case R.id.dialog_confirm:
                String selectValue = stringList[wheelView.getCurrentItem()];
                if (callBack!=null){
                    callBack.ProductCheckCallBack(wheelView.getCurrentItem(), selectValue);
                }
                dismiss();
                break;


        }
    }


    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {

    }


    public void setSelectListener(ProductChecCallback callBack) {
        this.callBack = callBack;
    }

    public interface ProductChecCallback {
        void ProductCheckCallBack(int posotion, String newValue);
    }


}
