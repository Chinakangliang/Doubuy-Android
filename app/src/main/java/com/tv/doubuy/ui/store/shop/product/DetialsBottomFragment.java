package com.tv.doubuy.ui.store.shop.product;

import android.os.Bundle;
import android.view.View;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseExtendFragment;

import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/28.
 */

public class DetialsBottomFragment extends BaseExtendFragment {

    @Override
    public void onCreateViewExtend(Bundle savedInstanceState) {
        super.onCreateViewExtend(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_bottom_product_detials, null);
        ButterKnife.bind(this, view);
        setContentView(view);
    }
}
