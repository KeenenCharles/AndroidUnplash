package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentUserCollection implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("curated")
    @Expose
    private Boolean curated;
    @SerializedName("cover_photo")
    @Expose
    private Object coverPhoto;
    @SerializedName("user")
    @Expose
    private Object user;
    public final static Creator < CurrentUserCollection > CREATOR = new Creator < CurrentUserCollection > () {


        @SuppressWarnings({
                "unchecked"
        })
        public CurrentUserCollection createFromParcel(Parcel in ) {
            return new CurrentUserCollection( in );
        }

        public CurrentUserCollection[] newArray(int size) {
            return (new CurrentUserCollection[size]);
        }

    };

    protected CurrentUserCollection(Parcel in ) {
        this.id = ((Integer) in .readValue((Integer.class.getClassLoader())));
        this.title = ((String) in .readValue((String.class.getClassLoader())));
        this.publishedAt = ((String) in .readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in .readValue((String.class.getClassLoader())));
        this.curated = ((Boolean) in .readValue((Boolean.class.getClassLoader())));
        this.coverPhoto = ((Object) in .readValue((Object.class.getClassLoader())));
        this.user = ((Object) in .readValue((Object.class.getClassLoader())));
    }

    public CurrentUserCollection() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getCurated() {
        return curated;
    }

    public void setCurated(Boolean curated) {
        this.curated = curated;
    }

    public Object getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(Object coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(publishedAt);
        dest.writeValue(updatedAt);
        dest.writeValue(curated);
        dest.writeValue(coverPhoto);
        dest.writeValue(user);
    }

    public int describeContents() {
        return 0;
    }

}
