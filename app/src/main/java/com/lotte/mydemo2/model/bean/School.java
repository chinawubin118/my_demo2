package com.lotte.mydemo2.model.bean;

import java.io.Serializable;

/**
 * Created by wubin on 2016/1/13.
 */
public class School implements Serializable{
    private String coid;
    private String name;
    private String provinceid;

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }
}
