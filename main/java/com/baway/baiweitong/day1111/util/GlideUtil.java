package com.baway.baiweitong.day1111.util;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:Glide
 * */
import android.widget.ImageView;

import com.baway.baiweitong.day1111.R;
import com.baway.baiweitong.day1111.myapp.MyApp;
import com.bumptech.glide.Glide;

public class GlideUtil {
    public static void getPic(String url, ImageView imageView) {
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
