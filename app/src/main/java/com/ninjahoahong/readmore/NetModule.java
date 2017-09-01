package com.ninjahoahong.readmore;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.ninjahoahong.readmore.api.AppService;
import com.ninjahoahong.readmore.data.models.AutoValueGsonFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetModule {

    private final String baseUrl;

    public NetModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    AppService provideService(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(AppService.class);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder
                .registerTypeAdapterFactory(AutoValueGsonFactory.create())
                .create();
    }

    @Provides
    @Singleton
    Cache provideHttpCache(Context context) {
        return new Cache(context.getCacheDir(), BuildConfig.MAX_HTTP_CACHE_SIZE);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.cache(cache);

        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);

        clientBuilder.connectTimeout(10, TimeUnit.DAYS);
        clientBuilder.readTimeout(10, TimeUnit.DAYS);

        clientBuilder
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(BuildConfig.REST_ADAPTER_LOG_LEVEL));

        return clientBuilder.build();
    }

}
