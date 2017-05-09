package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentUserCollection implements Parcelable
{

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
    private CoverPhoto coverPhoto;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("links")
    @Expose
    private Links links;
    public final static Parcelable.Creator<CurrentUserCollection> CREATOR = new Creator<CurrentUserCollection>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CurrentUserCollection createFromParcel(Parcel in) {
            CurrentUserCollection instance = new CurrentUserCollection();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.publishedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.curated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.coverPhoto = ((CoverPhoto) in.readValue((CoverPhoto.class.getClassLoader())));
            instance.user = ((User) in.readValue((User.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public CurrentUserCollection[] newArray(int size) {
            return (new CurrentUserCollection[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CurrentUserCollection() {
    }

    /**
     * 
     * @param updatedAt
     * @param publishedAt
     * @param id
     * @param title
     * @param coverPhoto
     * @param curated
     * @param links
     * @param user
     */
    public CurrentUserCollection(Integer id, String title, String publishedAt, String updatedAt, Boolean curated, CoverPhoto coverPhoto, User user, Links links) {
        super();
        this.id = id;
        this.title = title;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.curated = curated;
        this.coverPhoto = coverPhoto;
        this.user = user;
        this.links = links;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CurrentUserCollection withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CurrentUserCollection withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public CurrentUserCollection withPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CurrentUserCollection withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Boolean getCurated() {
        return curated;
    }

    public void setCurated(Boolean curated) {
        this.curated = curated;
    }

    public CurrentUserCollection withCurated(Boolean curated) {
        this.curated = curated;
        return this;
    }

    public CoverPhoto getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(CoverPhoto coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public CurrentUserCollection withCoverPhoto(CoverPhoto coverPhoto) {
        this.coverPhoto = coverPhoto;
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CurrentUserCollection withUser(User user) {
        this.user = user;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public CurrentUserCollection withLinks(Links links) {
        this.links = links;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(publishedAt);
        dest.writeValue(updatedAt);
        dest.writeValue(curated);
        dest.writeValue(coverPhoto);
        dest.writeValue(user);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
