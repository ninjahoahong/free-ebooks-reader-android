package com.ninjahoahong.readmore.bookslist;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.util.Pair;

import com.ninjahoahong.readmore.AndroidApp;
import com.ninjahoahong.readmore.MainActivity;
import com.ninjahoahong.readmore.book.BookViewKey;
import com.ninjahoahong.readmore.data.models.Book;
import com.ninjahoahong.readmore.data.source.Repository;
import com.ninjahoahong.readmore.utils.schedulers.BaseSchedulerProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BooksListPresenter implements BooksListContract.Presenter {

    private final BooksListContract.View booksListView;

    @Inject
    CompositeDisposable compositeDisposable;

    @Inject
    Repository repository;

    @Inject
    BaseSchedulerProvider schedulerProvider;

    public BooksListPresenter(@NonNull BooksListContract.View booksListView) {
        AndroidApp.getAppComponent().inject(this);
        this.booksListView = booksListView;
    }

    @Override
    public void loadBooks() {
        Map<String, String> options = new HashMap<>();
        options.put("q", "a");
        options.put("filter", "free-ebooks");
        options.put("maxResults", "40");
        options.put("orderBy", "relevance");
        booksListView.setLoading(true);
        Disposable disposable = repository.getBooks(options)
                .subscribeOn(schedulerProvider.background())
                .map(booksListView::calculateDiff)
                .observeOn(schedulerProvider.ui())
                .subscribe(
                        this::processBooksList,
                        this::handleError
                );
        compositeDisposable.add(disposable);
    }

    @Override
    public void openTheBook(Book book) {
        MainActivity.get(booksListView.getContext()).navigateTo(BookViewKey.create(book));
    }

    private void handleError(Throwable throwable) {
        booksListView.setLoading(false);
        booksListView.showError(throwable.getLocalizedMessage());
    }

    private void processBooksList(
            Pair<DiffUtil.DiffResult, List<Book>> books) {
        booksListView.setLoading(false);
        booksListView.showBooksList(books);
    }

    @Override
    public void unsubscribe() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }
}
