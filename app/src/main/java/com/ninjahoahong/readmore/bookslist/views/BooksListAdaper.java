package com.ninjahoahong.readmore.bookslist.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ninjahoahong.readmore.R;
import com.ninjahoahong.readmore.data.models.Book;

import java.util.Collections;
import java.util.List;

import static dagger.internal.Preconditions.checkNotNull;


public class BooksListAdaper extends RecyclerView.Adapter {

    public interface ItemListener {
        void onClick(Book book);
    }

    ItemListener itemListener;
    List<Book> books;
    private static final int VIEW_TYPE_ITEM = 2;
    private static final int VIEW_TYPE_HEADER = 1;
    private final Context context;

    public BooksListAdaper(
            Context context, List<Book> books, ItemListener itemListener) {
        setData(books);
        this.itemListener = itemListener;
        this.context = context;
        notifyDataSetChanged();
    }

    public void setData(List<Book> books) {
        this.books = checkNotNull(books);
    }

    public List<Book> getData() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                View headerView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.view_header, parent, false);
                return new HeaderViewHolder(headerView);
            case VIEW_TYPE_ITEM:
            default:
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.view_item, parent, false);
                return new ItemViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_HEADER:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                headerViewHolder.bind(context.getString(R.string.app_name));
                break;
            case VIEW_TYPE_ITEM:
                Book currentItem = books.get(position -1);
                ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                itemViewHolder.bind(currentItem);
                itemViewHolder.itemView.setOnClickListener(
                        view -> {
                            Log.d("Click", currentItem.id());
                            itemListener.onClick(currentItem);
                        });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) {
            return VIEW_TYPE_HEADER;
        } else {
            return VIEW_TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return books == null ? 0 : books.size() + 1;
    }

    private boolean isHeader(int position) {
        return position == 0;
    }
}