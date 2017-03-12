package com.lotte.mydemo2.model.bean;

import java.io.Serializable;

/**
 * Created by wubin on 2016/1/13.
 */
public class SmsCode implements Serializable {
    private String randomCode;

    public String getRandomCode() {
        return randomCode;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }
}
