package com.tv.doubuy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by apple on 2017/6/29.
 */

public class TabItemAdapter extends FragmentPagerAdapter {

    private List<Fragment> views;
    private List<String> mTitleList;

    public TabItemAdapter(FragmentManager fm, List<Fragment> views, List<String> mTitleList) {
        super(fm);
        this.mTitleList = mTitleList;
        this.views = views;
    }

    @Override
    public Fragment getItem(int position) {

        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    //配置标题的方法
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }


}
