package com.lotte.mydemo2.model.api;


import com.beanu.arad.error.AradException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import rx.Observable;

/**
 * 工厂类
 * Created by Beanu on 15/12/29.
 */
public class APIFactory {

    private static ApiService apiServer;
    protected static final Object monitor = new Object();

    public static ApiService getApiInstance() {
        synchronized (monitor) {
            if (apiServer == null) {
                apiServer = APIRetrofit.getDefault();
            }
            return apiServer;
        }
    }

    private static class SingletonHolder {
        private static APIFactory instance = new APIFactory();
    }

    public static APIFactory getInstance() {
        return SingletonHolder.instance;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 统一的错误逻辑处理(只适用于不规范的接口)
    ///////////////////////////////////////////////////////////////////////////

    private Observable<JsonObject> errorHandle(JsonObject jsonObject) {
        JsonElement result = jsonObject.get("succeed");
        if (result != null && !result.getAsString().equals("000")) {
            return Observable.error(new AradException(jsonObject.get("sucInfo").getAsString()));
        }
        return Observable.just(jsonObject);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 接口实现  　//TODO 以后的接口 不需要在这里在写一边了
    ///////////////////////////////////////////////////////////////////////////
}