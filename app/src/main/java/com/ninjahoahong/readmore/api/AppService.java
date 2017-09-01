package com.ninjahoahong.readmore.api;


import com.ninjahoahong.readmore.data.models.BookShelf;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface AppService {
    @GET("volumes")
    Observable<BookShelf> getBookShelf(@QueryMap Map<String, String> options);
}
