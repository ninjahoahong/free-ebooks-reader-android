package com.ninjahoahong.readmore;


import android.content.Context;

import com.ninjahoahong.readmore.bookslist.views.BooksListViewKey;
import com.ninjahoahong.readmore.utils.schedulers.BaseSchedulerProvider;
import com.ninjahoahong.readmore.utils.schedulers.SchedulerProvider;
import com.zhuinden.simplestack.Backstack;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class AppModule {
    private final Context context;
    private Backstack backstack;
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
    @Singleton
    Backstack provideBackStackHolder() {
        if (backstack == null) {
            backstack = new Backstack(BooksListViewKey.create());
        }
        return backstack;
    }

    @Provides
    BaseSchedulerProvider getSchedulerProvider() {
        if (schedulerProvider == null) {
            schedulerProvider = new SchedulerProvider();
        }
        return schedulerProvider;
    }

}
