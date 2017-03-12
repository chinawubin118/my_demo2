package com.lotte.mydemo2.mvp.contract;

import com.beanu.arad.base.BaseModel;
import com.beanu.arad.base.BasePresenter;
import com.beanu.arad.base.BaseView;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface MainPageContract {

    public interface View extends BaseView {
    }

    public abstract class Presenter extends BasePresenter<View, Model> {

    }

    public interface Model extends BaseModel {
    }
}