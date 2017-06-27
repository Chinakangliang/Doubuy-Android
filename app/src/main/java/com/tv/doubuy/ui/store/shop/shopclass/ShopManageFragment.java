package com.tv.doubuy.ui.store.shop.shopclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.ManageShopAdapter;
import com.tv.doubuy.base.BaseExtendFragment;
import com.tv.doubuy.dialog.PromptDialog;
import com.tv.doubuy.model.responseModel.ShopClassListModel;
import com.tv.doubuy.view.drawer.DrawerRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/19.
 */

public class ShopManageFragment extends BaseExtendFragment implements View.OnClickListener, ShopClassView {

    private static final String ARG_PARAM = "param";
    private String mParam;

    @BindView(R.id.recyler_manage)
    DrawerRecyclerView recyclerView;
    @BindView(R.id.tv_addclass)
    TextView tvAddClass;


    private ShopClassPresenter shopClassPresenter;

    private ManageShopAdapter manageShopAdapter;

    private ShopClassListModel classListModel;

    public static ShopManageFragment newInstance(String param) {
        ShopManageFragment fragment = new ShopManageFragment();
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

        View view = inflater.inflate(R.layout.fragment_shop_manage, null);
        ButterKnife.bind(this, view);
        setContentView(view);

    }

    @Override
    public void onResumeExtend() {
        super.onResumeExtend();
        initViews();
        setListener();
    }

    public void initViews() {
        shopClassPresenter = new ShopClassPresenter(getActivity(), this);
        shopClassPresenter.getCalssList();


        recyclerView.setOnItemClickListener(new DrawerRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {


            }

            @Override
            public void onDeleteClick(final int position) {

                final PromptDialog dialog = new PromptDialog(getActivity(), "确定删除该分类么？");
                dialog.setDiaLogClick(new PromptDialog.DialogCallBack() {
                    @Override
                    public void yesCallBack() {

                        if (classListModel != null) {
                            shopClassPresenter.detleClassProducts(classListModel.getResults().get(position).getId() + "");
                            manageShopAdapter.removeItem(position);
                            dialog.dismiss();


                        }

                    }

                    @Override
                    public void noCallBack() {

                        dialog.dismiss();
                    }
                });
                dialog.show();
            }

            @Override
            public void onModifyClick(int position) {
                if (classListModel != null) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), AddClassActivity.class);
                    intent.putExtra("title", "修改分类");
                    intent.putExtra("classid", classListModel.getResults().get(position).getId() + "");
                    intent.putExtra("name", classListModel.getResults().get(position).getName());
                    intent.putExtra("desc", classListModel.getResults().get(position).getDescription());
                    startActivity(intent);

                }

            }

        });


    }


    public void setListener() {

        tvAddClass.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.tv_addclass:
                intent.setClass(getActivity(), AddClassActivity.class);
                intent.putExtra("title", "添加分类");
                startActivity(intent);
                break;

        }

    }

    @Override
    public void getListClassData(ShopClassListModel shopClassListModel) {
        this.classListModel = shopClassListModel;
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        manageShopAdapter = new ManageShopAdapter(getActivity(), shopClassListModel.getResults());
        recyclerView.setAdapter(manageShopAdapter);

    }

    @Override
    public void deteleCategories(boolean ifsuccess) {

        manageShopAdapter.notifyDataSetChanged();
        Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
    }
}
