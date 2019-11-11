package com.baway.baiweitong.day1111.adapter;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:Adapter
 * */
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:适配器
 * */
import com.baway.baiweitong.day1111.R;
import com.baway.baiweitong.day1111.bean.BeanJD;
import com.baway.baiweitong.day1111.util.GlideUtil;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterOne extends RecyclerView.Adapter {
    List<BeanJD.DataBean.GridDataBean> mList;
    List<BeanJD.DataBean.HorizontalListDataBean> horizontalListData;
    List<BeanJD.DataBean.VerticalListDataBean> verticalListData;
    Context context;

    public AdapterOne(List<BeanJD.DataBean.GridDataBean> mList, List<BeanJD.DataBean.HorizontalListDataBean> horizontalListData, List<BeanJD.DataBean.VerticalListDataBean> verticalListData, Context context) {
        this.mList = mList;
        this.horizontalListData = horizontalListData;
        this.verticalListData = verticalListData;
        this.context = context;
    }

    class oneHolder extends RecyclerView.ViewHolder{
        ImageView imageView1,imageView2,imageView3;

        public oneHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class twoHolder extends RecyclerView.ViewHolder{
        ImageView imageView1,imageView2;
        TextView textView1,textView2,textView3,textView4;

        public twoHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class threeHolder extends RecyclerView.ViewHolder{
        ImageView imageView1,imageView2;
        TextView textView1,textView2,textView3,textView4;

        public threeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = null;
        switch (i){
            case 1:
                view.inflate(context, R.layout.layout_item1,null);
                viewHolder = new oneHolder(view);
                ((oneHolder) viewHolder).imageView1 = view.findViewById(R.id.image1);
                ((oneHolder) viewHolder).imageView2 = view.findViewById(R.id.image2);
                ((oneHolder) viewHolder).imageView3 = view.findViewById(R.id.image3);
                break;
            case 2:
                view.inflate(context, R.layout.layout_item2,null);
                viewHolder = new twoHolder(view);
                ((twoHolder) viewHolder).imageView1 = view.findViewById(R.id.image1_2);
                ((twoHolder) viewHolder).imageView2 = view.findViewById(R.id.image2_2);
                ((twoHolder) viewHolder).textView1 = view.findViewById(R.id.text1_2);
                ((twoHolder) viewHolder).textView2 = view.findViewById(R.id.text2_2);
                ((twoHolder) viewHolder).textView3 = view.findViewById(R.id.text3_2);
                ((twoHolder) viewHolder).textView4 = view.findViewById(R.id.text4_2);
                break;
            case 3:
                view.inflate(context, R.layout.layout_item3,null);
                viewHolder = new threeHolder(view);
                ((threeHolder) viewHolder).imageView1 = view.findViewById(R.id.image1_3);
                ((threeHolder) viewHolder).imageView2 = view.findViewById(R.id.image2_3);
                ((threeHolder) viewHolder).textView1 = view.findViewById(R.id.text1_3);
                ((threeHolder) viewHolder).textView2 = view.findViewById(R.id.text2_3);
                ((threeHolder) viewHolder).textView3 = view.findViewById(R.id.text3_3);
                ((threeHolder) viewHolder).textView4 = view.findViewById(R.id.text4_3);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof oneHolder){
            GlideUtil.getPic(horizontalListData.get(0).getImageurl(),((oneHolder) viewHolder).imageView1);
            GlideUtil.getPic(horizontalListData.get(1).getImageurl(),((oneHolder) viewHolder).imageView2);
            GlideUtil.getPic(horizontalListData.get(2).getImageurl(),((oneHolder) viewHolder).imageView3);
        }else if(viewHolder instanceof twoHolder){
            GlideUtil.getPic(verticalListData.get(0).getImageurl(),((twoHolder) viewHolder).imageView1);
            ((twoHolder) viewHolder).textView1.setText(verticalListData.get(0).getTitle());
            ((twoHolder) viewHolder).textView2.setText(verticalListData.get(0).getPrice());
            GlideUtil.getPic(verticalListData.get(1).getImageurl(),((twoHolder) viewHolder).imageView2);
            ((twoHolder) viewHolder).textView3.setText(verticalListData.get(1).getTitle());
            ((twoHolder) viewHolder).textView4.setText(verticalListData.get(1).getPrice());
        }else if (viewHolder instanceof threeHolder){
            GlideUtil.getPic(mList.get(0).getImageurl(),((threeHolder) viewHolder).imageView1);
            ((threeHolder) viewHolder).textView1.setText(mList.get(0).getTitle());
            ((threeHolder) viewHolder).textView2.setText(mList.get(0).getPrice());
            GlideUtil.getPic(mList.get(1).getImageurl(),((threeHolder) viewHolder).imageView2);
            ((threeHolder) viewHolder).textView3.setText(mList.get(1).getTitle());
            ((threeHolder) viewHolder).textView4.setText(mList.get(1).getPrice());
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        onItemClickListener.item(position);
        return position;
    }
    OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void item(int item);
    }
}
