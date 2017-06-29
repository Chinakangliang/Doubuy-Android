package com.tv.doubuy.ui.store.shop.product.details;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.ProductsEvalAdapter;
import com.tv.doubuy.base.BaseExtendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductsMessageFragment extends BaseExtendFragment {
    private static final String ARG_PARAM = "param";
    @BindView(R.id.recyler_eval)
    RecyclerView recylerEval;
    private String mParam;

    private ProductsEvalAdapter evalAdapter;

    public static ProductsMessageFragment newInstance(String param1) {
        ProductsMessageFragment fragment = new ProductsMessageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param1);
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
        View view = inflater.inflate(R.layout.fragment_products_message, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        initviews();
        setListener();

    }

    private void initviews() {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            str.add("" + i);
        }

        recylerEval.setLayoutManager(new LinearLayoutManager(getActivity()));
        evalAdapter = new ProductsEvalAdapter(getActivity(),str);
        recylerEval.setAdapter(evalAdapter);

    }

    private void setListener() {
    }


}
