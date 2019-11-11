package com.baway.baiweitong.day1111;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:View界面
 * */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.baway.baiweitong.day1111.adapter.AdapterOne;
import com.baway.baiweitong.day1111.base.BaseActivity;
import com.baway.baiweitong.day1111.base.BasePresenter;
import com.baway.baiweitong.day1111.bean.BeanJD;
import com.baway.baiweitong.day1111.myapp.MyApp;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {


    private RecyclerView recycler1;
    private ImageView imageView;

    @Override
    protected void initView() {
        //初始化控件
        recycler1 = findViewById(R.id.recycler_one);
        imageView = findViewById(R.id.image5);
    }

    @Override
    protected void setEnCoding() {
        recycler1.setLayoutManager(new LinearLayoutManager(MyApp.context,1,false));

    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void success(String json) {
        //解析Goson
        BeanJD.DataBean data = new Gson().fromJson(json, BeanJD.class).getData();
        List<BeanJD.DataBean.GridDataBean> gridData = data.getGridData();
        List<BeanJD.DataBean.HorizontalListDataBean> horizontalListData = data.getHorizontalListData();
        List<BeanJD.DataBean.VerticalListDataBean> verticalListData = data.getVerticalListData();
        AdapterOne adapterOne = new AdapterOne(gridData, horizontalListData, verticalListData, MyApp.context);
        recycler1.setAdapter(adapterOne);
    }

    @Override
    public void error(String err) {
        imageView.setImageResource(R.mipmap.ic_launcher);
    }
}
