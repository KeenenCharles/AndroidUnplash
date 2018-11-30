package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Badge implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("primary")
    @Expose
    private Boolean primary;

    @SerializedName("slug")
    @Expose
    private String slug;

    @SerializedName("link")
    @Expose
    private String link;

    public final static Parcelable.Creator<Badge> CREATOR = new Creator<Badge>() {

        @SuppressWarnings({"unchecked"})
        public Badge createFromParcel(Parcel in) {
            return new Badge(in);
        }

        public Badge[] newArray(int size) {
            return (new Badge[size]);
        }

    };

    protected Badge(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.primary = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.slug = ((String) in.readValue((String.class.getClassLoader())));
        this.link = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Badge() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(primary);
        dest.writeValue(slug);
        dest.writeValue(link);
    }

    public int describeContents() {
        return 0;
    }

}