package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserStat implements Parcelable {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("historical")
    @Expose
    private Historical historical;

    public final static Parcelable.Creator<UserStat> CREATOR = new Creator<UserStat>() {

        @SuppressWarnings({
        "unchecked"
        })
        public UserStat createFromParcel(Parcel in) {
        return new UserStat(in);
        }

        public UserStat[] newArray(int size) {
        return (new UserStat[size]);
        }

    };

    protected UserStat(Parcel in) {
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.historical = ((Historical) in.readValue((Historical.class.getClassLoader())));
    }

    public UserStat() {
    }

    public Integer getTotal() {
    return total;
    }

    public void setTotal(Integer total) {
    this.total = total;
    }

    public Historical getHistorical() {
    return historical;
    }

    public void setHistorical(Historical historical) {
    this.historical = historical;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(total);
        dest.writeValue(historical);
    }

    public int describeContents() {
    return 0;
    }

}