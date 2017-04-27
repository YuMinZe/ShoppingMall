package com.hxzs.mall.fragment.homefragment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hxzs.mall.R;
import com.hxzs.mall.fragment.homefragment.ViewHolder.BannerViewHolder;
import com.hxzs.mall.fragment.homefragment.ViewHolder.GridViewHolder;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/26 13:14
 */
public class HomeRecycleAdapter extends RecyclerView.Adapter {
    private final Context context;           //上下文
    private final HomeBean.ResultBean result;       //数据
    private final LayoutInflater mLayoutInflater;       //布局管理器
    //banner自动轮波条
    private static final int Item1 = 0;
    //recycleview布局管理器
    private static final int Item2 = 1;
    private static final int Item3 = 2;
    private static final int Item4 = 3;
    private static final int Item5 = 4;
    private static final int Item6 = 5;
    private int TYPE = 0;

    public HomeRecycleAdapter(Context context, HomeBean.ResultBean result) {
        this.context = context;
        this.result = result;
        //布局管理器
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0){
            return new BannerViewHolder(context,mLayoutInflater.inflate(R.layout.home_recycle_banner,null));
        }else if(viewType == 1){
            return new GridViewHolder(mLayoutInflater.inflate(R.layout.home_recycle_gridview,null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == Item1){
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.setdata(result.getBanner_info());
        }else if(getItemViewType(position) == Item2){
            GridViewHolder gridViewHolder = (GridViewHolder) holder;
            gridViewHolder.setdata(result.getChannel_info(),context);
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                TYPE = Item1;
                break;
            case 1:
                TYPE = Item2;
                break;
            case 2:
                TYPE = Item3;
                break;
            case 3:
                TYPE = Item4;
                break;
            case 4:
                TYPE = Item5;
                break;
            case 5:
                TYPE = Item6;
                break;
        }
        return TYPE;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
