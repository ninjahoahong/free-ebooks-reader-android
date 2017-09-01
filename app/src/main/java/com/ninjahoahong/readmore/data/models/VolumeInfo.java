package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

import javax.annotation.Nullable;

@AutoValue
public abstract class VolumeInfo implements Parcelable {

    public abstract List<IndustryIdentifiersItem> industryIdentifiers();

    public abstract int pageCount();

    public abstract String printType();

    public abstract ReadingModes readingModes();

    public abstract String previewLink();

    public abstract String canonicalVolumeLink();

    @Nullable
    public abstract String description();

    public abstract String language();

    public abstract String title();

    public abstract ImageLinks imageLinks();

    @Nullable
    public abstract PanelizationSummary panelizationSummary();

    @Nullable
    public abstract String publisher();

    public abstract String publishedDate();

    public abstract String maturityRating();

    public abstract boolean allowAnonLogging();

    public abstract String contentVersion();

    public abstract List<String> authors();

    public abstract String infoLink();

    public static TypeAdapter<VolumeInfo> typeAdapter(Gson gson) {
        return new AutoValue_VolumeInfo.GsonTypeAdapter(gson);
    }
}