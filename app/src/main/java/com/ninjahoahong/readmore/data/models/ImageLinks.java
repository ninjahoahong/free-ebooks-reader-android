package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class ImageLinks implements Parcelable {

	public abstract String thumbnail();

	public abstract String smallThumbnail();

	public static TypeAdapter<ImageLinks> typeAdapter(Gson gson) {
		return new AutoValue_ImageLinks.GsonTypeAdapter(gson);
	}
}