package com.ninjahoahong.readmore.utils;

import android.os.Parcelable;

import com.zhuinden.simplestack.navigator.StateKey;
import com.zhuinden.simplestack.navigator.ViewChangeHandler;
import com.zhuinden.simplestack.navigator.changehandlers.SegueViewChangeHandler;

public abstract class Key implements StateKey, Parcelable {
    @Override
    public ViewChangeHandler viewChangeHandler() {
        return new SegueViewChangeHandler();
    }

    public abstract int layout();
}