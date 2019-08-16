package com.kc.unsplash.api;

public enum Scope {

    PUBLIC("public"),
    READ_USER("read_user"),
    WRITE_USER("write_user"),
    READ_PHOTOS("read_photos"),
    WRITE_PHOTOS("write_photos"),
    WRITE_LIKES("write_likes"),
    WRITE_FOLLOWERS("write_likes"),
    WRITE_COLLECTIONS("write_collections"),
    READ_COLLECTIONS("read_collections");

    private String scope;

    Scope(String scope){
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }
}
