package com.kc.unsplash.models;


import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Download implements Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    public final static Parcelable.Creator<Download> CREATOR = new Creator<Download>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Download createFromParcel(Parcel in) {
            return new Download(in);
        }

        public Download[] newArray(int size) {
            return (new Download[size]);
        }

    }
            ;

    protected Download(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Download() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
    }

    public int describeContents() {
        return 0;
    }

}