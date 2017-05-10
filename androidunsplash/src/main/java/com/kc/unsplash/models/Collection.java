
package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collection implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("curated")
    @Expose
    private Boolean curated;
    @SerializedName("total_photos")
    @Expose
    private Integer totalPhotos;
    @SerializedName("private")
    @Expose
    private Boolean _private;
    @SerializedName("share_key")
    @Expose
    private String shareKey;
    @SerializedName("cover_photo")
    @Expose
    private CoverPhoto coverPhoto;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("links")
    @Expose
    private Links links;
    public final static Creator<Collection> CREATOR = new Creator<Collection>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Collection createFromParcel(Parcel in) {
            Collection instance = new Collection();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.publishedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.curated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.totalPhotos = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance._private = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.shareKey = ((String) in.readValue((String.class.getClassLoader())));
            instance.coverPhoto = ((CoverPhoto) in.readValue((CoverPhoto.class.getClassLoader())));
            instance.user = ((User) in.readValue((User.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Collection[] newArray(int size) {
            return (new Collection[size]);
        }

    }
    ;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public Boolean getPrivate() {
        return _private;
    }

    public void setPrivate(Boolean _private) {
        this._private = _private;
    }

    public String getShareKey() {
        return shareKey;
    }

    public void setShareKey(String shareKey) {
        this.shareKey = shareKey;
    }

    public CoverPhoto getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(CoverPhoto coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(publishedAt);
        dest.writeValue(updatedAt);
        dest.writeValue(curated);
        dest.writeValue(totalPhotos);
        dest.writeValue(_private);
        dest.writeValue(shareKey);
        dest.writeValue(coverPhoto);
        dest.writeValue(user);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
