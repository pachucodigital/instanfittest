package com.testinstanfit.presentation.presenter.callback;

/**
 * Created by Daniel Ruiz
 */

public interface ICallback<T> {
    public void onSuccess(T result);
    public void onFail(Throwable error);
}
