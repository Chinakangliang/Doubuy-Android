package com.tv.doubuy.network;

/**
 * Created by apple on 2017/6/16.
 */

public class ApiException extends Exception {
    public int code;
    public String message;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;



    }

}
