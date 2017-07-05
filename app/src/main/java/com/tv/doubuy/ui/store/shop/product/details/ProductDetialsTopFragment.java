package com.tv.doubuy.ui.store.shop.product.details;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.ProductTagAdapter;
import com.tv.doubuy.base.BaseExtendFragment;
import com.tv.doubuy.model.responseModel.CreateProductSKUs;
import com.tv.doubuy.model.responseModel.DetialsProductModel;
import com.tv.doubuy.model.responseModel.ProductGalleriesBean;
import com.tv.doubuy.network.APIService;
import com.tv.doubuy.utils.PicassoHelper;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/28.
 */

public class ProductDetialsTopFragment extends BaseExtendFragment implements ProductTagAdapter.Itemcallback {


    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.tv_productname)
    TextView tvProductname;
    @BindView(R.id.tv_productprcie)
    TextView tvProductprcie;
    @BindView(R.id.tv_productShare)
    ImageView tvProductShare;
    @BindView(R.id.recyler)
    RecyclerView recyler;
    @BindView(R.id.tv_viewCount)
    TextView tvViewCount;
    @BindView(R.id.tv_count)
    TextView tvCount;

    @BindView(R.id.tv_TagCount)
    TextView tvTagCount;
    @BindView(R.id.tv_TagPrice)
    TextView tvTagPrice;


    private ProductTagAdapter productTagAdapter;

    private HashMap<Integer, Boolean> mapstate = new HashMap<>();

    @Override
    public void onCreateViewExtend(Bundle savedInstanceState) {
        super.onCreateViewExtend(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_top_product_detials, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        initviews();
    }

    public void initviews() {
        Bundle bundle = getArguments();

        DetialsProductModel productModel = (DetialsProductModel) bundle.getSerializable("productModel");

        if (productModel != null) {

            List<String> list = new ArrayList<>();
            if (productModel.getGalleries().size() > 0) {

                for (ProductGalleriesBean galleriesBean : productModel.getGalleries()) {

                    list.add(galleriesBean.getImage());
                }

            } else {
                list.add("http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14865431644689.jpg");
            }

            banner.setImages(list).setImageLoader(new GlideImageLoader()).start();

            tvProductname.setText(productModel.getName());
            tvProductprcie.setText(APIService.FUHAO + productModel.getPrice());
            tvViewCount.setText(productModel.getViewCount() + "");
            tvCount.setText(productModel.getAmount() + "");


            recyler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
            productTagAdapter = new ProductTagAdapter(getActivity());
            productTagAdapter.setData(productModel.getProductSKUs());
            mapstate.put(0, true);
            for (int i = 1; i < productModel.getProductSKUs().size(); i++) {
                tvTagPrice.setText(productModel.getProductSKUs().get(0).getPrice() + "");
                tvTagCount.setText(productModel.getProductSKUs().get(0).getCount()+"");

                mapstate.put(i, false);
            }


            productTagAdapter.setHasMap(mapstate);
            recyler.setAdapter(productTagAdapter);
            productTagAdapter.ItemTagListClick(this);
        }


    }

    @Override
    public void isCheckTag(int position, List<CreateProductSKUs> mlist) {

        tvTagPrice.setText(APIService.FUHAO + mlist.get(position).getPrice());
        tvTagCount.setText(mlist.get(position).getCount() + "");

        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < mlist.size(); i++) {

            if (i == position) {
                hashMap.put(i, true);
            } else {
                hashMap.put(i, false);
            }
        }
        productTagAdapter.setHasMap(hashMap);
        recyler.setAdapter(productTagAdapter);

    }


    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            PicassoHelper.getInstance().setMaxImage(getActivity(), (String) path, imageView);

        }
    }
}
