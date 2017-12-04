package com.testinstanfit.presentation.adapters.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Daniel ruiz
 */

public abstract class AbstractHolderBase<T> extends RecyclerView.ViewHolder {
    protected  View mMainView;
    public AbstractHolderBase(final View itemView) {
        super(itemView);
        this.mMainView = itemView;
    }

    public abstract void onBind(final T object);


    public View getMainView(){
        return  mMainView;
    }



}