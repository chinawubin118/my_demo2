package com.lotte.mydemo2.base;

import com.beanu.arad.AradApplication;
import com.beanu.arad.AradApplicationConfig;

/**
 * Created by Administrator on 2017/1/9.
 */

public class MyApplication extends AradApplication {
    @Override
    protected AradApplicationConfig appConfig() {
        return new AradApplicationConfig();
    }
}
