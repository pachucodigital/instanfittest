package com.testinstanfit.data.retrofit;

import com.testinstanfit.domain.model.trainer.ResponseTrainerList;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Daniel
 */

public interface ApiService {
    @GET("user/697257/a6kt_yP5y8opx9sz_9Pe/catalog_of/coaches")
    Observable<Response<ResponseTrainerList>> getListItems();
}
