package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class PanelizationSummary implements Parcelable {

	public abstract boolean containsImageBubbles();

	public abstract boolean containsEpubBubbles();

	public static TypeAdapter<PanelizationSummary> typeAdapter(Gson gson) {
		return new AutoValue_PanelizationSummary.GsonTypeAdapter(gson);
	}
}