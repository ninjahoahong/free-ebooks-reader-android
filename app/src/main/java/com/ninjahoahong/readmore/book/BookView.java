package com.ninjahoahong.readmore.book;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ninjahoahong.readmore.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookView extends FrameLayout {

    @BindView(R.id.detail_view)
    TextView textView;

    public BookView(Context context) {
        super(context);
        init(context, null);
    }

    public BookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void init(Context context, AttributeSet attrs) {
    }
}