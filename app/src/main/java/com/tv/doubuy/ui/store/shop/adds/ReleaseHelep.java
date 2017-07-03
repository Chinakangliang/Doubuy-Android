package com.tv.doubuy.ui.store.shop.adds;

import android.text.TextUtils;

import com.tv.doubuy.model.requestModel.CreateProductModel;
import com.tv.doubuy.model.requestModel.GalleriesBean;
import com.tv.doubuy.model.requestModel.ProductSKUsBean;

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


    public CreateProductModel createRelease(List<ProductSKUsBean> listbean, String name, String description, List<String> paths) {
        CreateProductModel productModel = new CreateProductModel();
        List<CreateProductModel.GalleriesBean> galleriesBeenList = new ArrayList<>();
        CreateProductModel.GalleriesBean   galleriesBean = new CreateProductModel.GalleriesBean();
        List<CreateProductModel.ProductSKUsBean> productSKUsBeanList = new ArrayList<>();
        CreateProductModel.ProductSKUsBean productSKUsBean = new CreateProductModel.ProductSKUsBean();

        productModel.setName(name);
        productModel.setDescription(description);

        for (ProductSKUsBean skUsBean : listbean) {
            productSKUsBean.setSpec(skUsBean.getSpec());
            productSKUsBean.setCount(skUsBean.getCount() + "");
            productSKUsBean.setPrice(skUsBean.getPrice() + "");
            productSKUsBeanList.add(productSKUsBean);
        }
        productModel.setProductSKUs(productSKUsBeanList);
        if (paths != null && paths.size() > 0) {
            for (String path : paths) {
                galleriesBean.setImage(path);
                galleriesBeenList.add(galleriesBean);

            }
            productModel.setGalleries(galleriesBeenList);
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
        if (listbean != null) {
            for (ProductSKUsBean skUsBean : listbean) {

                productSKUsBean.setSpec(skUsBean.getSpec());
                productSKUsBean.setCount(skUsBean.getCount() + "");
                productSKUsBean.setPrice(skUsBean.getPrice() + "");
                productSKUsBeanList.add(productSKUsBean);
            }
        }
        productModel.setProductSKUs(productSKUsBeanList);

        if (pathlist.size() > 0) {
            for (String path : pathlist) {
                galleriesBean.setImage(path);
                galleriesBeenList.add(galleriesBean);
            }
        }
        return productModel;
    }
}
