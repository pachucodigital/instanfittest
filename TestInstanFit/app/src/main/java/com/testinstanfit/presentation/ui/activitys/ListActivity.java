package com.testinstanfit.presentation.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.testinstanfit.app.utils.Logger;
import com.testinstanfit.app.utils.TYPE_VIEW_LIST;
import com.testinstanfit.daniel.R;
import com.testinstanfit.data.preference.SettingsPreference;
import com.testinstanfit.domain.interactor.ListInteractor;
import com.testinstanfit.domain.model.trainer.ItemTrainer;
import com.testinstanfit.presentation.adapters.AdapterItemList;
import com.testinstanfit.presentation.presenter.ListPresenter;
import com.testinstanfit.presentation.ui.activitys.base.AbstractBaseActivity;
import com.testinstanfit.presentation.view.IListView;

import java.util.List;


/**
 * Created by Daniel Ruiz
 */

public class ListActivity extends AbstractBaseActivity implements IListView {


    private static final String TAG = ListActivity.class.getSimpleName();
    private ListPresenter mPresenter;
    private RecyclerView mRecyclerView;



    private  List<ItemTrainer>allItems;
    private RelativeLayout loader;
    private TYPE_VIEW_LIST typeViewList = TYPE_VIEW_LIST.LIST;
    private SettingsPreference settingsPreference = new SettingsPreference();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        typeViewList = settingsPreference.getType();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_list;
    }

    @Override
    public void initUI() {

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(getString(R.string.trainers));


        }
        loader = (RelativeLayout) findViewById(R.id.loader_layout);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        mPresenter.loadData();


    }

    private void updateTypeList() {
        switch (typeViewList) {
            case LIST:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                break;
            case GRID:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;

        }



        mRecyclerView.setAdapter(new AdapterItemList(new View.OnClickListener(){

            @Override
            public void onClick(final View view) {
                final Intent intent = new Intent(ListActivity.this,DetailAcitivity.class);
                final ItemTrainer itemTrainer = (ItemTrainer) view.getTag();
                intent.putExtra(DetailAcitivity.BUNDLE_TRAINER,new Gson().toJson(itemTrainer));
                startActivity(intent);
            }
        }, allItems,typeViewList) );
    }

    @Override
    public void createPresenter() {
        mPresenter = new ListPresenter(new ListInteractor());
        mPresenter.attachView(this);
    }

    @Override
    public void showLoader(final boolean show) {
        if(show){
            loader.setVisibility(View.VISIBLE);
        }else{
            loader.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(final Throwable error) {
        Snackbar.make(findViewById(R.id.toolbar), error.getMessage(), Snackbar.LENGTH_LONG).show();
        Logger.e(TAG, "Error->"+error.getMessage());

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }


    @Override
    public void showDataList(final List<ItemTrainer> itemList) {

        allItems = itemList;
        updateTypeList();

    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem  item = menu.findItem(R.id.action_configuration);
        if (item != null) {
            if (typeViewList == TYPE_VIEW_LIST.LIST) {
                item.setIcon(R.drawable.ic_view_grid);

            }else if (typeViewList == TYPE_VIEW_LIST.GRID) {
                item.setIcon(R.drawable.ic_view_list);
            }

        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_configuration){
            if (typeViewList == TYPE_VIEW_LIST.LIST) {
                typeViewList =TYPE_VIEW_LIST.GRID;
                item.setIcon(R.drawable.ic_view_list);
            }else if (typeViewList == TYPE_VIEW_LIST.GRID) {
                typeViewList =TYPE_VIEW_LIST.LIST;

                item.setIcon(R.drawable.ic_view_grid);
            }
            settingsPreference.saveType(typeViewList);
            updateTypeList();
        }



        return super.onOptionsItemSelected(item);
    }




}
