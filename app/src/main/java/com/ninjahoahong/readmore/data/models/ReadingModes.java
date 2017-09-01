package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class ReadingModes implements Parcelable {

	public abstract boolean image();

	public abstract boolean text();

	public static TypeAdapter<ReadingModes> typeAdapter(Gson gson) {
		return new AutoValue_ReadingModes.GsonTypeAdapter(gson);
	}
}