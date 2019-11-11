package com.baway.baiweitong.day1111.presenter;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:Presenter
 * */
import com.baway.baiweitong.day1111.base.BasePresenter;
import com.baway.baiweitong.day1111.contart.Contart;
import com.baway.baiweitong.day1111.model.ModelImp;

import java.lang.ref.WeakReference;

public class PresenterImp extends BasePresenter {

    private ModelImp modelImp;

    public PresenterImp(WeakReference weakReference) {
        super(weakReference);
    }

    @Override
    protected void initModel() {
        modelImp = new ModelImp();
    }

    @Override
    public void start(String url) {
        modelImp.getInfo(url, new Contart.MyCallBack() {
            @Override
            public void success(String json) {
                getView().success(json);
            }

            @Override
            public void error(String err) {
                getView().error(err);
            }
        });
    }
}
