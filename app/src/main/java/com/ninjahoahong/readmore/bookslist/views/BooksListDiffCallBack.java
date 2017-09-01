package com.ninjahoahong.readmore.bookslist.views;

import android.support.v7.util.DiffUtil;

import com.ninjahoahong.readmore.data.models.Book;

import java.util.List;

class BooksListDiffCallBack
        extends DiffUtil.Callback {
    private List<Book> oldBooks;
    private List<Book> newBooks;

    public BooksListDiffCallBack(List<Book> oldBooks, List<Book> newBooks) {
        this.oldBooks = oldBooks;
        this.newBooks = newBooks;
    }

    @Override
    public int getOldListSize() {
        return oldBooks == null ? 0 : oldBooks.size();
    }

    @Override
    public int getNewListSize() {
        return newBooks.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newBooks.get(newItemPosition).id()
                .equals(oldBooks.get(oldItemPosition).id());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return newBooks.get(newItemPosition).equals(oldBooks.get(oldItemPosition));
    }
}
