package com.tv.doubuy.ui.store.shop.adds;

import android.text.TextUtils;

import com.tv.doubuy.model.requestModel.CreateProductModel;
import com.tv.doubuy.model.requestModel.GalleriesBean;
import com.tv.doubuy.model.requestModel.ProductSKUsBean;
import com.tv.doubuy.utils.DouBuyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/6/26.
 */
public class ReleaseHelep {


    private static ReleaseHelep mInstance;

    private List<ProductSKUsBean> listbean;

    public static ReleaseHelep getInstance() {
        if (mInstance == null) {
            synchronized (ReleaseHelep.class) {
                mInstance = new ReleaseHelep();

            }
        }
        return mInstance;
    }


    public void setProductSKU(List<ProductSKUsBean> listbean) {

        this.listbean = listbean;

    }


    public boolean isContentNull(String count, String spec, String inven) {

        if (TextUtils.isEmpty(count) || TextUtils.isEmpty(spec) || TextUtils.isEmpty(inven)) {

            return false;
        }
        return true;
    }


    public CreateProductModel createRelease(List<ProductSKUsBean> listbean, String name, String description) {
        CreateProductModel productModel = new CreateProductModel();
        List<GalleriesBean> galleriesBeenList = new ArrayList<>();
        GalleriesBean galleriesBean = new GalleriesBean();
        List<CreateProductModel.ProductSKUsBean> productSKUsBeanList = new ArrayList<>();
        CreateProductModel.ProductSKUsBean productSKUsBean = new CreateProductModel.ProductSKUsBean();

        productModel.setName(name);
        productModel.setDescription(description);

        for (ProductSKUsBean skUsBean : listbean) {

            productSKUsBean.setSpec(skUsBean.getSpec());
            productSKUsBean.setCount(skUsBean.getCount());
            productSKUsBean.setPrice(skUsBean.getPrice());
            productSKUsBeanList.add(productSKUsBean);
        }

        productModel.setProductSKUs(productSKUsBeanList);

        if (DouBuyApplication.getInstance().getList().size() > 0) {
            for (String path : DouBuyApplication.getInstance().getList()) {
                galleriesBean.setImage(path);
                galleriesBeenList.add(galleriesBean);
            }
        } else {
            //// TODO: 2017/6/26  上传图片提示
        }

        return productModel;
    }

    public CreateProductModel createProduct(List<ProductSKUsBean> listbean, String name, String description, List<String> pathlist) {
        CreateProductModel productModel = new CreateProductModel();
        List<GalleriesBean> galleriesBeenList = new ArrayList<>();
        GalleriesBean galleriesBean = new GalleriesBean();
        List<CreateProductModel.ProductSKUsBean> productSKUsBeanList = new ArrayList<>();
        CreateProductModel.ProductSKUsBean productSKUsBean = new CreateProductModel.ProductSKUsBean();

        productModel.setName(name);
        productModel.setDescription(description);

        for (ProductSKUsBean skUsBean : listbean) {

            productSKUsBean.setSpec(skUsBean.getSpec());
            productSKUsBean.setCount(skUsBean.getCount());
            productSKUsBean.setPrice(skUsBean.getPrice());
            productSKUsBeanList.add(productSKUsBean);
        }

        productModel.setProductSKUs(productSKUsBeanList);

        if (pathlist.size() > 0) {
            for (String path : pathlist) {
                galleriesBean.setImage(path);
                galleriesBeenList.add(galleriesBean);
            }
        } else {
            //// TODO: 2017/6/26  上传图片提示
        }

        return productModel;
    }
}
