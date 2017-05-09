package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable
{

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("photos")
    @Expose
    private String photos;
    @SerializedName("likes")
    @Expose
    private String likes;
    @SerializedName("portfolio")
    @Expose
    private String portfolio;
    public final static Parcelable.Creator<Links> CREATOR = new Creator<Links>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links createFromParcel(Parcel in) {
            Links instance = new Links();
            instance.self = ((String) in.readValue((String.class.getClassLoader())));
            instance.html = ((String) in.readValue((String.class.getClassLoader())));
            instance.photos = ((String) in.readValue((String.class.getClassLoader())));
            instance.likes = ((String) in.readValue((String.class.getClassLoader())));
            instance.portfolio = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Links[] newArray(int size) {
            return (new Links[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links() {
    }

    /**
     * 
     * @param photos
     * @param portfolio
     * @param likes
     * @param html
     * @param self
     */
    public Links(String self, String html, String photos, String likes, String portfolio) {
        super();
        this.self = self;
        this.html = html;
        this.photos = photos;
        this.likes = likes;
        this.portfolio = portfolio;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Links withSelf(String self) {
        this.self = self;
        return this;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Links withHtml(String html) {
        this.html = html;
        return this;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public Links withPhotos(String photos) {
        this.photos = photos;
        return this;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public Links withLikes(String likes) {
        this.likes = likes;
        return this;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public Links withPortfolio(String portfolio) {
        this.portfolio = portfolio;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(self);
        dest.writeValue(html);
        dest.writeValue(photos);
        dest.writeValue(likes);
        dest.writeValue(portfolio);
    }

    public int describeContents() {
        return  0;
    }

}
