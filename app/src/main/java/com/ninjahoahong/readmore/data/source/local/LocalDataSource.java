package com.ninjahoahong.readmore.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ninjahoahong.readmore.data.models.Book;
import com.ninjahoahong.readmore.data.source.DataSource;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

import static dagger.internal.Preconditions.checkNotNull;


@Singleton
public class LocalDataSource implements DataSource {


    private DatabaseHelper databaseHelper;

    @Inject
    public LocalDataSource(@NonNull Context context) {
        checkNotNull(context);
        databaseHelper = new DatabaseHelper(context);
    }

    @Override
    public Observable<List<Book>> getBooks(Map<String, String> options) {
        return null;
    }
}
