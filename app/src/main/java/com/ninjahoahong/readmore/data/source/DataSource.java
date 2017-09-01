package com.ninjahoahong.readmore.data.source;

import com.ninjahoahong.readmore.data.models.Book;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;


public interface DataSource {

    Observable<List<Book>> getBooks(Map<String, String> options);
}
