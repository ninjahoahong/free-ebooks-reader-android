package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import javax.annotation.Nullable;

@AutoValue
public abstract class Book implements Parcelable {

    public abstract SaleInfo saleInfo();

    @Nullable
    public abstract SearchInfo searchInfo();

    public abstract String kind();

    public abstract VolumeInfo volumeInfo();

    public abstract String etag();

    public abstract String id();

    public abstract AccessInfo accessInfo();

    public abstract String selfLink();

    public static TypeAdapter<Book> typeAdapter(Gson gson) {
        return new AutoValue_Book.GsonTypeAdapter(gson);
    }
}