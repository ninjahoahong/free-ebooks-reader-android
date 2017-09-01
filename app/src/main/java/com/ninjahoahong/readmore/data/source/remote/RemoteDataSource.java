package com.ninjahoahong.readmore.data.source.remote;


import com.ninjahoahong.readmore.AndroidApp;
import com.ninjahoahong.readmore.api.AppService;
import com.ninjahoahong.readmore.data.models.Book;
import com.ninjahoahong.readmore.data.models.BookShelf;
import com.ninjahoahong.readmore.data.source.DataSource;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;


public class RemoteDataSource implements DataSource {

    @Inject
    AppService appService;

    public RemoteDataSource() {
        AndroidApp.getAppComponent().inject(this);
    }

    @Override
    public Observable<List<Book>> getBooks(Map<String, String> options) {
        return appService.getBookShelf(options)
                .map(BookShelf::books);
    }
}
