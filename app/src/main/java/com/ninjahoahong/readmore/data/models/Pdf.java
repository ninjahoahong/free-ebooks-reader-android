package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Pdf implements Parcelable {

	public abstract boolean isAvailable();

	public static TypeAdapter<Pdf> typeAdapter(Gson gson) {
		return new AutoValue_Pdf.GsonTypeAdapter(gson);
	}
}