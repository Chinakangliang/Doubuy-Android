package com.tv.doubuy.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public abstract class BaseExtendFragment extends BaseFragment {
    //TODO ①原先的Fragment的回调方法名字后面要加个Extend，比如Fragment的onCreateView方法，就写成onCreateViewExtend
    //TODO ②使用该Fragment会导致多一层布局深度
    private boolean isInit = false;
    private Bundle savedInstanceState;
    public static final String INTENT_BOOLEAN_LAZYLOAD = "intent_boolean_lazyLoad";
    private boolean isLazyLoad = true;
    private FrameLayout layout;
    private int isVisibleToUserState = VISIBLE_STATE_NOTSET;
    //未设置值
    private static final int VISIBLE_STATE_NOTSET = -1;
    //可见
    private static final int VISIBLE_STATE_VISIABLE = 1;
    //不可见
    private static final int VISIBLE_STATE_GONE = 0;


    @Override
    public final void onCreateView(Bundle savedInstanceState, LayoutInflater inflater) {
        super.onCreateView(savedInstanceState, inflater);
        this.savedInstanceState = savedInstanceState;
        Bundle bundle = getArguments();
        if (bundle != null) {
            isLazyLoad = bundle.getBoolean(INTENT_BOOLEAN_LAZYLOAD, isLazyLoad);
        }
        //为什么不直接getUserVisibleHint();而是通过自己存isVisibleToUserState变量判断
        //因为v4的25的版本 已经调用 setUserVisibleHint(true)，结果到这里getUserVisibleHint是false
        // （ps:看了FragmentManager源码Fragment被重新创建有直接赋值isVisibleToUser不知道是不是那里和之前v4有改动的地方）
        //所以我默认VISIBLE_STATE_NOTSET，之前没有调用setUserVisibleHint方法，就用系统的getUserVisibleHint，否则就用setUserVisibleHint后保存的值
        //总之就是调用了setUserVisibleHint 就使用setUserVisibleHint的值
        boolean isVisibleToUser;
        if (isVisibleToUserState == VISIBLE_STATE_NOTSET) {
            isVisibleToUser = getUserVisibleHint();
        } else {
            isVisibleToUser = isVisibleToUserState == VISIBLE_STATE_VISIABLE;
        }
        if (isLazyLoad) {
            if (isVisibleToUser && !isInit) {
                isInit = true;
                onCreateViewExtend(savedInstanceState);
            } else {
                LayoutInflater layoutInflater = inflater;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from(getApplicationContext());
                }
                layout = new FrameLayout(layoutInflater.getContext());
                View view = getPreviewLayout(layoutInflater, layout);
                if (view != null) {
                    layout.addView(view);
                }
                layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                super.setContentView(layout);
            }
        } else {
            isInit = true;
            onCreateViewExtend(savedInstanceState);
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisibleToUserState = isVisibleToUser ? VISIBLE_STATE_VISIABLE : VISIBLE_STATE_GONE;
        if (isVisibleToUser && !isInit && getContentView() != null) {
            isInit = true;
            onCreateViewExtend(savedInstanceState);
            onResumeExtend();
        }
        if (isInit && getContentView() != null) {
            if (isVisibleToUser) {
                isStart = true;
                onFragmentStartExtend();
            } else {
                isStart = false;
                onFragmentStopExtend();
            }
        }
    }

    protected View getPreviewLayout(LayoutInflater inflater, ViewGroup container) {
        return null;
    }

    @Deprecated
    @Override
    public final void onStart() {
        super.onStart();
        if (isInit && !isStart && getUserVisibleHint()) {
            isStart = true;
            onFragmentStartExtend();
        }
    }

    @Deprecated
    @Override
    public final void onStop() {
        super.onStop();
        if (isInit && isStart && getUserVisibleHint()) {
            isStart = false;
            onFragmentStopExtend();
        }
    }


    private boolean isStart = false;

    public void onFragmentStartExtend() {

    }

    public void onFragmentStopExtend() {

    }

    public void onCreateViewExtend(Bundle savedInstanceState) {

    }

    public void onResumeExtend() {

    }

    public void onPauseExtend() {

    }

    public void onDestroyViewExtend() {

    }

    @Override
    public void setContentView(int layoutResID) {
        if (isLazyLoad && getContentView() != null && getContentView().getParent() != null) {
            layout.removeAllViews();
            View view = inflater.inflate(layoutResID, layout, false);
            layout.addView(view);
        } else {
            super.setContentView(layoutResID);
        }
    }

    @Override
    public void setContentView(View view) {
        if (isLazyLoad && getContentView() != null && getContentView().getParent() != null) {
            layout.removeAllViews();
            layout.addView(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override
    @Deprecated
    public final void onResume() {
        super.onResume();
        if (isInit) {
            onResumeExtend();
        }

    }

    @Override
    @Deprecated
    public final void onPause() {
        super.onPause();
        if (isInit) {
            onPauseExtend();
        }
    }

    @Override
    @Deprecated
    public final void onDestroyView() {
        super.onDestroyView();
        if (isInit) {
            onDestroyViewExtend();
        }
        isInit = false;
    }

}
