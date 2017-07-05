package com.tv.doubuy.ui.store.shop.product;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.tv.doubuy.adapter.DownProductAdapter;
import com.tv.doubuy.adapter.ProductAdapter;
import com.tv.doubuy.dialog.ModifyPopWindow;
import com.tv.doubuy.dialog.PromptDialog;
import com.tv.doubuy.utils.VerificationUtils;

import java.util.List;

/**
 * Created by apple on 2017/6/21.
 */

public class DownPresenter {


    private Context mcontext;

    private PromptDialog promptDialog;

    private int position;
    private DownProductAdapter adapter;

    private RecyclerView recyler;
    private ModifyPopWindow window;
    private List<String> stringList;
    private ShopListView shopListView;
    private String productid;


    public DownPresenter(Context context, ModifyPopWindow window, List<String> stringList) {

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
                        itemNoSale();
                        break;
                    case "detele":
                        itemDetele();
                        break;
                    case "down":
                        itemOnSale();
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

    public void setNeedData(int position, DownProductAdapter adapter, RecyclerView recyler, ShopListView shopListView, String productid) {

        this.position = position;
        this.adapter = adapter;
        this.recyler = recyler;
        this.shopListView = shopListView;
        this.productid = productid;
    }


    /**
     * 分享
     */
    public void itemShare() {

    }

    public void itemOnSale() {
        adapter.removeItem(position);
        promptDialog.dismiss();
        window.popwindwDetele();
        VerificationUtils.backgroundAlpha(1f, (Activity) mcontext);
        if (!TextUtils.isEmpty(productid)) {
            shopListView.putNoSale(productid);
        }


    }

    public void itemNoSale() {
        adapter.removeItem(position);
        promptDialog.dismiss();
        window.popwindwDetele();
        VerificationUtils.backgroundAlpha(1f, (Activity) mcontext);
        if (!TextUtils.isEmpty(productid)) {
            shopListView.putOnSale(productid);
        }


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
        if (!TextUtils.isEmpty(productid)) {
            shopListView.deteleProduct(productid);
        }

    }

}
