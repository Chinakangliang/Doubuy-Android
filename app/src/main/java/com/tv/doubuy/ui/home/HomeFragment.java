package com.tv.doubuy.ui.home;

import android.os.Bundle;
import android.view.View;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseExtendFragment;

/**
 * Created by apple on 2017/6/6.
 */
public class HomeFragment extends BaseExtendFragment {


    @Override
    public void onCreateViewExtend(Bundle savedInstanceState) {
        super.onCreateViewExtend(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_mine, null);

    }
}
