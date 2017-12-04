package com.testinstanfit.data.retrofit;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.testinstanfit.app.utils.ConectionManager;
import com.testinstanfit.daniel.BuildConfig;
import com.testinstanfit.presentation.presenter.callback.ICallback;

import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class RetrofitFactoryService {


    @NonNull
    private static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
        builder.interceptors().add(loggingInterceptor);


        return builder.build();
    }

    @NonNull
    private static Retrofit getRetrofit() {
        Gson gson = new GsonBuilder().create();


        OkHttpClient client = getOkHttpClient();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.APPLICATION_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();


        return retrofit;
    }

    @NonNull
    private static Retrofit getRetrofit(final String host) {
        // Define the Gson date formatter


        OkHttpClient client = getOkHttpClient();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();


        return retrofit;
    }

    public static <T> T createService(Class<T> classType) {
        Retrofit retrofit = getRetrofit();
        T service = retrofit.create(classType);

        return service;
    }
    public static <T> T createService(Class<T> classType,String host) {
        Retrofit retrofit = getRetrofit(host);
        T service = retrofit.create(classType);

        return service;
    }




    public static <T> void getEntityResponseCallback(@NonNull final ICallback callback, final Observable<Response<T>> service) {
        try {
            service.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())

                    .subscribe(new Action1<Response<T>>() {
                        @Override
                        public void call(Response<T> response) {
                            onSucces(response, callback);
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            onError(throwable, callback);
                        }
                    });
        } catch (final Exception exception) {
            callback.onFail(exception);
        }
    }

    private static void onError(final Throwable throwable, @NonNull final ICallback callback) {
       if(throwable instanceof UnknownHostException) {
            ConectionManager connectivity = new ConectionManager();

            if(connectivity.isConnected()) {
                callback.onFail(new Exception("Server Error"));
            } else {
                callback.onFail(new Exception("Device Not Connect"));
            }
        }
        else{
            callback.onFail(throwable);
        }
    }

    private static <T> void onSucces(final Response<T> response, @NonNull final  ICallback callback) {
        switch (response.code()){
            case 200 : callback.onSuccess(response.body());
        }

    }

}
