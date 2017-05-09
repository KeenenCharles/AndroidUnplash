package com.kc.unsplash.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urls implements Parcelable
{

    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("full")
    @Expose
    private String full;
    @SerializedName("regular")
    @Expose
    private String regular;
    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    public final static Parcelable.Creator<Urls> CREATOR = new Creator<Urls>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Urls createFromParcel(Parcel in) {
            Urls instance = new Urls();
            instance.raw = ((String) in.readValue((String.class.getClassLoader())));
            instance.full = ((String) in.readValue((String.class.getClassLoader())));
            instance.regular = ((String) in.readValue((String.class.getClassLoader())));
            instance.small = ((String) in.readValue((String.class.getClassLoader())));
            instance.thumb = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Urls[] newArray(int size) {
            return (new Urls[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Urls() {
    }

    /**
     * 
     * @param raw
     * @param regular
     * @param full
     * @param thumb
     * @param small
     */
    public Urls(String raw, String full, String regular, String small, String thumb) {
        super();
        this.raw = raw;
        this.full = full;
        this.regular = regular;
        this.small = small;
        this.thumb = thumb;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public Urls withRaw(String raw) {
        this.raw = raw;
        return this;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public Urls withFull(String full) {
        this.full = full;
        return this;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public Urls withRegular(String regular) {
        this.regular = regular;
        return this;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public Urls withSmall(String small) {
        this.small = small;
        return this;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Urls withThumb(String thumb) {
        this.thumb = thumb;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(raw);
        dest.writeValue(full);
        dest.writeValue(regular);
        dest.writeValue(small);
        dest.writeValue(thumb);
    }

    public int describeContents() {
        return  0;
    }

}
