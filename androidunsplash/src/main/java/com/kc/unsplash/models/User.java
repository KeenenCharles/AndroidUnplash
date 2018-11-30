package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("instagram_username")
    @Expose
    private String instagramUsername;

    @SerializedName("twitter_username")
    @Expose
    private String twitterUsername;

    @SerializedName("portfolio_url")
    @Expose
    private Object portfolioUrl;

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

    @SerializedName("followed_by_user")
    @Expose
    private Boolean followedByUser;

    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;

    @SerializedName("following_count")
    @Expose
    private Integer followingCount;

    @SerializedName("downloads")
    @Expose
    private Integer downloads;

    @SerializedName("profile_image")
    @Expose
    private ProfileImage profileImage;

    @SerializedName("badge")
    @Expose
    private Badge badge;

    @SerializedName("links")
    @Expose
    private Links links;

    @SerializedName("current_user_collections")
    @Expose
    private List<CurrentUserCollection> currentUserCollections = null;

    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {

        @SuppressWarnings({"unchecked"})
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    };

    protected User(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.instagramUsername = ((String) in.readValue((String.class.getClassLoader())));
        this.twitterUsername = ((String) in.readValue((String.class.getClassLoader())));
        this.portfolioUrl = ((Object) in.readValue((Object.class.getClassLoader())));
        this.bio = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.totalLikes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPhotos = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalCollections = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.followedByUser = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.followersCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.followingCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.downloads = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.profileImage = ((ProfileImage) in.readValue((ProfileImage.class.getClassLoader())));
        this.badge = ((Badge) in.readValue((Badge.class.getClassLoader())));
        this.links = ((Links) in.readValue((Links.class.getClassLoader())));
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public void setInstagramUsername(String instagramUsername) {
        this.instagramUsername = instagramUsername;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public Object getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(Object portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Integer totalLikes) {
        this.totalLikes = totalLikes;
    }

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public Integer getTotalCollections() {
        return totalCollections;
    }

    public void setTotalCollections(Integer totalCollections) {
        this.totalCollections = totalCollections;
    }

    public Boolean getFollowedByUser() {
        return followedByUser;
    }

    public void setFollowedByUser(Boolean followedByUser) {
        this.followedByUser = followedByUser;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ProfileImage profileImage) {
        this.profileImage = profileImage;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<CurrentUserCollection> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<CurrentUserCollection> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(updatedAt);
        dest.writeValue(username);
        dest.writeValue(name);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(instagramUsername);
        dest.writeValue(twitterUsername);
        dest.writeValue(portfolioUrl);
        dest.writeValue(bio);
        dest.writeValue(location);
        dest.writeValue(totalLikes);
        dest.writeValue(totalPhotos);
        dest.writeValue(totalCollections);
        dest.writeValue(followedByUser);
        dest.writeValue(followersCount);
        dest.writeValue(followingCount);
        dest.writeValue(downloads);
        dest.writeValue(profileImage);
        dest.writeValue(badge);
        dest.writeValue(links);
        dest.writeList(currentUserCollections);
    }

    public int describeContents() {
        return 0;
    }

}