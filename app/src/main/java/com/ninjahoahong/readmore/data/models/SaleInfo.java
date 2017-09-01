package com.ninjahoahong.readmore.data.models;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class SaleInfo implements Parcelable {

	public abstract String country();

	public abstract boolean isEbook();

	public abstract String saleability();

	public static TypeAdapter<SaleInfo> typeAdapter(Gson gson) {
		return new AutoValue_SaleInfo.GsonTypeAdapter(gson);
	}
}