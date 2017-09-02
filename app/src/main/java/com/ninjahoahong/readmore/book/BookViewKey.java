package com.ninjahoahong.readmore.book;

import com.google.auto.value.AutoValue;
import com.ninjahoahong.readmore.R;
import com.ninjahoahong.readmore.data.models.Book;
import com.ninjahoahong.readmore.utils.Key;

@AutoValue
public abstract class BookViewKey extends Key {

    public abstract Book book();

    @Override
    public int layout() {
        return R.layout.view_book_detail;
    }

    public static BookViewKey create(Book book) {
        return new AutoValue_BookViewKey(book);
    }
}