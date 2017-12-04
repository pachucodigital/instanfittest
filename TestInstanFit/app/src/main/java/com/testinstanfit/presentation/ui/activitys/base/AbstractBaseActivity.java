package com.testinstanfit.presentation.ui.activitys.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Daniel Ruiz
 */

public abstract class AbstractBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        createPresenter();
        initUI();

    }

    /**@return resource layout id */
    public abstract int  getLayoutId();

    /**initialize the ui */
    public abstract void initUI();

    /**initialize the presenter of the activity*/
    public abstract void createPresenter();
}
