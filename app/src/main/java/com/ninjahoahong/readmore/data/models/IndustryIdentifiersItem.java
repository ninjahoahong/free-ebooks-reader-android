package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class IndustryIdentifiersItem implements Parcelable {

    public abstract String identifier();

    public abstract String type();

    public static TypeAdapter<IndustryIdentifiersItem> typeAdapter(Gson gson) {
        return new AutoValue_IndustryIdentifiersItem.GsonTypeAdapter(gson);
    }
}