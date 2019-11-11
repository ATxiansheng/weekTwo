package com.baway.baiweitong.day1111.contart;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:契约类
 * */
public interface Contart {
    interface MyCallBack {
        void success(String json);

        void error(String err);
    }

    interface IModel {
        void getInfo(String url, MyCallBack myCallBack);
    }

    interface IView {
        void success(String json);

        void error(String err);
    }

    interface IPresenter {
        void start(String url);
    }
}
