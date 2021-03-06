package com.tv.doubuy.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseExtendFragment;

import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/8.
 */
public class MindeFragment extends BaseExtendFragment {


    private static final String ARG_PARAM = "param";
    private String mParam;

    public static MindeFragment newInstance(String param) {
        MindeFragment fragment = new MindeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }


    @Override
    public void onCreateViewExtend(Bundle savedInstanceState) {
        super.onCreateViewExtend(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_blank, null);
        TextView textView = (TextView) view.findViewById(R.id.tvTest);
        ButterKnife.bind(this, view);
        setContentView(view);
        textView.setText("" + mParam);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initViews();
            }
        });

    }

    public void initViews() {
        Intent intent = new Intent(getActivity(), SettingActivity.class);
        startActivity(intent);
    }

}
