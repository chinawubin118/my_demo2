package com.lotte.mydemo2.mvp.model;

import com.beanu.arad.http.RxHelper;
import com.lotte.mydemo2.model.api.APIFactory;
import com.lotte.mydemo2.model.bean.School;
import com.lotte.mydemo2.mvp.contract.RecyclerViewContract;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/01/09
 */

public class RecyclerViewModelImpl implements RecyclerViewContract.Model {

    @Override
    public Observable<List<School>> requestSchoolList(String provinceName, String schoolName) {
        return APIFactory.getApiInstance()
                .getSchoolList(provinceName, schoolName)
                .compose(RxHelper.<List<School>>handleResult());
    }

    @Override
    public Observable<List<School>> requestJinanList(String provinceName, String schoolName) {
        return requestSchoolList(provinceName, schoolName);
    }
}