package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Exif implements Parcelable
{

    @SerializedName("make")
    @Expose
    private String make;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("exposure_time")
    @Expose
    private String exposureTime;
    @SerializedName("aperture")
    @Expose
    private String aperture;
    @SerializedName("focal_length")
    @Expose
    private String focalLength;
    @SerializedName("iso")
    @Expose
    private Integer iso;
    public final static Parcelable.Creator<Exif> CREATOR = new Creator<Exif>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Exif createFromParcel(Parcel in) {
            Exif instance = new Exif();
            instance.make = ((String) in.readValue((String.class.getClassLoader())));
            instance.model = ((String) in.readValue((String.class.getClassLoader())));
            instance.exposureTime = ((String) in.readValue((String.class.getClassLoader())));
            instance.aperture = ((String) in.readValue((String.class.getClassLoader())));
            instance.focalLength = ((String) in.readValue((String.class.getClassLoader())));
            instance.iso = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Exif[] newArray(int size) {
            return (new Exif[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Exif() {
    }

    /**
     * 
     * @param exposureTime
     * @param model
     * @param iso
     * @param make
     * @param aperture
     * @param focalLength
     */
    public Exif(String make, String model, String exposureTime, String aperture, String focalLength, Integer iso) {
        super();
        this.make = make;
        this.model = model;
        this.exposureTime = exposureTime;
        this.aperture = aperture;
        this.focalLength = focalLength;
        this.iso = iso;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Exif withMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Exif withModel(String model) {
        this.model = model;
        return this;
    }

    public String getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(String exposureTime) {
        this.exposureTime = exposureTime;
    }

    public Exif withExposureTime(String exposureTime) {
        this.exposureTime = exposureTime;
        return this;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public Exif withAperture(String aperture) {
        this.aperture = aperture;
        return this;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public Exif withFocalLength(String focalLength) {
        this.focalLength = focalLength;
        return this;
    }

    public Integer getIso() {
        return iso;
    }

    public void setIso(Integer iso) {
        this.iso = iso;
    }

    public Exif withIso(Integer iso) {
        this.iso = iso;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(make);
        dest.writeValue(model);
        dest.writeValue(exposureTime);
        dest.writeValue(aperture);
        dest.writeValue(focalLength);
        dest.writeValue(iso);
    }

    public int describeContents() {
        return  0;
    }

}
