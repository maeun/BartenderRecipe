package com.maeun.bartenderrecipe

import android.os.Parcel
import android.os.Parcelable

data class RatioData(var base : String, var amount : String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(base)
        parcel.writeString(amount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RatioData> {
        override fun createFromParcel(parcel: Parcel): RatioData {
            return RatioData(parcel)
        }

        override fun newArray(size: Int): Array<RatioData?> {
            return arrayOfNulls(size)
        }
    }
}