package com.ninjahoahong.readmore;


import android.content.Context;

import com.ninjahoahong.readmore.utils.schedulers.BaseSchedulerProvider;
import com.ninjahoahong.readmore.utils.schedulers.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class AppModule {
    private final Context context;
    private CompositeDisposable compositeDisposable;
    private static SchedulerProvider schedulerProvider;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return context;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        return compositeDisposable;
    }

    @Provides
    BaseSchedulerProvider getSchedulerProvider() {
        if (schedulerProvider == null) {
            schedulerProvider = new SchedulerProvider();
        }
        return schedulerProvider;
    }

}
