package com.tv.doubuy.ui.video;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseExtendFragment;
import com.tv.doubuy.ui.notice.NoticeFragment;

import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/16.
 */

public class VideoFragment extends BaseExtendFragment {

    private static final String ARG_PARAM = "param";
    private String mParam;

    public static VideoFragment newInstance(String param) {
        VideoFragment fragment = new VideoFragment();
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

    }
}
