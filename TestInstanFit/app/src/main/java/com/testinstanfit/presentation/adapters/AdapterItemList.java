package com.testinstanfit.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testinstanfit.app.InstanFitApplication;
import com.testinstanfit.app.utils.TYPE_VIEW_LIST;
import com.testinstanfit.daniel.R;
import com.testinstanfit.domain.model.trainer.ItemTrainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Ruiz
 */

public class AdapterItemList extends RecyclerView.Adapter<ViewHolderList>{

    private static final String TAG = AdapterItemList.class.getSimpleName();


    private TYPE_VIEW_LIST  typeViewList ;
    private List<ItemTrainer> mData;
    private View.OnClickListener mOnClickListener;

    public AdapterItemList(final View.OnClickListener onClickListener, final List<ItemTrainer>mData, final TYPE_VIEW_LIST type_view_list){
        this.mData = mData;
        this.typeViewList = type_view_list;
        this.mOnClickListener = onClickListener;
    }
    @Override
    public ViewHolderList onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = null;
        switch (typeViewList){
            case LIST: view =LayoutInflater.from(InstanFitApplication.getInstance()).inflate(R.layout.layout_item_data_list_trainer,null); break;
            case GRID: view =LayoutInflater.from(InstanFitApplication.getInstance()).inflate(R.layout.layout_item_data_grid_trainer,null); break;


        }

        return new ViewHolderList(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderList holder, int position) {
      holder.onBind(mData.get(position));
      holder.getMainView().setTag(mData.get(position));
      holder.getMainView().setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mData != null && mData.size()>0? mData.size():0;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }




    public ItemTrainer getItem(int position) {
        return mData.get(position);
    }

    public void updateViewType(final TYPE_VIEW_LIST typeViewList){
        this.typeViewList = typeViewList;
        notifyDataSetChanged();
    }

}
