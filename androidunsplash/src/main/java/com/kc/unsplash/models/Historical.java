package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Historical implements Parcelable {

    @SerializedName("change")
    @Expose
    private Integer change;

    @SerializedName("average")
    @Expose
    private Integer average;

    @SerializedName("resolution")
    @Expose
    private String resolution;

    @SerializedName("quantity")
    @Expose
    private Integer quantity;

    @SerializedName("values")
    @Expose
    private List<Value> values = null;

    public final static Parcelable.Creator<Historical> CREATOR = new Creator<Historical>() {

        @SuppressWarnings({
        "unchecked"
        })
        public Historical createFromParcel(Parcel in) {
        return new Historical(in);
        }

        public Historical[] newArray(int size) {
        return (new Historical[size]);
        }

    };

    protected Historical(Parcel in) {
        this.change = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.average = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.resolution = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.values, (com.kc.unsplash.models.Value.class.getClassLoader()));
    }

    public Historical() {
    }

    public Integer getChange() {
    return change;
    }

    public void setChange(Integer change) {
    this.change = change;
    }

    public Integer getAverage() {
    return average;
    }

    public void setAverage(Integer average) {
    this.average = average;
    }

    public String getResolution() {
    return resolution;
    }

    public void setResolution(String resolution) {
    this.resolution = resolution;
    }

    public Integer getQuantity() {
    return quantity;
    }

    public void setQuantity(Integer quantity) {
    this.quantity = quantity;
    }

    public List<Value> getValues() {
    return values;
    }

    public void setValues(List<Value> values) {
    this.values = values;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(change);
        dest.writeValue(average);
        dest.writeValue(resolution);
        dest.writeValue(quantity);
        dest.writeList(values);
    }

    public int describeContents() {
    return 0;
    }

}