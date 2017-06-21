package com.tv.doubuy.view.refresh;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;

import java.util.List;

/**
 * Created by apple on 2017/6/20.
 */

public class RefresHelper<T> {


    private static RefresHelper refresHelper;
    private static Handler handler;

    public static RefresHelper getInstance() {

        if (refresHelper == null) {
            refresHelper = new RefresHelper();
            handler = new Handler();
        }
        return refresHelper;
    }

    public List<T> OnLoadMoreListener(final RefreshRecyclerView recyclerView, final SwipeRefreshLayout swipeRefreshLayout, final List<T> mlist) {


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    mlist.add((T) ("更多数据" + i));
                }
                recyclerView.notifyData();//刷新数据
            }
        }, 2000);
        return mlist;

    }


    public List<T> OnRefreshListener(final RefreshRecyclerView recyclerView, final SwipeRefreshLayout swipeRefreshLayout, final List<T> mlist) {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                mlist.clear();
                mlist.add((T) "最新数据");
                mlist.add((T) "最新数据");
                mlist.add((T) "最新数据");

                //// TODO: 2017/6/20    这里请求接口  添加数据
                recyclerView.notifyData();
            }
        }, 1000);


        return mlist;
    }


}
