package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class SearchInfo implements Parcelable {

	public abstract String textSnippet();

	public static TypeAdapter<SearchInfo> typeAdapter(Gson gson) {
		return new AutoValue_SearchInfo.GsonTypeAdapter(gson);
	}
}