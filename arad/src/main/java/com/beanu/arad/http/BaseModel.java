package com.beanu.arad.http;

import java.io.Serializable;

/**
 * Created by Jam on 16-8-12
 * Description:
 */
public class BaseModel<T> implements Serializable {
//    public String error;
//    public String msg;
//    public T dataInfo;
//
//
//    public boolean success(){
//        return error.equals("false");
//    }

    public String succeed;
    public String sucInfo;
    public String interface_name;
    public T dataInfo;

    public boolean success() {
        return succeed.equals("000");
    }
}
