package com.tv.doubuy.model.requestModel;

import java.io.Serializable;

/**
 * Created by apple on 2017/6/12.
 */

public class CreateShposModel implements Serializable {

    private String name;
    private String logo;
    private String realName;
    private String personNO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPersonNO() {
        return personNO;
    }

    public void setPersonNO(String personNO) {
        this.personNO = personNO;
    }
}
