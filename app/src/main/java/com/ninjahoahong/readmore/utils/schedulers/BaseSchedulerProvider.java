package com.ninjahoahong.readmore.utils.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

public interface BaseSchedulerProvider {

    @NonNull
    Scheduler background();

    @NonNull
    Scheduler ui();
}
