package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class AccessInfo implements Parcelable {

    public abstract String accessViewStatus();

    public abstract String country();

    public abstract String viewability();

    public abstract Pdf pdf();

    public abstract String webReaderLink();

    public abstract Epub epub();

    public abstract boolean publicDomain();

    public abstract boolean quoteSharingAllowed();

    public abstract boolean embeddable();

    public abstract String textToSpeechPermission();

    public static TypeAdapter<AccessInfo> typeAdapter(Gson gson) {
        return new AutoValue_AccessInfo.GsonTypeAdapter(gson);
    }
}