package com.testinstanfit.presentation.ui.activitys;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.testinstanfit.daniel.BuildConfig;
import com.testinstanfit.daniel.R;
import com.testinstanfit.presentation.ui.activitys.base.AbstractBaseActivity;


/**
 * Created by Daniel Ruiz
 */

public class SplashActivity extends AbstractBaseActivity {

    public void initUI(){
        final TextView mTextVersion = (TextView)findViewById(R.id.txt_version);
        mTextVersion.setText(getString(R.string.txt_version)+ BuildConfig.VERSION_NAME);
        startAnimation();
    }


    /**initialize the animation  in the splash*/
    private void startAnimation() {
        final ImageView mImageViewIcon     = (ImageView) findViewById(R.id.ic_logo);
        final Animation fadeAnimation     = AnimationUtils.loadAnimation(this, R.anim.start);
        mImageViewIcon.startAnimation(fadeAnimation);
        fadeAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(final Animation animation) {
                //It is an intentional omission
            }
            @Override
            public void onAnimationEnd(final Animation animation) {
                startActivity(new Intent(SplashActivity.this, ListActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(final Animation animation) {
                //It is an intentional omission
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    public void createPresenter() {
        // this activity not has presenter
    }
}
