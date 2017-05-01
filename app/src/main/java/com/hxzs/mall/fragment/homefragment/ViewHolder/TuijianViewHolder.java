package com.hxzs.mall.fragment.homefragment.ViewHolder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.hxzs.mall.R;
import com.hxzs.mall.fragment.homefragment.Adapter.TuijianAdapter;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.interfaces.RecycleViewclick;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/28 13:20
 */
public class TuijianViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerView mRecyclerView;

    public TuijianViewHolder(View itemView) {
        super(itemView);
        mRecyclerView = (RecyclerView) itemView.findViewById(R.id.home_recycle_tuijian2);
    }


    public void setdata(final Context context, HomeBean.ResultBean result) {
        TuijianAdapter adapter = new TuijianAdapter(context,result);
        mRecyclerView.setLayoutManager(new GridLayoutManager(context,3));
        mRecyclerView.setAdapter(adapter);

        adapter.setoncliect(new RecycleViewclick() {
            @Override
            public void clik(int position) {
                Toast.makeText(context,""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
