package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value implements Parcelable {

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("value")
    @Expose
    private Integer value;

    public final static Parcelable.Creator<Value> CREATOR = new Creator<Value>() {

        @SuppressWarnings({"unchecked"})
        public Value createFromParcel(Parcel in) {
        return new Value(in);
        }

        public Value[] newArray(int size) {
        return (new Value[size]);
        }

    };

    protected Value(Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.value = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Value() {
    }

    public String getDate() {
    return date;
    }

    public void setDate(String date) {
    this.date = date;
    }

    public Integer getValue() {
    return value;
    }

    public void setValue(Integer value) {
    this.value = value;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(value);
    }

    public int describeContents() {
return 0;
}

}