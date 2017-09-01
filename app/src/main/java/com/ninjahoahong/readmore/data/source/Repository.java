package com.ninjahoahong.readmore.data.source;

import android.support.annotation.NonNull;

import com.ninjahoahong.readmore.data.models.Book;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;


public class Repository {

    @NonNull
    private final DataSource remoteDataSource;

    @Inject
    Repository(@NonNull DataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public Observable<List<Book>> getBooks(Map<String, String> options) {
        return remoteDataSource.getBooks(options);
    }
}
