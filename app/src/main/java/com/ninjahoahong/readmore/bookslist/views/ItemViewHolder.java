package com.ninjahoahong.readmore.bookslist.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ninjahoahong.readmore.R;
import com.ninjahoahong.readmore.data.models.Book;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.name) TextView name;
    @BindView(R.id.thumbnail) ImageView thumbnail;

    public ItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Book book) {
        this.name.setText(book.volumeInfo().title());
        String linkThumbnail = book.volumeInfo().imageLinks().smallThumbnail();
        if (book.volumeInfo().imageLinks().smallThumbnail() != null) {
            RequestOptions options = new RequestOptions();
            options.fitCenter();
            Glide.with(itemView.getContext())
                    .load(linkThumbnail)
                    .apply(options)
                    .into(thumbnail);
        }
    }
}