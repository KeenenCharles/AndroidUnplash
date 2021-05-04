package com.keenencharles.unsplash.api

enum class Orientation private constructor(orientation: String) {

    LANDSCAPE("landscape"),
    PORTRAIT("portrait"),
    SQUARISH("squarish");

    var orientation: String
        internal set

    init {
        this.orientation = orientation
    }
}
