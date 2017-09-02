package com.ninjahoahong.readmore;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.ninjahoahong.readmore.bookslist.views.BooksListViewKey;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.HistoryBuilder;
import com.zhuinden.simplestack.StateChange;
import com.zhuinden.simplestack.navigator.DefaultStateChanger;
import com.zhuinden.simplestack.navigator.Navigator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.views_container)
    FrameLayout appContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidApp.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Backstack backstack = Navigator.configure()
                .setStateChanger(DefaultStateChanger.create(this, appContainer))
                .install(this, appContainer, HistoryBuilder.single(
                        BooksListViewKey.create()));
    }

    @Override
    public void onBackPressed() {
        if (!Navigator.onBackPressed(this)) {
            super.onBackPressed();
        }
    }

    private void replaceHistory(Object rootKey) {
        Navigator.getBackstack(this)
                .setHistory(HistoryBuilder.single(rootKey),
                        StateChange.REPLACE);
    }

    public Backstack getBackStack() {
        return Navigator.getBackstack(this);
    }

    public void navigateTo(Object key) {
        Navigator.getBackstack(this).goTo(key);
    }

    public static MainActivity get(Context context) {
        // noinspection ResourceType
        return (MainActivity) context.getSystemService(TAG);
    }

    @Override
    public Object getSystemService(@NonNull String name) {
        Log.d(TAG, TAG);
        Log.d(TAG, name);
        if (TAG.equals(name)) {
            return this;
        }
        return super.getSystemService(name);
    }
}
