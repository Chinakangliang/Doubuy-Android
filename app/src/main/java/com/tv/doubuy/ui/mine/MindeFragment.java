package com.tv.doubuy.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseExtendFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/8.
 */
public class MindeFragment extends BaseExtendFragment {

    @Override
    public void onCreateViewExtend(Bundle savedInstanceState) {
        super.onCreateViewExtend(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        initViews();

    }

    public void initViews() {
        Intent intent = new Intent(getActivity(), SettingActivity.class);
        startActivity(intent);
    }

}
