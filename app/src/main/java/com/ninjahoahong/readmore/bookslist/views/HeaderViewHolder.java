package com.ninjahoahong.readmore.bookslist.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ninjahoahong.readmore.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.textview_title) TextView name;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String name) {
        this.name.setText(name);
    }
}