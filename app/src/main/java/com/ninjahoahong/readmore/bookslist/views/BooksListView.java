package com.ninjahoahong.readmore.bookslist.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.ninjahoahong.readmore.R;
import com.ninjahoahong.readmore.bookslist.BooksListContract;
import com.ninjahoahong.readmore.bookslist.BooksListPresenter;
import com.ninjahoahong.readmore.data.models.Book;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static dagger.internal.Preconditions.checkNotNull;

public class BooksListView extends FrameLayout implements BooksListContract.View {

    @BindView(R.id.view_error)
    Button errorView;

    @BindView(R.id.view_empty)
    TextView emptyView;

    @BindView(R.id.view_loading)
    ProgressBar loadingView;

    @BindView(R.id.viewanimator_content)
    ViewAnimator viewAnimator;

    @BindView(R.id.books_list)
    RecyclerView bookListView;

    BooksListAdaper booksListAdaper;
    BooksListContract.Presenter booksListPresenter;

    public BooksListView(Context context) {
        super(context);
        init(context, null);
    }

    public BooksListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    @Override
    public Pair<DiffUtil.DiffResult, List<Book>> calculateDiff(List<Book> books) {
        return Pair.create(DiffUtil.calculateDiff(
                new BooksListDiffCallBack(booksListAdaper.getData(), books)), books);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        booksListAdaper = new BooksListAdaper(
                getContext(), new ArrayList<>(0), bookItemListener);
        bookListView.setAdapter(booksListAdaper);
        bookListView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    public void init(Context context, AttributeSet attrs) {
        booksListPresenter =  new BooksListPresenter(this);
    }

    BooksListAdaper.ItemListener bookItemListener = new BooksListAdaper.ItemListener() {
        @Override
        public void onClick(Book book) {
            booksListPresenter.openTheBook(book);
        }
    };

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        booksListPresenter.loadBooks();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        booksListPresenter.unsubscribe();
    }

    @Override
    public void setLoading(boolean isLoading) {
        switchToView(loadingView);
    }

    private void switchToView(View view) {
        viewAnimator.setDisplayedChild(viewAnimator.indexOfChild(view));
    }

    @Override
    public void showError(String message) {
        Log.d("error", message);
        switchToView(errorView);
        errorView.setText(R.string.button_reset);
    }

    @OnClick(R.id.view_error)
    void onRetryClicked() {
        booksListPresenter.loadBooks();
    }

    public void showEmpty() {
        switchToView(emptyView);
    }

    @Override
    public void showBooksList(
            Pair<DiffUtil.DiffResult, List<Book>> pairOfDiffResultAndBooks) {
        switchToView(bookListView);
        if (booksListAdaper != null) {
            DiffUtil.DiffResult diffResult = pairOfDiffResultAndBooks.first;
            List<Book> books = pairOfDiffResultAndBooks.second;
            booksListAdaper.setData(books);
            diffResult.dispatchUpdatesTo(booksListAdaper);
            if (books.isEmpty()) {
                showEmpty();
            } else {
                switchToView(bookListView);
            }
        }
    }

    @Override
    public void setPresenter(@NonNull BooksListContract.Presenter presenter) {
        booksListPresenter = checkNotNull(presenter);
    }


}