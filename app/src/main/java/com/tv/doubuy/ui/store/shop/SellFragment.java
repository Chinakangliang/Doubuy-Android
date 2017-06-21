package com.tv.doubuy.ui.store.shop;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.EmployAdapter;
import com.tv.doubuy.base.BaseExtendFragment;
import com.tv.doubuy.dialog.ModifyPopWindow;
import com.tv.doubuy.utils.ToastUtils;
import com.tv.doubuy.view.refresh.RefresHelper;
import com.tv.doubuy.view.refresh.RefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/19.
 */

public class SellFragment extends BaseExtendFragment implements EmployAdapter.EmployAdapteCallBack {

    private static final String ARG_PARAM = "param";
    private String mParam;
    List<String> str = new ArrayList<>();

    @BindView(R.id.recyler)
    RefreshRecyclerView recyler;
    @BindView(R.id.swipelauout)
    SwipeRefreshLayout swipelauout;

    private EmployAdapter employAdapter;
    private ModifyPopWindow window;

    private ShopItemDIalogPresenter presenter;

    public static SellFragment newInstance(String param) {
        SellFragment fragment = new SellFragment();
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

        View view = inflater.inflate(R.layout.fragment_sell, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        initviews();
        setListener();
    }

    private void initviews() {
        swipelauout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_green_light);
        recyler.setLoadMoreEnable(true);//允许加载更多
        recyler.setFooterResource(R.layout.item_footer);//设置脚布局

        for (int i = 0; i < 30; i++) {

            str.add(mParam + i);
        }
        recyler.setLayoutManager(new LinearLayoutManager(getActivity()));
        employAdapter = new EmployAdapter(getActivity());
        employAdapter.setData(str);
        recyler.setAdapter(employAdapter);

    }

    public void setListener() {

        employAdapter.setAdapterClick(this);


        recyler.setOnLoadMoreListener(new RefreshRecyclerView.OnLoadMoreListener() {
            @Override
            public void loadMoreListener() {
                RefresHelper.getInstance().OnLoadMoreListener(recyler, swipelauout, str);
            }
        });

        swipelauout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                str = RefresHelper.getInstance().OnRefreshListener(recyler, swipelauout, str);
            }
        });
    }


    @Override
    public void setItemClick(int position) {

    }

    @Override
    public void setItemShowPopWindowShow(final int position, final View view) {
        window = new ModifyPopWindow(getActivity(), view);
        presenter = new ShopItemDIalogPresenter(getActivity(), window, str);


        window.builder().setOnPopWindowClick(new ModifyPopWindow.onPopwindwCallback() {
            @Override
            public void onItemPopWinowShare() {
                ToastUtils.getInstance().showToast(getActivity(), "share");

            }

            @Override
            public void onItemPopWindowOutof() {
                presenter.shouDialog("确定上架该商品?", "outof");

            }

            @Override
            public void onItemPopWindowEdit() {
                ToastUtils.getInstance().showToast(getActivity(), "edit");

            }

            @Override
            public void onItemPopWinowDetele() {
                presenter.setNeedData(position, employAdapter, recyler);
                presenter.shouDialog("确定删除该商品?", "detele");
                recyler.notifyData();

            }
        });
    }

    @Override
    public void onDestroyViewExtend() {
        if (window != null) {
            window.dismiss();
            window = null;
        }

        super.onDestroyViewExtend();
    }


}
