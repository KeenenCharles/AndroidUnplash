package com.keenencharles.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token implements Parcelable {

    @SerializedName("access_token")
    @Expose
    private String accessToken;

    @SerializedName("token_type")
    @Expose
    private String tokenType;

    @SerializedName("scope")
    @Expose
    private String scope;

    @SerializedName("created_at")
    @Expose
    private Integer createdAt;

    public final static Parcelable.Creator<Token> CREATOR = new Creator<Token>() {


    @SuppressWarnings({
    "unchecked"
    })
    public Token createFromParcel(Parcel in) {
    return new Token(in);
    }

    public Token[] newArray(int size) {
    return (new Token[size]);
    }

    }
    ;

    protected Token(Parcel in) {
        this.accessToken = ((String) in.readValue((String.class.getClassLoader())));
        this.tokenType = ((String) in.readValue((String.class.getClassLoader())));
        this.scope = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Token() {
    }

    public String getAccessToken() {
    return accessToken;
    }

    public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    }

    public String getTokenType() {
    return tokenType;
    }

    public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
    }

    public String getScope() {
    return scope;
    }

    public void setScope(String scope) {
    this.scope = scope;
    }

    public Integer getCreatedAt() {
    return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
    this.createdAt = createdAt;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(accessToken);
        dest.writeValue(tokenType);
        dest.writeValue(scope);
        dest.writeValue(createdAt);
    }

    public int describeContents() {
    return 0;
    }

}