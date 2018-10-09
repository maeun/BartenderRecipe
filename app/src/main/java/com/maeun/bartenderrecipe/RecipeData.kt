package com.maeun.bartenderrecipe

import android.os.Parcel
import android.os.Parcelable

data class RecipeData(var name : String, var glass : String, var method : String, var garnish : String, var ratio : ArrayList<RatioData>, var bookmark : Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            TODO("ratio"),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(glass)
        parcel.writeString(method)
        parcel.writeString(garnish)
        parcel.writeInt(bookmark)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecipeData> {
        override fun createFromParcel(parcel: Parcel): RecipeData {
            return RecipeData(parcel)
        }

        override fun newArray(size: Int): Array<RecipeData?> {
            return arrayOfNulls(size)
        }
    }
}