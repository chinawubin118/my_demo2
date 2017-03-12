package com.lotte.mydemo2.mvp.contract;

import com.beanu.arad.base.BaseModel;
import com.beanu.arad.base.BasePresenter;
import com.beanu.arad.base.BaseView;
import com.lotte.mydemo2.model.bean.School;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/1/9.
 */

public interface RecyclerViewContract {

    public interface View extends BaseView {

        void cancelRefresh();

        void notifyDataSetChanged();

        void notifyJinanList();
    }

    public abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void requestSchoolList(String provinceName, String schoolName);

        public abstract void requestJinanList(String provinceName, String schoolName);
    }

    public interface Model extends BaseModel {

        Observable<List<School>> requestSchoolList(String provinceName, String schoolName);

        Observable<List<School>> requestJinanList(String provinceName, String schoolName);
    }
}