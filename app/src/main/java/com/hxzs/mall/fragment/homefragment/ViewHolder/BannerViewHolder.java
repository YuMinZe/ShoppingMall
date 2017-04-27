package com.hxzs.mall.fragment.homefragment.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hxzs.mall.R;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.utils.Constants;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/26 14:11
 */
public class BannerViewHolder extends RecyclerView.ViewHolder {

    private final Context context;
    private final Banner mBanner;
    private List<HomeBean.ResultBean.BannerInfoBean> mData;
    private List<String> list  =  new ArrayList();
    public BannerViewHolder(Context context, View inflate) {
        super(inflate);
        this.context = context;
        mBanner = (Banner) inflate.findViewById(R.id.home_recycle_banner);
    }

    public void setdata(List<HomeBean.ResultBean.BannerInfoBean> data) {
        this.mData = data;
        //由于数据是一个大型的数据字符串,而banner只需要这个图片的集合  所以创建一个集合把图片的yrl抽出来
        for (int i = 0; i < mData.size(); i++) {
            list.add(Constants.ImageURL+mData.get(i).getImage());
        }
        //banner加载图片
        mBanner.setImages(list)
                .setImageLoader(new MyImageloder())
                .start();

        mBanner.setBannerAnimation(Transformer.DepthPage);
    }
}
