package com.ninjahoahong.readmore;

import com.ninjahoahong.readmore.bookslist.BooksListPresenter;
import com.ninjahoahong.readmore.data.source.remote.RemoteDataSource;
import com.ninjahoahong.readmore.data.source.RepositoryModule;
import com.ninjahoahong.readmore.bookslist.views.BooksListViewKey;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        RepositoryModule.class,
        AppModule.class,
        NetModule.class
})
public interface AppComponent {
    void inject(RemoteDataSource remoteDataSource);
    void inject(BooksListViewKey booksListView);
    void inject(BooksListPresenter booksListPresenter);
    void inject(MainActivity mainActivity);
}
