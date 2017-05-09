package com.kc.unsplash.api;

/**
 * Created by kcred on 5/9/2017.
 */

public enum Orientation {

    LANDSCAPE("landscape"),
    PORTRAIT("portrait"),
    SQUARISH("squarish");

    String orientation;

    Orientation(String orientation){
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }
}
