package com.tv.doubuy.base;

/**
 * Created by apple on 2017/6/2.
 */
public class BaseResponse<T>{

    private  String token;
    private T data;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    @Override
    public String toString() {


        return "BaseResponse{" +
                "token='" + token + '\'' +
                ", data=" + data +
                '}';
    }



}


