package com.tv.doubuy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by apple on 2017/6/8.
 */
public class TabLayoutPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    private List<String> stringList;

    public TabLayoutPagerAdapter(FragmentManager fm, List<Fragment> list, List<String> strTitle) {
        super(fm);
        this.list = list;
        this.stringList = strTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
