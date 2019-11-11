package com.baway.baiweitong.day1111.base;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:基类
 * */
import com.baway.baiweitong.day1111.contart.Contart;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contart.IView> implements Contart.IPresenter {
    WeakReference<V> weakReference;

    public BasePresenter(WeakReference<V> weakReference) {
        initModel();
    }

    public void onAttch(V v) {
        weakReference = new WeakReference<>(v);
    }

    public V getView() {
        return weakReference.get();
    }

    public void onDeAttch() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    protected abstract void initModel();
}
