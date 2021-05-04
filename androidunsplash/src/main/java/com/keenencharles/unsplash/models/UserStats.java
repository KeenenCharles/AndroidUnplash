package com.keenencharles.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserStats implements Parcelable {

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("downloads")
    @Expose
    private UserStat downloads;

    @SerializedName("views")
    @Expose
    private UserStat views;

    @SerializedName("likes")
    @Expose
    private UserStat likes;

    public final static Parcelable.Creator<UserStats> CREATOR = new Creator<UserStats>() {

        @SuppressWarnings({
        "unchecked"
        })
        public UserStats createFromParcel(Parcel in) {
        return new UserStats(in);
        }

        public UserStats[] newArray(int size) {
        return (new UserStats[size]);
        }

    };

    protected UserStats(Parcel in) {
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.downloads = ((UserStat) in.readValue((UserStat.class.getClassLoader())));
        this.views = ((UserStat) in.readValue((UserStat.class.getClassLoader())));
        this.likes = ((UserStat) in.readValue((UserStat.class.getClassLoader())));
    }

    public UserStats() {
    }

    public String getUsername() {
    return username;
    }

    public void setUsername(String username) {
    this.username = username;
    }

    public UserStat getDownloads() {
    return downloads;
    }

    public void setDownloads(UserStat downloads) {
    this.downloads = downloads;
    }

    public UserStat getViews() {
    return views;
    }

    public void setViews(UserStat views) {
    this.views = views;
    }

    public UserStat getLikes() {
    return likes;
    }

    public void setLikes(UserStat likes) {
    this.likes = likes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(downloads);
        dest.writeValue(views);
        dest.writeValue(likes);
    }

    public int describeContents() {
    return 0;
    }

}