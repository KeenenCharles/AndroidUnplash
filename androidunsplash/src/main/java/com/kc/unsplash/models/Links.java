package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable {

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

    @SerializedName("download")
    @Expose
    private String download;

    @SerializedName("download_location")
    @Expose
    private String downloadLocation;

    public final static Parcelable.Creator<Links> CREATOR = new Creator<Links>() {

        @SuppressWarnings({"unchecked"})
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        public Links[] newArray(int size) {
            return (new Links[size]);
        }

    };

    protected Links(Parcel in) {
        this.self = ((String) in.readValue((String.class.getClassLoader())));
        this.html = ((String) in.readValue((String.class.getClassLoader())));
        this.photos = ((String) in.readValue((String.class.getClassLoader())));
        this.likes = ((String) in.readValue((String.class.getClassLoader())));
        this.portfolio = ((String) in.readValue((String.class.getClassLoader())));
        this.download = ((String) in .readValue((String.class.getClassLoader())));
        this.downloadLocation = ((String) in .readValue((String.class.getClassLoader())));
    }

    public Links() {
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }

    public void setDownloadLocation(String downloadLocation) {
        this.downloadLocation = downloadLocation;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(self);
        dest.writeValue(html);
        dest.writeValue(photos);
        dest.writeValue(likes);
        dest.writeValue(portfolio);
        dest.writeValue(download);
        dest.writeValue(downloadLocation);
    }

    public int describeContents() {
        return 0;
    }

}