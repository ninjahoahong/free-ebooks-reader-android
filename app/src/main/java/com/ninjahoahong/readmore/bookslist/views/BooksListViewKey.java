package com.ninjahoahong.readmore.bookslist.views;

import com.google.auto.value.AutoValue;
import com.ninjahoahong.readmore.R;
import com.ninjahoahong.readmore.utils.Key;

@AutoValue
public abstract class BooksListViewKey extends Key {
    @Override
    public int layout() {
        return R.layout.view_book_list;
    }

    public static BooksListViewKey create() {

        return new AutoValue_BooksListViewKey();
    }
}