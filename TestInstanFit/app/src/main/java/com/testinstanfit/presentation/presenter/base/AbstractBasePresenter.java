package com.testinstanfit.presentation.presenter.base;


import com.testinstanfit.domain.interactor.base.AbstractBaseInteractor;
import com.testinstanfit.presentation.view.IView;

/**
 * Created by Daniel Ruiz
 */

public abstract class AbstractBasePresenter {
    protected IView mView;
    protected AbstractBaseInteractor mInteractor;

    public AbstractBasePresenter(final AbstractBaseInteractor abstractBaseInteractor){
        this.mInteractor = abstractBaseInteractor;
    }


    public  void attachView(final IView mView){
        this.mView = mView;
    }

    public void detachView(){
        this.mView =null;
    }

    public abstract IView getView();
    public abstract AbstractBaseInteractor getInteractor();


}
