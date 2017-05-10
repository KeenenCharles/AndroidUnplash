package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats implements Parcelable {

    @SerializedName("total_photos")
    @Expose
    private Integer totalPhotos;
    @SerializedName("photo_downloads")
    @Expose
    private Integer photoDownloads;
    public final static Parcelable.Creator<Stats> CREATOR = new Creator<Stats>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Stats createFromParcel(Parcel in) {
            Stats instance = new Stats();
            instance.totalPhotos = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.photoDownloads = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Stats[] newArray(int size) {
            return (new Stats[size]);
        }

    }
            ;

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public Integer getPhotoDownloads() {
        return photoDownloads;
    }

    public void setPhotoDownloads(Integer photoDownloads) {
        this.photoDownloads = photoDownloads;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalPhotos);
        dest.writeValue(photoDownloads);
    }

    public int describeContents() {
        return 0;
    }

}