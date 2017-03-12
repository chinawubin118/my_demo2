package com.lotte.mydemo2.mvp.presenter;

import com.lotte.mydemo2.model.bean.School;
import com.lotte.mydemo2.mvp.contract.RecyclerViewContract;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/01/09
 */

public class RecyclerViewPresenterImpl extends RecyclerViewContract.Presenter {

    private ArrayList<School> schoolList = new ArrayList<>();

    public ArrayList<School> getSchoolList() {
        return schoolList;
    }

    @Override
    public void requestSchoolList(String provinceName, String schoolName) {
        mRxManage.add(mModel.requestSchoolList(provinceName, schoolName).subscribe(new Subscriber<List<School>>() {
            @Override
            public void onCompleted() {
                mView.cancelRefresh();
                mView.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<School> listBaseModel) {
                schoolList.addAll(listBaseModel);
            }
        }));
    }

    @Override
    public void requestJinanList(String provinceName, String schoolName) {
        mRxManage.add(mModel.requestJinanList(provinceName, schoolName).subscribe(new Subscriber<List<School>>() {
            @Override
            public void onCompleted() {
                mView.cancelRefresh();
                mView.notifyJinanList();
            }

            @Override
            public void onError(Throwable e) {
                mView.cancelRefresh();
            }

            @Override
            public void onNext(List<School> listBaseModel) {
                schoolList.clear();
                schoolList.addAll(listBaseModel);
            }
        }));
    }
}