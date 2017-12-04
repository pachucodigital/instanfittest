package com.testinstanfit.presentation.view;

/**
 * Created by Daniel Ruiz
 */

public interface IView {
    void showLoader(boolean show);
    void showError(Throwable error);
}
