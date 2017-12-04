package com.testinstanfit.domain.interactor;



import com.testinstanfit.app.InstanFitApplication;
import com.testinstanfit.daniel.R;
import com.testinstanfit.domain.interactor.base.AbstractBaseInteractor;
import com.testinstanfit.domain.model.trainer.ItemTrainer;
import com.testinstanfit.domain.model.trainer.ResponseTrainerList;
import com.testinstanfit.presentation.presenter.callback.ICallback;
import com.testinstanfit.data.retrofit.ApiService;
import com.testinstanfit.data.retrofit.RetrofitFactoryService;

import java.util.List;

/**
 * Created by Daniel Ruiz
 */

public class ListInteractor extends AbstractBaseInteractor {

    private static final String TAG = ListInteractor.class.getSimpleName();

    public void loadData(final ICallback<List<ItemTrainer>> iCallback) {
        ApiService service = RetrofitFactoryService.createService(ApiService.class);

        RetrofitFactoryService.getEntityResponseCallback(new ICallback<ResponseTrainerList>() {
            @Override
            public void onSuccess(final ResponseTrainerList result) {
                if(result != null  && result.getArray() != null && !result.getArray().isEmpty()){
                     iCallback.onSuccess(result.getArray());
                }else{

                  iCallback.onFail(new Throwable(InstanFitApplication.getInstance().getString(R.string.empty_list)));
                }

            }

            @Override
            public void onFail(final Throwable error) {
                iCallback.onFail(error);
            }
        }, service.getListItems());
    }


}
