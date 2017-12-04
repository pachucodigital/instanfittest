package com.testinstanfit.presentation.ui.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.testinstanfit.daniel.R;
import com.testinstanfit.domain.model.trainer.ItemTrainer;
import com.testinstanfit.presentation.ui.activitys.base.AbstractBaseActivity;

/**
 * Created by Daniel Ruiz
 */

public class DetailAcitivity extends AbstractBaseActivity {
    public static final String BUNDLE_TRAINER = "BUNDLE_TRAINER";
    private ItemTrainer trainer;


    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void initUI() {
        trainer = new Gson().fromJson(getIntent().getStringExtra(BUNDLE_TRAINER),ItemTrainer.class);
        WebView mTextView  = (WebView) findViewById(R.id.webview);
        ImageView mImageView = (ImageView) findViewById(R.id.img);

        final Toolbar  toolbar =(Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(trainer.getName());
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Picasso.with(mImageView.getContext())
                .load(trainer.getAvatarPictures().getFullSize())
                .fit()
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .into(mImageView);

        mTextView.loadData(trainer.getDescription(), "text/html", "UTF-8");
    }

    @Override
    public void createPresenter() {

    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return true;
    }
}
