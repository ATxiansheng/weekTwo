package com.baway.baiweitong.day1111.util;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:VolleyUtil
 * */
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baway.baiweitong.day1111.myapp.MyApp;

import java.io.UnsupportedEncodingException;

public class VolleyUtil {
    private static VolleyUtil volleyUtil;
    private final RequestQueue volley;

    private VolleyUtil() {
        volley = Volley.newRequestQueue(MyApp.context);
    }

    public static VolleyUtil getInstance() {
        if (volleyUtil == null) {
            volleyUtil = new VolleyUtil();
        }
        return volleyUtil;
    }
    public boolean Net(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo.isConnected()){
            return true;
        }
        return false;
    }
    public boolean NetIsWIFI(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo.isConnected()&&activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI){
            return true;
        }
        return false;
    }
    public interface MyCallBack {
        void success(String json);

        void error(String err);
    }
    public void getJson(String url, final MyCallBack myCallBack){
        StringRequest stringRequest = new StringRequest(1, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    String str = new String(response.getBytes("ISO-8859-1"),"UTF-8");
                    myCallBack.success(response);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.error(error.getMessage());
            }
        });
        volley.add(stringRequest);
    }
}
