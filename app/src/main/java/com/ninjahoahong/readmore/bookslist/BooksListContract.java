package com.ninjahoahong.readmore.bookslist;

import android.support.v7.util.DiffUtil;
import android.util.Pair;

import com.ninjahoahong.readmore.BasePresenter;
import com.ninjahoahong.readmore.BaseView;
import com.ninjahoahong.readmore.data.models.Book;

import java.util.List;

public interface BooksListContract {
    interface View extends BaseView<Presenter> {

        void setLoading(boolean isLoading);

        void showError(String message);

        void showBooksList(Pair<DiffUtil.DiffResult, List<Book>> books);

        Pair<DiffUtil.DiffResult, List<Book>> calculateDiff(List<Book> books);
    }

    interface Presenter extends BasePresenter {

        void loadBooks();

        void openTheBook(Book book);
    }
}
