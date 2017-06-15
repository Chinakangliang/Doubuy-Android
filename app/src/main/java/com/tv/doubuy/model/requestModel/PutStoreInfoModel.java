package com.tv.doubuy.model.requestModel;

/**
 * Created by apple on 2017/6/15.
 */

public class PutStoreInfoModel {

    private String name;
    private String description;
    private boolean servieAviable;
    private String cover;
    private String logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isServieAviable() {
        return servieAviable;
    }

    public void setServieAviable(boolean servieAviable) {
        this.servieAviable = servieAviable;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
