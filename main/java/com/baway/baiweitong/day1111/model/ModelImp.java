package com.baway.baiweitong.day1111.model;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:Model
 * */
import com.baway.baiweitong.day1111.contart.Contart;
import com.baway.baiweitong.day1111.util.VolleyUtil;

public class ModelImp implements Contart.IModel {
    @Override
    public void getInfo(String url, final Contart.MyCallBack myCallBack) {
        VolleyUtil.getInstance().getJson(url, new VolleyUtil.MyCallBack() {
            @Override
            public void success(String json) {
                myCallBack.success(json);
            }

            @Override
            public void error(String err) {
                myCallBack.error(err);
            }
        });
    }
}
