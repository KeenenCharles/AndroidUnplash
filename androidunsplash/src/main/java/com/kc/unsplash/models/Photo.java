package com.kc.unsplash.models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("downloads")
    @Expose
    private Integer downloads;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;
    @SerializedName("exif")
    @Expose
    private Exif exif;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("current_user_collections")
    @Expose
    private List<Collection> currentUserCollections = new ArrayList<>();
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<>();
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("user")
    @Expose
    private User user;
    public final static Parcelable.Creator<Photo> CREATOR = new Creator<Photo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Photo createFromParcel(Parcel in) {
            Photo instance = new Photo();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.color = ((String) in.readValue((String.class.getClassLoader())));
            instance.downloads = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.likes = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.likedByUser = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.exif = ((Exif) in.readValue((Exif.class.getClassLoader())));
            instance.location = ((Location) in.readValue((Location.class.getClassLoader())));
            in.readList(instance.currentUserCollections, (Collection.class.getClassLoader()));
            instance.urls = ((Urls) in.readValue((Urls.class.getClassLoader())));
            in.readList(instance.categories, (Category.class.getClassLoader()));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            instance.user = ((User) in.readValue((User.class.getClassLoader())));
            return instance;
        }

        public Photo[] newArray(int size) {
            return (new Photo[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Photo() {
    }

    /**
     * 
     * @param exif
     * @param currentUserCollections
     * @param location
     * @param urls
     * @param width
     * @param links
     * @param downloads
     * @param id
     * @param updatedAt
     * @param height
     * @param color
     * @param createdAt
     * @param likes
     * @param categories
     * @param likedByUser
     * @param user
     */
    public Photo(String id, String createdAt, String updatedAt, Integer width, Integer height, String color, Integer downloads, Integer likes, Boolean likedByUser, Exif exif, Location location, List<Collection> currentUserCollections, Urls urls, List<Category> categories, Links links, User user) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.downloads = downloads;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.exif = exif;
        this.location = location;
        this.currentUserCollections = currentUserCollections;
        this.urls = urls;
        this.categories = categories;
        this.links = links;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Photo withId(String id) {
        this.id = id;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Photo withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Photo withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Photo withWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Photo withHeight(Integer height) {
        this.height = height;
        return this;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Photo withColor(String color) {
        this.color = color;
        return this;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Photo withDownloads(Integer downloads) {
        this.downloads = downloads;
        return this;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Photo withLikes(Integer likes) {
        this.likes = likes;
        return this;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public Photo withLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
        return this;
    }

    public Exif getExif() {
        return exif;
    }

    public void setExif(Exif exif) {
        this.exif = exif;
    }

    public Photo withExif(Exif exif) {
        this.exif = exif;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Photo withLocation(Location location) {
        this.location = location;
        return this;
    }

    public List<Collection> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Collection> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public Photo withCurrentUserCollections(List<Collection> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
        return this;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Photo withUrls(Urls urls) {
        this.urls = urls;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Photo withCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Photo withLinks(Links links) {
        this.links = links;
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Photo withUser(User user) {
        this.user = user;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(color);
        dest.writeValue(downloads);
        dest.writeValue(likes);
        dest.writeValue(likedByUser);
        dest.writeValue(exif);
        dest.writeValue(location);
        dest.writeList(currentUserCollections);
        dest.writeValue(urls);
        dest.writeList(categories);
        dest.writeValue(links);
        dest.writeValue(user);
    }

    public int describeContents() {
        return  0;
    }

}
