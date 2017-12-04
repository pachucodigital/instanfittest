package com.testinstanfit.presentation.presenter;

import android.content.ClipData;

import com.testinstanfit.domain.interactor.ListInteractor;
import com.testinstanfit.domain.interactor.base.AbstractBaseInteractor;
import com.testinstanfit.domain.model.trainer.ItemTrainer;
import com.testinstanfit.presentation.presenter.base.AbstractBasePresenter;
import com.testinstanfit.presentation.presenter.callback.ICallback;
import com.testinstanfit.presentation.view.IListView;

import java.util.List;

/**
 * Created by Dell on 09/11/2017.
 */

public class ListPresenter extends AbstractBasePresenter {

    public ListPresenter(final AbstractBaseInteractor abstractBaseInteractor) {
        super(abstractBaseInteractor);
    }

    @Override
    public IListView getView() {
        return mView != null ? (IListView)mView: null;
    }

    @Override
    public ListInteractor getInteractor() {
        return mInteractor != null ? (ListInteractor)mInteractor: null;
    }

    public void loadData() {
        if(getView() != null && getInteractor() != null){
            getView().showLoader(true);
            getInteractor().loadData(new ICallback<List<ItemTrainer>>() {
                @Override
                public void onSuccess(final List<ItemTrainer> result) {
                    if (getView()!= null) {
                        getView().showLoader(false);
                        getView().showDataList(result);
                    }

                }

                @Override
                public void onFail(final Throwable error) {
                    if (getView()!= null) {
                        getView().showLoader(false);
                        getView().showError(error);
                    }
                }
            });
        }
    }
}
