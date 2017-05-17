package com.kc.unsplash.models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoverPhoto implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<>();
    @SerializedName("links")
    @Expose
    private Links links;
    public final static Parcelable.Creator<CoverPhoto> CREATOR = new Creator<CoverPhoto>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CoverPhoto createFromParcel(Parcel in) {
            CoverPhoto instance = new CoverPhoto();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.color = ((String) in.readValue((String.class.getClassLoader())));
            instance.likes = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.likedByUser = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.user = ((User) in.readValue((User.class.getClassLoader())));
            instance.urls = ((Urls) in.readValue((Urls.class.getClassLoader())));
            in.readList(instance.categories, (Category.class.getClassLoader()));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public CoverPhoto[] newArray(int size) {
            return (new CoverPhoto[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CoverPhoto() {
    }

    /**
     * 
     * @param id
     * @param height
     * @param color
     * @param urls
     * @param likes
     * @param width
     * @param links
     * @param categories
     * @param likedByUser
     * @param user
     */
    public CoverPhoto(String id, Integer width, Integer height, String color, Integer likes, Boolean likedByUser, User user, Urls urls, List<Category> categories, Links links) {
        super();
        this.id = id;
        this.width = width;
        this.height = height;
        this.color = color;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.user = user;
        this.urls = urls;
        this.categories = categories;
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CoverPhoto withId(String id) {
        this.id = id;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public CoverPhoto withWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public CoverPhoto withHeight(Integer height) {
        this.height = height;
        return this;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CoverPhoto withColor(String color) {
        this.color = color;
        return this;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public CoverPhoto withLikes(Integer likes) {
        this.likes = likes;
        return this;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public CoverPhoto withLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CoverPhoto withUser(User user) {
        this.user = user;
        return this;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public CoverPhoto withUrls(Urls urls) {
        this.urls = urls;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public CoverPhoto withCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public CoverPhoto withLinks(Links links) {
        this.links = links;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(color);
        dest.writeValue(likes);
        dest.writeValue(likedByUser);
        dest.writeValue(user);
        dest.writeValue(urls);
        dest.writeList(categories);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
