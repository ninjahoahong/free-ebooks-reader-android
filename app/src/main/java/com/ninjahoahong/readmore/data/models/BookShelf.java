package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class BookShelf implements Parcelable{

    public abstract int totalItems();

    @SerializedName("items")
    public abstract List<Book> books();

    public static TypeAdapter<BookShelf> typeAdapter(Gson gson) {
        return new AutoValue_BookShelf.GsonTypeAdapter(gson);
    }
}
