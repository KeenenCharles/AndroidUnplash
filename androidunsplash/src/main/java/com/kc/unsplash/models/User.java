
package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("portfolio_url")
    @Expose
    private String portfolioUrl;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("total_likes")
    @Expose
    private Integer totalLikes;
    @SerializedName("total_photos")
    @Expose
    private Integer totalPhotos;
    @SerializedName("total_collections")
    @Expose
    private Integer totalCollections;
    @SerializedName("profile_image")
    @Expose
    private ProfileImage profileImage;
    @SerializedName("links")
    @Expose
    private Links links;
    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
            "unchecked"
        })
        public User createFromParcel(Parcel in) {
            User instance = new User();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.username = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.portfolioUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.bio = ((String) in.readValue((String.class.getClassLoader())));
            instance.location = ((String) in.readValue((String.class.getClassLoader())));
            instance.totalLikes = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.totalPhotos = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.totalCollections = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.profileImage = ((ProfileImage) in.readValue((ProfileImage.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public User() {
    }

    /**
     * 
     * @param id
     * @param totalLikes
     * @param username
     * @param profileImage
     * @param bio
     * @param location
     * @param portfolioUrl
     * @param name
     * @param totalPhotos
     * @param links
     * @param totalCollections
     */
    public User(String id, String username, String name, String portfolioUrl, String bio, String location, Integer totalLikes, Integer totalPhotos, Integer totalCollections, ProfileImage profileImage, Links links) {
        super();
        this.id = id;
        this.username = username;
        this.name = name;
        this.portfolioUrl = portfolioUrl;
        this.bio = bio;
        this.location = location;
        this.totalLikes = totalLikes;
        this.totalPhotos = totalPhotos;
        this.totalCollections = totalCollections;
        this.profileImage = profileImage;
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User withId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public User withPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User withBio(String bio) {
        this.bio = bio;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User withLocation(String location) {
        this.location = location;
        return this;
    }

    public Integer getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Integer totalLikes) {
        this.totalLikes = totalLikes;
    }

    public User withTotalLikes(Integer totalLikes) {
        this.totalLikes = totalLikes;
        return this;
    }

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public User withTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
        return this;
    }

    public Integer getTotalCollections() {
        return totalCollections;
    }

    public void setTotalCollections(Integer totalCollections) {
        this.totalCollections = totalCollections;
    }

    public User withTotalCollections(Integer totalCollections) {
        this.totalCollections = totalCollections;
        return this;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ProfileImage profileImage) {
        this.profileImage = profileImage;
    }

    public User withProfileImage(ProfileImage profileImage) {
        this.profileImage = profileImage;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public User withLinks(Links links) {
        this.links = links;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(username);
        dest.writeValue(name);
        dest.writeValue(portfolioUrl);
        dest.writeValue(bio);
        dest.writeValue(location);
        dest.writeValue(totalLikes);
        dest.writeValue(totalPhotos);
        dest.writeValue(totalCollections);
        dest.writeValue(profileImage);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
