package com.baway.baiweitong.day1111.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;

import com.baway.baiweitong.day1111.contart.Contart;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:基类
 * */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements Contart.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayout()!=0){
            setContentView(getLayout());
            initView();
            mPresenter = getPresenter();
            mPresenter.onAttch(this);
            setEnCoding();
        }
    }

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDeAttch();
        }
    }

    protected abstract void setEnCoding();

    protected abstract P getPresenter();

    protected abstract int getLayout();
}
