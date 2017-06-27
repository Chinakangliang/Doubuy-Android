package com.tv.doubuy.ui.store.shop;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.tv.doubuy.adapter.ProductAdapter;
import com.tv.doubuy.dialog.ModifyPopWindow;
import com.tv.doubuy.dialog.PromptDialog;
import com.tv.doubuy.utils.VerificationUtils;

import java.util.List;

/**
 * Created by apple on 2017/6/21.
 */

public class ShopItemDIalogPresenter {


    private Context mcontext;

    private PromptDialog promptDialog;

    private int position;
    private ProductAdapter adapter;

    private RecyclerView recyler;
    private ModifyPopWindow window;
    private List<String> stringList;

    public ShopItemDIalogPresenter(Context context, ModifyPopWindow window, List<String> stringList) {

        this.mcontext = context;
        this.window = window;
        this.stringList = stringList;
    }


    public void shouDialog(String str, final String type) {

        promptDialog = new PromptDialog(mcontext, str);
        promptDialog.setDiaLogClick(new PromptDialog.DialogCallBack() {
            @Override
            public void yesCallBack() {

                switch (type) {

                    case "outof":
                        break;
                    case "detele":
                        itemDetele();
                        break;
                }

            }

            @Override
            public void noCallBack() {
                promptDialog.dismiss();

            }
        });
        promptDialog.show();
    }

    /**
     * 设置需要的数据
     */

    public void setNeedData(int position, ProductAdapter adapter, RecyclerView recyler) {

        this.position = position;
        this.adapter = adapter;
        this.recyler = recyler;

    }


    /**
     * 分享
     */
    public void itemShare() {

    }

    /**
     * 上架
     */
    public void itemOutOf() {

    }

    /**
     * 编辑
     */
    public void itemEdit(int position) {

    }


    /**
     * 删除
     */
    public void itemDetele() {
        adapter.removeItem(position);
        promptDialog.dismiss();
        window.popwindwDetele();
        VerificationUtils.backgroundAlpha(1f, (Activity) mcontext);

    }

}
